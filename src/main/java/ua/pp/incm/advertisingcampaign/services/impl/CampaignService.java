/**
 * CampaignService
 * ... .
 * Date: 19.08.2019
 * Time: 13:04
 *
 * @author : Mahony Y. A. aka incm
 */

package ua.pp.incm.advertisingcampaign.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.pp.incm.advertisingcampaign.exceptions.DataInconsistencyException;
import ua.pp.incm.advertisingcampaign.models.Campaign;
import ua.pp.incm.advertisingcampaign.models.requests.CampaignWithAdsId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;
import ua.pp.incm.advertisingcampaign.models.responses.CampaignSummary;
import ua.pp.incm.advertisingcampaign.repositories.ICampaignRepository;
import ua.pp.incm.advertisingcampaign.services.ICampaignService;

@Service
public class CampaignService implements ICampaignService{

   private ICampaignRepository campaignRepository;

   public CampaignService(@Autowired ICampaignRepository campaignRepository)
   {
      this.campaignRepository = campaignRepository;
   }

   @Override
   public Campaign getCampaignById(Integer id)
   {
      return campaignRepository.getCampaignById(id);
   }

   @Override
   public List<Campaign> getCampaignsByCriteria(SearchCriteria criteria)
   {
      return campaignRepository.getCampaignsByCriteria(criteria);
   }

   @Override
   public List<CampaignSummary> getSummariesByCriteria(SearchCriteria criteria)
   {
      return campaignRepository.getSummariesByCriteria(criteria);
   }

   @Override
   public Campaign postCampaignWithAdsIds(CampaignWithAdsId campaignWithAdsId) throws DataInconsistencyException
   {
      return campaignRepository.postCampaignWithAdsIds(campaignWithAdsId);
   }

   @Override
   public Campaign putCampaignWithAdsIds(CampaignWithAdsId campaignWithAdsId)
   {
      return campaignRepository.putCampaignWithAdsIds(campaignWithAdsId);
   }

   @Override
   public Boolean deleteCampaignById(Integer id)
   {
      return campaignRepository.deleteCampaignById(id);
   }
}
