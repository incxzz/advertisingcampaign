package ua.pp.incm.advertisingcampaign.models.requests;

import java.io.Serializable;

public class SortingField implements Serializable
{
   private static final long serialVersionUID = -1037732141418381610L;
   private String name;
   private Boolean ascending;

   public SortingField()
   {
   }

   public SortingField(String name, Boolean ascending)
   {
      super();
      this.name = name;
      this.ascending = ascending;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Boolean getAscending()
   {
      return ascending;
   }

   public void setAscending(Boolean ascending)
   {
      this.ascending = ascending;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((ascending == null) ? 0 : ascending.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
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
      SortingField other = (SortingField) obj;
      if (ascending == null)
      {
         if (other.ascending != null)
            return false;
      }
      else if (!ascending.equals(other.ascending))
         return false;
      if (name == null)
      {
         if (other.name != null)
            return false;
      }
      else if (!name.equals(other.name))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "SortingField [name=" + name + ", ascending=" + ascending + "]";
   }
   
}
