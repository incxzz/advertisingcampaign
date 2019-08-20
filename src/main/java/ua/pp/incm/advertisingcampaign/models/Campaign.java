/**
 * Campaign
 * ... .
 * Date: 19.08.2019
 * Time: 12:48
 *
 * @author : Mahony Y. A. aka incm
 */

package ua.pp.incm.advertisingcampaign.models;

import java.io.Serializable;
import java.util.Date;

public class Campaign extends CampaignBase implements Serializable
{
  private static final long serialVersionUID = -1674028527140787061L;
  private Date startDate;
  private Date endDate;

  public Campaign()
  {
  }
  
  public Campaign(int id, String name, int status, Date startDate, Date endDate)
  {
     super(id, name, status);
     this.startDate = startDate;
     this.endDate = endDate;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public void setStartDate(Date startDate)
  {
     this.startDate = startDate;
  }

  public Date getEndDate()
  {
     return endDate;
  }

  public void setEndDate(Date endDate)
  {
     this.endDate = endDate;
  }

  @Override
  public int hashCode()
  {
     final int prime = 31;
     int result = super.hashCode();
     result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
     result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
     Campaign other = (Campaign) obj;
     if (endDate == null)
     {
        if (other.endDate != null)
           return false;
     }
     else if (!endDate.equals(other.endDate))
        return false;
     if (startDate == null)
     {
        if (other.startDate != null)
           return false;
     }
     else if (!startDate.equals(other.startDate))
        return false;
     return true;
  }

  @Override
  public String toString()
  {
     return "Campaign [startDate=" + startDate + ", endDate=" + endDate + "]";
  }

}
