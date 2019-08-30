package ua.pp.incm.advertisingcampaign.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.incm.advertisingcampaign.exceptions.DataInconsistencyException;
import ua.pp.incm.advertisingcampaign.models.Advertisement;
import ua.pp.incm.advertisingcampaign.models.requests.AdvertisementWithCampaignId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;
import ua.pp.incm.advertisingcampaign.repositories.IAdvertisementRepository;
import ua.pp.incm.advertisingcampaign.repositories.ICampaignRepository;
import ua.pp.incm.advertisingcampaign.services.IDataTransformerService;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class AdvertisementRepository implements IAdvertisementRepository
{
  private static final String SELECT_ADS_SQL = "select id, name, status, asset_url from advertisements where id=?";
  private static final String SELECT_ADS_IN_SQL = "select id, name, status, asset_url from advertisements where id in (?)";
  private static final String INSERT_ADS_SQL = "insert into advertisements (name, status, asset_url) values(?, ?, ?)";
  private static final String INSERT_CAMP_ADS_SQL = "insert into campaign_ads(campaign, ads) values(?, ?)";

  private Logger log = LoggerFactory.getLogger(this.getClass());
  private JdbcTemplate jdbcTemplate;
  private ICampaignRepository campaignRepository; 
  private IDataTransformerService dataTransformerService; 

  public AdvertisementRepository(@Autowired JdbcTemplate jdbcTemplate, @Autowired IDataTransformerService dataTransformerService)
   {
      this.jdbcTemplate = jdbcTemplate;
      this.dataTransformerService = dataTransformerService;

      AdvertisementWithCampaignId advertisementWithCampaignId = new AdvertisementWithCampaignId(10, "test ads", 1, null,"url", 1);
      try {
        Advertisement ad = postAdvertisementWithCampaignId(advertisementWithCampaignId);
        ad = postAdvertisementWithCampaignId(advertisementWithCampaignId);
        ad = postAdvertisementWithCampaignId(advertisementWithCampaignId);
        log.info(ad.toString());
      }catch (Exception e){
        e.printStackTrace();
        log.error(e.getMessage());
      }

   }

   public void setCampaignRepository(ICampaignRepository campaignRepository){
      this.campaignRepository = campaignRepository;
   }

   @Override
   public Advertisement getAdvertisementById(Integer id)
   {
     List<Advertisement> result = jdbcTemplate.query(SELECT_ADS_SQL, new Object[] { id }, new AdvertisementRowMapper());
     return result.size() == 1 ? result.get(0) : null;
   }

   @Override
   public List<Advertisement> getAdvertisementsByIds(List<Integer> ids){
      return jdbcTemplate.query(SELECT_ADS_IN_SQL, new Object[] { dataTransformerService.getStringFromList(ids, ',') }, new AdvertisementRowMapper());
   }
   
   @Override
   public List<Advertisement> getAdvertisementsByCriteria(SearchCriteria criteria)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   @Transactional(propagation= Propagation.REQUIRED)
   public Advertisement postAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId) throws SQLException, DataInconsistencyException {

     if(advertisementWithCampaignId.getCampaignId() == null){
       throw new DataInconsistencyException("Ads has not any campaign", -1);
     }

     if(advertisementWithCampaignId.getPlatforms() == null || advertisementWithCampaignId.getPlatforms().size() < 1){
       throw new DataInconsistencyException("Ads has not any platforms", -1);
     }
     
     if(campaignRepository.getCampaignById(advertisementWithCampaignId.getCampaignId()) == null){
        throw new DataInconsistencyException("Ads contain nonexistent campaign", -2); 
     }

     KeyHolder keyAds = new GeneratedKeyHolder();
     int res =
         jdbcTemplate.update(connection -> {
           PreparedStatement ps = connection.prepareStatement(INSERT_ADS_SQL, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, advertisementWithCampaignId.getName());
           ps.setInt(2, advertisementWithCampaignId.getStatus());
           ps.setString(3, advertisementWithCampaignId.getAssetUrl());
           return ps;
         }, keyAds);
     if(res <= 0){
       throw new SQLException("Error insert new ads");
     }

     res = jdbcTemplate.update(INSERT_CAMP_ADS_SQL, advertisementWithCampaignId.getCampaignId(), keyAds.getKey().intValue());
     if(res <= 0){
       throw new SQLException("Error insert links campaign to ads");
     }

     return getAdvertisementById(keyAds.getKey().intValue());
   }

   @Override
   public Advertisement putAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Boolean deleteAdvertisementById(Integer id)
   {
      // TODO Auto-generated method stub
      return null;
   }
   
   class AdvertisementRowMapper implements RowMapper<Advertisement> {
      @Override
      public Advertisement mapRow(ResultSet rs, int rowNum) throws SQLException {
         Advertisement advertisement = new Advertisement();
         advertisement.setId(rs.getInt("id"));
         advertisement.setName(rs.getString("name"));
         advertisement.setStatus(rs.getInt("status"));
         advertisement.setAssetUrl(rs.getString("asset_url"));
         return advertisement;
      }

   }

}
