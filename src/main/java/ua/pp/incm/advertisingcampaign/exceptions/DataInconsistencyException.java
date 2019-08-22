/**
 * DataInconsistencyException
 * ... .
 * Date: 21.08.2019
 * Time: 17:24
 *
 * @author : Mahony Y. A. aka incm
 */

package ua.pp.incm.advertisingcampaign.exceptions;

public class DataInconsistencyException extends Exception {

  private static final long serialVersionUID = -9132991035979381658L;
  private Integer errorCode;

  public DataInconsistencyException(String message, Integer errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public String toString() {
    return "DataInconsistencyException{" +
        "errorCode=" + errorCode +
        "}\n" + super.toString();
  }
}
