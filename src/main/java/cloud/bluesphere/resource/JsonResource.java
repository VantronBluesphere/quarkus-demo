package cloud.bluesphere.resource;

import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestResponse;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/json")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JsonResource {

  @Path("/{id}")
  @GET
  public Uni<JsonObject> get() {
    JsonObject jsonObject = Json.createObjectBuilder()
        .add("key1", "v1")
        .add("key2", 1)
        .add("key3", false)
        .add("key4", Json.createArrayBuilder().add("s1").add("s2"))
        .build();
    return Uni.createFrom().item(jsonObject);
  }

  @Path("v2/{id}")
  @GET
  public Uni<Response> get2() {
    JsonObject jsonObject = Json.createObjectBuilder()
        .add("key1", "v1")
        .add("key2", 1)
        .add("key3", false)
        .add("key4", Json.createArrayBuilder().add("s1").add("s2"))
        .build();
    return Uni.createFrom().item(Response.ok(jsonObject).build());
  }

}
