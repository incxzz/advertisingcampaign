package ua.pp.incm.advertisingcampaign.services;

import java.util.List;

import ua.pp.incm.advertisingcampaign.exceptions.DataInconsistencyException;
import ua.pp.incm.advertisingcampaign.models.Campaign;
import ua.pp.incm.advertisingcampaign.models.requests.CampaignWithAdsId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;
import ua.pp.incm.advertisingcampaign.models.responses.CampaignSummary;

public interface ICampaignService
{
   Campaign getCampaignById(Integer id);
   List<Campaign> getCampaignsByCriteria(SearchCriteria criteria);
   List<CampaignSummary> getSummariesByCriteria(SearchCriteria criteria);
   Campaign postCampaignWithAdsIds(CampaignWithAdsId campaignWithAdsId) throws DataInconsistencyException;
   Campaign putCampaignWithAdsIds(CampaignWithAdsId campaignWithAdsId);
   Boolean deleteCampaignById(Integer id);
}
