package ua.pp.incm.advertisingcampaign.models.requests;

import java.io.Serializable;

public class Criteria implements Serializable
{
   private static final long serialVersionUID = -8200925593509009654L;
   private String field;
   private Object value;

   public Criteria()
   {
   }

   public Criteria(String field, Object value)
   {
      super();
      this.field = field;
      this.value = value;
   }

   public String getField()
   {
      return field;
   }

   public void setField(String field)
   {
      this.field = field;
   }

   public Object getValue()
   {
      return value;
   }

   public void setValue(Object value)
   {
      this.value = value;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((field == null) ? 0 : field.hashCode());
      result = prime * result + ((value == null) ? 0 : value.hashCode());
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
      Criteria other = (Criteria) obj;
      if (field == null)
      {
         if (other.field != null)
            return false;
      }
      else if (!field.equals(other.field))
         return false;
      if (value == null)
      {
         if (other.value != null)
            return false;
      }
      else if (!value.equals(other.value))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "Criteria [field=" + field + ", value=" + value + "]";
   }

}
