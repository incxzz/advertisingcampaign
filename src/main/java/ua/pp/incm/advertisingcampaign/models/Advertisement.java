/**
 * Advertisement
 * ... .
 * Date: 19.08.2019
 * Time: 12:49
 *
 * @author : Mahony Y. A. aka incm
 */

package ua.pp.incm.advertisingcampaign.models;

import java.util.List;
import java.util.Objects;

public class Advertisement {
  @Id
  private int id;
  private String name;
  private int status;
  private List<Integer> platforms;
  private String assetUrl;

  public Advertisement() {
  }

  public Advertisement(int id, String name, int status, List<Integer> platforms, String assetUrl) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.platforms = platforms;
    this.assetUrl = assetUrl;
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

  public List<Integer> getPlatforms() {
    return platforms;
  }

  public void setPlatforms(List<Integer> platforms) {
    this.platforms = platforms;
  }

  public String getAssetUrl() {
    return assetUrl;
  }

  public void setAssetUrl(String assetUrl) {
    this.assetUrl = assetUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Advertisement)) return false;
    Advertisement that = (Advertisement) o;
    return id == that.id &&
        status == that.status &&
        Objects.equals(name, that.name) &&
        Objects.equals(platforms, that.platforms) &&
        Objects.equals(assetUrl, that.assetUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status, platforms, assetUrl);
  }

  @Override
  public String toString() {
    return "Advertisement{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", status=" + status +
        ", platforms=" + platforms +
        ", assetUrl='" + assetUrl + '\'' +
        '}';
  }
}
