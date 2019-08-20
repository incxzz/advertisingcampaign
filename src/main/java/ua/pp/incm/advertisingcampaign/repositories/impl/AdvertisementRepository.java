package ua.pp.incm.advertisingcampaign.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ua.pp.incm.advertisingcampaign.models.Advertisement;
import ua.pp.incm.advertisingcampaign.models.requests.AdvertisementWithCampaignId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;
import ua.pp.incm.advertisingcampaign.repositories.IAdvertisementRepository;

@Repository
public class AdvertisementRepository implements IAdvertisementRepository
{
   JdbcTemplate jdbcTemplate;

   public AdvertisementRepository(JdbcTemplate jdbcTemplate)
   {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public Advertisement getAdvertisementById(Integer id)
   {
      return jdbcTemplate.queryForObject("select id, name, status, start_date, end_date from advertisements where id=?", new Object[] { id },
                                         new BeanPropertyRowMapper<Advertisement>(Advertisement.class));
   }

   @Override
   public List<Advertisement> getAdvertisementsByCriteria(SearchCriteria criteria)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Advertisement postAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId)
   {
      // TODO Auto-generated method stub
      return null;
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
         return advertisement;
      }

   }

}
