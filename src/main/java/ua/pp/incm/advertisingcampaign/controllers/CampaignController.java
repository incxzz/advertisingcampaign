/**
 * CampaignController
 * ... .
 * Date: 19.08.2019
 * Time: 13:05
 *
 * @author : Mahony Y. A. aka incm
 */

package ua.pp.incm.advertisingcampaign.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.pp.incm.advertisingcampaign.exceptions.DataInconsistencyException;
import ua.pp.incm.advertisingcampaign.models.Campaign;
import ua.pp.incm.advertisingcampaign.models.requests.CampaignWithAdsId;
import ua.pp.incm.advertisingcampaign.services.ICampaignService;

@Controller
public class CampaignController {
   private ICampaignService campaignService;

   public CampaignController(@Autowired ICampaignService campaignService) {
     this.campaignService = campaignService;
   }

   @RequestMapping(method = RequestMethod.GET, value="/campaign/{id}")
   @ResponseBody
   public ResponseEntity<Campaign> getCampaign(@PathVariable Integer id) {
     Campaign campaign = campaignService.getCampaignById(id);
     if(campaign != null){
       return new ResponseEntity<>(campaign, HttpStatus.OK);
     }else{
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
   }


   @RequestMapping(method = RequestMethod.POST, value="/campaign")
   @ResponseBody
   public Campaign postCampaign(@RequestBody CampaignWithAdsId campaignWithAdsId) throws SQLException, DataInconsistencyException {
     return campaignService.postCampaignWithAdsIds(campaignWithAdsId);
   }


}
