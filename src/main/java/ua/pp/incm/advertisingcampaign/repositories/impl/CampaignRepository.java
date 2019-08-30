package ua.pp.incm.advertisingcampaign.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.pp.incm.advertisingcampaign.exceptions.DataInconsistencyException;
import ua.pp.incm.advertisingcampaign.models.Advertisement;
import ua.pp.incm.advertisingcampaign.models.Campaign;
import ua.pp.incm.advertisingcampaign.models.requests.CampaignWithAdsId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;
import ua.pp.incm.advertisingcampaign.models.responses.CampaignSummary;
import ua.pp.incm.advertisingcampaign.repositories.IAdvertisementRepository;
import ua.pp.incm.advertisingcampaign.repositories.ICampaignRepository;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class CampaignRepository implements ICampaignRepository
{
   private static final String SELECT_CAMPAIGN_SQL = "select id, name, status, start_date, end_date from campaigns where id=?";
   private static final String INSERT_CAMPAIGN_SQL = "insert into campaigns (name, status, start_date, end_date) values(?, ?, ?, ?)";
   

   private Logger log = LoggerFactory.getLogger(this.getClass());
   private JdbcTemplate jdbcTemplate;
   private IAdvertisementRepository advertisementRepository;
   
   public CampaignRepository(@Autowired JdbcTemplate jdbcTemplate)
   {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Autowired
   public void setAdvertisementRepository(@Autowired IAdvertisementRepository advertisementRepository){
      this.advertisementRepository = advertisementRepository;
      if(this.advertisementRepository instanceof AdvertisementRepository){
         ((AdvertisementRepository) (this.advertisementRepository)).setCampaignRepository(this);
      }
      
   }

   @Override
   public Campaign getCampaignById(Integer id)
   {
      List<Campaign> result = jdbcTemplate.query(SELECT_CAMPAIGN_SQL, new Object[] { id }, new CampaignRowMapper());
      return result.size() == 1 ? result.get(0) : null;
   }

   @Override
   public List<Campaign> getCampaignsByCriteria(SearchCriteria criteria)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<CampaignSummary> getSummariesByCriteria(SearchCriteria criteria)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   @Transactional(propagation= Propagation.REQUIRED)
   public Campaign postCampaignWithAdsIds(CampaignWithAdsId campaignWithAdsId) throws DataInconsistencyException
   {
      if(campaignWithAdsId.getAds() == null){
         throw new DataInconsistencyException("Campaign has not any ads", -1);
      }
      List<Advertisement> ads = advertisementRepository.getAdvertisementsByIds(campaignWithAdsId.getAds());
      if(ads.size() != campaignWithAdsId.getAds().size()){
         throw new DataInconsistencyException("Campaign contain nonexistent ads", -1);
      }
      return null;
   }

   @Override
   public Campaign putCampaignWithAdsIds(CampaignWithAdsId campaignWithAdsId)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Boolean deleteCampaignById(Integer id)
   {
      // TODO Auto-generated method stub
      return null;
   }

   class CampaignRowMapper implements RowMapper<Campaign> {
      @Override
      public Campaign mapRow(ResultSet rs, int rowNum) throws SQLException {
         Campaign campaign = new Campaign();
         campaign.setId(rs.getInt("id"));
         campaign.setName(rs.getString("name"));
         campaign.setStatus(rs.getInt("status"));
         campaign.setStartDate(rs.getDate("start_date"));
         campaign.setEndDate(rs.getDate("end_date"));
         return campaign;
      }

   }
   
}
