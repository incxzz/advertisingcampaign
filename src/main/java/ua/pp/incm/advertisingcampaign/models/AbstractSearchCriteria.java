package ua.pp.incm.advertisingcampaign.models;

public abstract class AbstractSearchCriteria
{
   private Integer page;
   private String name;

   public AbstractSearchCriteria(Integer page, String name)
   {
      super();
      this.page = page;
      this.name = name;
   }

   public Integer getPage()
   {
      return page;
   }

   public void setPage(Integer page)
   {
      this.page = page;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((page == null) ? 0 : page.hashCode());
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
      AbstractSearchCriteria other = (AbstractSearchCriteria) obj;
      if (name == null)
      {
         if (other.name != null)
            return false;
      }
      else if (!name.equals(other.name))
         return false;
      if (page == null)
      {
         if (other.page != null)
            return false;
      }
      else if (!page.equals(other.page))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "AbstractSearchCriteria [page=" + page + ", name=" + name + "]";
   }

}
