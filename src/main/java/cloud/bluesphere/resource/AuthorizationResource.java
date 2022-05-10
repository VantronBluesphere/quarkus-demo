package cloud.bluesphere.resource;

import io.smallrye.jwt.auth.principal.JWTCallerPrincipal;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestHeader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorizationResource {

  @Path("/pub/test")
  @GET
  public Uni<JsonObject> pub(@RestHeader("Authorization") String authorization,
                               @Context SecurityContext securityContext
  ) {
    JWTCallerPrincipal principal = (JWTCallerPrincipal) securityContext.getUserPrincipal();
    JsonObject jsonObject = Json.createObjectBuilder()
        .add("Authorization", authorization == null ? "" : authorization)
        .add("principal", principal == null ? "" : principal.toString(true))
        .build();
    return Uni.createFrom().item(jsonObject);
  }

  /**
   * 只有admin角色可以访问
   *
   * @param authorization
   * @param securityContext
   * @return
   */
  @Path("/sec/admin")
  @GET
  public Uni<JsonObject> admin(@RestHeader("Authorization") String authorization,
                               @Context SecurityContext securityContext
  ) {
    JWTCallerPrincipal principal = (JWTCallerPrincipal) securityContext.getUserPrincipal();
    JsonObject jsonObject = Json.createObjectBuilder()
        .add("Authorization", authorization == null ? "" : authorization)
        .add("principal", principal == null ? "" : principal.toString(true))
        .build();
    return Uni.createFrom().item(jsonObject);
  }

  /**
   * admin角色和user角色可以访问
   *
   * @param authorization
   * @param securityContext
   * @return
   */
  @Path("/sec/user")
  @POST
  public Uni<JsonObject> user(@RestHeader("Authorization") String authorization,
                              @Context SecurityContext securityContext
  ) {
    JWTCallerPrincipal principal = (JWTCallerPrincipal) securityContext.getUserPrincipal();
    JsonObject jsonObject = Json.createObjectBuilder()
        .add("Authorization", authorization == null ? "" : authorization)
        .add("principal", principal == null ? "" : principal.toString(true))
        .build();
    return Uni.createFrom().item(jsonObject);
  }

}
