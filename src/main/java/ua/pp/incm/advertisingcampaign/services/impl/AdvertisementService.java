/**
 * AdvertisementService
 * ... .
 * Date: 19.08.2019
 * Time: 13:04
 *
 * @author : Mahony Y. A. aka incm
 */

package ua.pp.incm.advertisingcampaign.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.incm.advertisingcampaign.exceptions.DataInconsistencyException;
import ua.pp.incm.advertisingcampaign.models.Advertisement;
import ua.pp.incm.advertisingcampaign.models.requests.AdvertisementWithCampaignId;
import ua.pp.incm.advertisingcampaign.models.requests.SearchCriteria;
import ua.pp.incm.advertisingcampaign.repositories.IAdvertisementRepository;
import ua.pp.incm.advertisingcampaign.services.IAdvertisementService;

import java.sql.SQLException;
import java.util.List;

@Service
public class AdvertisementService implements IAdvertisementService {

  private IAdvertisementRepository advertisementRepository;

  public AdvertisementService(@Autowired IAdvertisementRepository advertisementRepository) {
    this.advertisementRepository = advertisementRepository;
  }

  @Override
  public Advertisement getAdvertisementById(Integer id) {
    return advertisementRepository.getAdvertisementById(id);
  }

  @Override
  public List<Advertisement> getAdvertisementsByCriteria(SearchCriteria criteria) {
    return null;
  }

  @Override
  public Advertisement postAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId) throws SQLException, DataInconsistencyException {
    return advertisementRepository.postAdvertisementWithCampaignId(advertisementWithCampaignId);
  }

  @Override
  public Advertisement putAdvertisementWithCampaignId(AdvertisementWithCampaignId advertisementWithCampaignId) {
    return null;
  }

  @Override
  public Boolean deleteAdvertisementById(Integer id) {
    return null;
  }
}
