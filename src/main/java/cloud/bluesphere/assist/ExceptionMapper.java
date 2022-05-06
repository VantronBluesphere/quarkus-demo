package cloud.bluesphere.assist;

import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.validation.ConstraintViolationException;

public class ExceptionMapper {

  private static final Logger LOG = Logger.getLogger(ExceptionMapper.class);

//  @ServerExceptionMapper
//  public Uni<RestResponse<ApiErrorResult>> mapException(ConstraintViolationException t) {
//    LOG.warnf(t, "ConstraintViolationException occurred: ");
//    RestResponse<ApiErrorResult> restResponse = RestResponse.ResponseBuilder.<ApiErrorResult>create(RestResponse.Status.BAD_REQUEST).entity(new ApiErrorResult(ApiErrorCode.UNKNOWN_EXCEPTION, t.getMessage())).build();
//    return Uni.createFrom().item(restResponse);
//  }

  @ServerExceptionMapper
  public Uni<RestResponse<ApiErrorResult>> mapException(Exception t) {
    LOG.errorf(t, "Unexpected error occurred: ");
    RestResponse<ApiErrorResult> restResponse = RestResponse.ResponseBuilder.<ApiErrorResult>serverError().entity(new ApiErrorResult(ApiErrorCode.UNKNOWN_EXCEPTION, t.getMessage())).build();
    return Uni.createFrom().item(restResponse);
  }

}
