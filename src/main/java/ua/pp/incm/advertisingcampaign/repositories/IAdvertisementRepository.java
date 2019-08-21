package ua.pp.incm.advertisingcampaign.repositories;

import java.util.List;

import ua.pp.incm.advertisingcampaign.models.Advertisement;
import ua.pp.incm.advertisingcampaign.models.requests.AdvertisementWithCampaignId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;

public interface IAdvertisementRepository
{
   Advertisement getAdvertisementById(Integer id);
   List<Advertisement> getAdvertisementsByCriteria(SearchCriteria criteria);
   Advertisement postAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId);
   Advertisement putAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId);
   Boolean deleteAdvertisementById(Integer id);
}
