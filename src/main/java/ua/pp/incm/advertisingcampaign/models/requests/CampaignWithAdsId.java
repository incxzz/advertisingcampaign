package ua.pp.incm.advertisingcampaign.models.requests;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ua.pp.incm.advertisingcampaign.models.Campaign;

public class CampaignWithAdsId extends Campaign implements Serializable
{

   private static final long serialVersionUID = 5856209527476458267L;
   private List<Integer> ads;

   public CampaignWithAdsId()
   {
   }

   public CampaignWithAdsId(int id, String name, int status, Date startDate, Date endDate, List<Integer> ads)
   {
      super(id, name, status, startDate, endDate);
      this.ads = ads;
   }

   public List<Integer> getAds()
   {
      return ads;
   }

   public void setAds(List<Integer> ads)
   {
      this.ads = ads;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((ads == null) ? 0 : ads.hashCode());
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
      CampaignWithAdsId other = (CampaignWithAdsId) obj;
      if (ads == null)
      {
         if (other.ads != null)
            return false;
      }
      else if (!ads.equals(other.ads))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "CampaignWithAdsId [ads=" + ads + "]";
   }

}
