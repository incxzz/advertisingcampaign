package ua.pp.incm.advertisingcampaign.models.requests;

import java.io.Serializable;
import java.util.List;

import ua.pp.incm.advertisingcampaign.models.Advertisement;

public class AdvertisementWithCampaignId extends Advertisement implements Serializable
{

  private static final long serialVersionUID = -4478378392479615615L;
  private Integer CampaignId;
  
  public AdvertisementWithCampaignId(int id, String name, int status, List<Integer> platforms, String assetUrl, Integer CampaignId)
  {
     super(id, name, status, platforms, assetUrl);
     this.CampaignId = CampaignId;
  }

  public Integer getCampaignId()
  {
     return CampaignId;
  }

  public void setCampaignId(Integer campaignId)
  {
    CampaignId = campaignId;
  }

  @Override
  public int hashCode()
  {
     final int prime = 31;
     int result = super.hashCode();
     result = prime * result + ((CampaignId == null) ? 0 : CampaignId.hashCode());
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
     if (CampaignId == null)
     {
        if (other.CampaignId != null)
           return false;
     }
     else if (!CampaignId.equals(other.CampaignId))
        return false;
     return true;
  }

}
