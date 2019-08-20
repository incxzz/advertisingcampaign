package ua.pp.incm.advertisingcampaign.models;

import java.io.Serializable;

public abstract class CampaignBase implements Serializable
{

   private static final long serialVersionUID = -4866440082872526894L;
   private int id;
   private String name;
   private int status;

   public CampaignBase()
   {
   }

   public CampaignBase(int id, String name, int status)
   {
      this.id = id;
      this.name = name;
      this.status = status;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public int getStatus()
   {
      return status;
   }

   public void setStatus(int status)
   {
      this.status = status;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + id;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + status;
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      CampaignBase other = (CampaignBase) obj;
      if (id != other.id)
         return false;
      if (name == null)
      {
         if (other.name != null)
            return false;
      }
      else if (!name.equals(other.name))
         return false;
      if (status != other.status)
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "CampaignBase [id=" + id + ", name=" + name + ", status=" + status + "]";
   }

}
