package ua.pp.incm.advertisingcampaign.models.responses;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ua.pp.incm.advertisingcampaign.models.Advertisement;
import ua.pp.incm.advertisingcampaign.models.Campaign;

public class CampaignWithAds extends Campaign implements Serializable
{
   private static final long serialVersionUID = -4236110613602995512L;
   private List<Advertisement> advertisements;

   public CampaignWithAds()
   {
   }

   public CampaignWithAds(int id, String name, int status, Date startDate, Date endDate, List<Advertisement> advertisements)
   {
      super(id, name, status, startDate, endDate);
      this.advertisements = advertisements;
   }

   public List<Advertisement> getAdvertisements()
   {
      return advertisements;
   }

   public void setAdvertisements(List<Advertisement> advertisements)
   {
      this.advertisements = advertisements;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((advertisements == null) ? 0 : advertisements.hashCode());
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
      CampaignWithAds other = (CampaignWithAds) obj;
      if (advertisements == null)
      {
         if (other.advertisements != null)
            return false;
      }
      else if (!advertisements.equals(other.advertisements))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "CampaignWithAds [advertisements=" + advertisements + "]";
   }

}
