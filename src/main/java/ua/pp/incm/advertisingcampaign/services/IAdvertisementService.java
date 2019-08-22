package ua.pp.incm.advertisingcampaign.services;

import ua.pp.incm.advertisingcampaign.exceptions.DataInconsistencyException;
import ua.pp.incm.advertisingcampaign.models.Advertisement;
import ua.pp.incm.advertisingcampaign.models.requests.AdvertisementWithCampaignId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;

import java.sql.SQLException;
import java.util.List;

public interface IAdvertisementService {
  Advertisement getAdvertisementById(Integer id);
  List<Advertisement> getAdvertisementsByCriteria(SearchCriteria criteria);
  Advertisement postAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId) throws SQLException, DataInconsistencyException;
  Advertisement putAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId);
  Boolean deleteAdvertisementById(Integer id);
}
