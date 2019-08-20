package ua.pp.incm.advertisingcampaign.repositories;

import java.util.List;

import ua.pp.incm.advertisingcampaign.models.Campaign;
import ua.pp.incm.advertisingcampaign.models.requests.CampaignWithAdsId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;
import ua.pp.incm.advertisingcampaign.models.responses.CampaignSummary;

public interface ICampaignRepository
{
   Campaign getCampaignById(Integer id);
   List<Campaign> getCampaignsByCriteria(SearchCriteria criteria);
   List<CampaignSummary> getSummariesByCriteria(SearchCriteria criteria);
   Campaign postCampaignWithAdsIds(CampaignWithAdsId campaignWithAdsId);
   Campaign putCampaignWithAdsIds(CampaignWithAdsId campaignWithAdsId);
   Boolean deleteCampaignById(Integer id);
}
