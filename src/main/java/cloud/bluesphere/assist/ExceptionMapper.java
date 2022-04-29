package cloud.bluesphere.assist;

import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ExceptionMapper {

  @ServerExceptionMapper
  public Response mapException(Throwable t) {
    if (t instanceof WebApplicationException){
      return ((WebApplicationException) t).getResponse();
    }else {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiErrorResult(ApiErrorCode.UNKNOWN_EXCEPTION, t.getMessage())).build();
    }
  }

}
