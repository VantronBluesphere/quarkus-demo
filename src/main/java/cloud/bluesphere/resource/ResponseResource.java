package cloud.bluesphere.resource;

import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResponseResource {

  @Path("/response")
  @GET
  public Uni<RestResponse<Legume>> getResponse(@RestPath String id) {

    return Uni.createFrom().item(RestResponse.ResponseBuilder.ok(new Legume("name1", "desc")).header("header1", "value1").build());
  }

  public static class Legume {

    public String name;
    public String description;

    public Legume() {
    }

    public Legume(String name, String description) {
      this.name = name;
      this.description = description;
    }
  }

}
