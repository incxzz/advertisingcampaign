package ua.pp.incm.advertisingcampaign.models.responses;

import java.io.Serializable;

import ua.pp.incm.advertisingcampaign.models.CampaignBase;

public class CampaignSummary extends CampaignBase implements Serializable
{
   private static final long serialVersionUID = 6154475834324000246L;
   private int countAds;
   
   public CampaignSummary()
   {
   }

   public CampaignSummary(int id, String name, int status, int countAds)
   {
      super(id, name, status);
      this.countAds = countAds;
   }

   public int getCountAds()
   {
      return countAds;
   }

   public void setCountAds(int countAds)
   {
      this.countAds = countAds;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + countAds;
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
      CampaignSummary other = (CampaignSummary) obj;
      if (countAds != other.countAds)
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "CampaignSummary [countAds=" + countAds + "]";
   }

}
