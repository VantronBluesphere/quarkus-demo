package cloud.bluesphere.assist;

import javax.json.JsonObject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ApiException extends WebApplicationException {

  public ApiException(ApiErrorCode code) {
    super(Response.status(code.getStatus().getStatusCode()).entity(new ApiErrorResult(code)).build());
  }

  public ApiException(ApiErrorCode code, String description) {
    super(Response.status(code.getStatus().getStatusCode()).entity(new ApiErrorResult(code, description)).build());
  }

  public ApiException(ApiErrorCode code, String description, JsonObject data) {
    super(Response.status(code.getStatus().getStatusCode()).entity(new ApiErrorResult(code, description, data)).build());
  }

}
