/**
 * AdvertisementController
 * ... .
 * Date: 19.08.2019
 * Time: 13:05
 *
 * @author : Mahony Y. A. aka incm
 */

package ua.pp.incm.advertisingcampaign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.pp.incm.advertisingcampaign.exceptions.DataInconsistencyException;
import ua.pp.incm.advertisingcampaign.models.Advertisement;
import ua.pp.incm.advertisingcampaign.models.requests.AdvertisementWithCampaignId;
import ua.pp.incm.advertisingcampaign.services.IAdvertisementService;

import java.sql.SQLException;

@Controller
public class AdvertisementController {

  private IAdvertisementService advertisementService;

  public AdvertisementController(@Autowired IAdvertisementService advertisementService) {
    this.advertisementService = advertisementService;
  }

  @RequestMapping(method = RequestMethod.GET, value="/ad/{id}")
  @ResponseBody
  public ResponseEntity<Advertisement> getAdvertisement(@PathVariable Integer id) {
    Advertisement advertisement = advertisementService.getAdvertisementById(id);
    if(advertisement != null){
      return new ResponseEntity<>(advertisement, HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  @RequestMapping(method = RequestMethod.POST, value="/ad")
  @ResponseBody
  public Advertisement postAdvertisement(@RequestBody AdvertisementWithCampaignId advertisementWithCampaignId) throws SQLException, DataInconsistencyException {
    return advertisementService.postAdvertisementWithCampaignId(advertisementWithCampaignId);
  }

/*  @ResponseStatus(code = HttpStatus.FAILED_DEPENDENCY)
  class CustomException extends DataInconsistencyException {
    public CustomException(String message, Integer errorCode) {
      super(message, errorCode);
    }
  }*/

}
