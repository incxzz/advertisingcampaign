package ua.pp.incm.advertisingcampaign.repositories;

import java.sql.SQLException;
import java.util.List;

import ua.pp.incm.advertisingcampaign.exceptions.DataInconsistencyException;
import ua.pp.incm.advertisingcampaign.models.Advertisement;
import ua.pp.incm.advertisingcampaign.models.requests.AdvertisementWithCampaignId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;

public interface IAdvertisementRepository
{
   Advertisement getAdvertisementById(Integer id);
   List<Advertisement> getAdvertisementsByIds(List<Integer> ids);
   List<Advertisement> getAdvertisementsByCriteria(SearchCriteria criteria);
   Advertisement postAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId) throws SQLException, DataInconsistencyException;
   Advertisement putAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId);
   Boolean deleteAdvertisementById(Integer id);
}
