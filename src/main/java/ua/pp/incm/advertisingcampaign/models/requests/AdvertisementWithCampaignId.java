package ua.pp.incm.advertisingcampaign.models.requests;

import java.io.Serializable;
import java.util.List;

import ua.pp.incm.advertisingcampaign.models.Advertisement;

public class AdvertisementWithCampaignId extends Advertisement implements Serializable
{

  private static final long serialVersionUID = -4478378392479615615L;
  private Integer campaignId;

  public AdvertisementWithCampaignId() {
  }

  public AdvertisementWithCampaignId(int id, String name, int status, List<Integer> platforms, String assetUrl, Integer CampaignId)
  {
     super(id, name, status, platforms, assetUrl);
     this.campaignId = CampaignId;
  }

  public Integer getCampaignId()
  {
     return campaignId;
  }

  public void setCampaignId(Integer campaignId)
  {
    this.campaignId = campaignId;
  }

  @Override
  public int hashCode()
  {
     final int prime = 31;
     int result = super.hashCode();
     result = prime * result + ((campaignId == null) ? 0 : campaignId.hashCode());
     return result;
  }

  @Override
  public boolean equals(Object obj)
  {
     if (this == obj)
        return true;
     if (!super.equals(obj))
        return false;
     if (getClass() != obj.getClass())
        return false;
     AdvertisementWithCampaignId other = (AdvertisementWithCampaignId) obj;
     if (campaignId == null)
     {
        if (other.campaignId != null)
           return false;
     }
     else if (!campaignId.equals(other.campaignId))
        return false;
     return true;
  }

}
