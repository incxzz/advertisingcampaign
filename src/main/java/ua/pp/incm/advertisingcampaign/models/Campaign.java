/**
 * Campaign
 * ... .
 * Date: 19.08.2019
 * Time: 12:48
 *
 * @author : Mahony Y. A. aka incm
 */

package ua.pp.incm.advertisingcampaign.models;

import java.util.Date;
import java.util.Objects;

public class Campaign {
  private int id;
  private String name;
  private int status;
  private Date startDate;
  private Date endDate;

  public Campaign() {
  }

  public Campaign(int id, String name, int status, Date startDate, Date endDate) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Campaign)) return false;
    Campaign campaign = (Campaign) o;
    return id == campaign.id &&
        status == campaign.status &&
        Objects.equals(name, campaign.name) &&
        Objects.equals(startDate, campaign.startDate) &&
        Objects.equals(endDate, campaign.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status, startDate, endDate);
  }

  @Override
  public String toString() {
    return "Campaign{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", status=" + status +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        '}';
  }
}
