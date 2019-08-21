package ua.pp.incm.advertisingcampaign.models.requests;

import java.io.Serializable;
import java.util.List;

public class SearchCriteria implements Serializable
{
   private static final long serialVersionUID = 2382970689158681480L;
   private Integer itemsCount;
   private Integer page;
   private List<Criteria> criteries;
   private List<SortingField> sortingFields;

   public SearchCriteria()
   {
   }

   public SearchCriteria(Integer itemsCount, Integer page, List<Criteria> criteries, List<SortingField> sortingFields)
   {
      super();
      this.itemsCount = itemsCount;
      this.page = page;
      this.criteries = criteries;
      this.sortingFields = sortingFields;
   }

   public Integer getItemsCount()
   {
      return itemsCount;
   }

   public void setItemsCount(Integer itemsCount)
   {
      this.itemsCount = itemsCount;
   }

   public Integer getPage()
   {
      return page;
   }

   public void setPage(Integer page)
   {
      this.page = page;
   }

   public List<Criteria> getCriteries()
   {
      return criteries;
   }

   public void setCriteries(List<Criteria> criteries)
   {
      this.criteries = criteries;
   }

   public List<SortingField> getSortingFields()
   {
      return sortingFields;
   }

   public void setSortingFields(List<SortingField> sortingFields)
   {
      this.sortingFields = sortingFields;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((criteries == null) ? 0 : criteries.hashCode());
      result = prime * result + ((itemsCount == null) ? 0 : itemsCount.hashCode());
      result = prime * result + ((page == null) ? 0 : page.hashCode());
      result = prime * result + ((sortingFields == null) ? 0 : sortingFields.hashCode());
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
      SearchCriteria other = (SearchCriteria) obj;
      if (criteries == null)
      {
         if (other.criteries != null)
            return false;
      }
      else if (!criteries.equals(other.criteries))
         return false;
      if (itemsCount == null)
      {
         if (other.itemsCount != null)
            return false;
      }
      else if (!itemsCount.equals(other.itemsCount))
         return false;
      if (page == null)
      {
         if (other.page != null)
            return false;
      }
      else if (!page.equals(other.page))
         return false;
      if (sortingFields == null)
      {
         if (other.sortingFields != null)
            return false;
      }
      else if (!sortingFields.equals(other.sortingFields))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "SearchCriteria [itemsCount=" + itemsCount + ", page=" + page + ", criteries=" + criteries
            + ", sortingFields=" + sortingFields + "]";
   }

}
