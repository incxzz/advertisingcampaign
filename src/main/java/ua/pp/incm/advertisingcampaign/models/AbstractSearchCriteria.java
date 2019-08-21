package ua.pp.incm.advertisingcampaign.models;

import java.util.Objects;

public abstract class AbstractSearchCriteria
{
   private Integer page;
   private Integer recordsCount;
   private String name;

   public AbstractSearchCriteria(Integer page, Integer recordsCount, String name) {
      this.page = page;
      this.recordsCount = recordsCount;
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

   public Integer getRecordsCount() {
      return recordsCount;
   }

   public void setRecordsCount(Integer recordsCount) {
      this.recordsCount = recordsCount;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof AbstractSearchCriteria)) return false;
      AbstractSearchCriteria that = (AbstractSearchCriteria) o;
      return Objects.equals(page, that.page) &&
          Objects.equals(recordsCount, that.recordsCount) &&
          Objects.equals(name, that.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(page, recordsCount, name);
   }

   @Override
   public String toString() {
      return "AbstractSearchCriteria{" +
          "page=" + page +
          ", recordsCount=" + recordsCount +
          ", name='" + name + '\'' +
          '}';
   }
}
