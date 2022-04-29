package cloud.bluesphere.assist;

import javax.ws.rs.core.Response;

public enum ApiErrorCode {

  UNKNOWN_EXCEPTION(Response.Status.INTERNAL_SERVER_ERROR),
  DEVICE_NOT_FOUND(Response.Status.NOT_FOUND);

  private final Response.Status status;

  ApiErrorCode(Response.Status status) {
    this.status = status;
  }

  public Response.Status getStatus() {
    return status;
  }
}
