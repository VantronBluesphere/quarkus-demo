package cloud.bluesphere.resource;

import cloud.bluesphere.dto.Device;
import cloud.bluesphere.service.DeviceService;
import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/devices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeviceResource {

  private static final Logger LOG = Logger.getLogger(DeviceResource.class);

  @Inject
  DeviceService deviceService;

  @Path("/{id}")
  @GET
  public Uni<Device> get(@RestPath String id) {
    LOG.debugf("Get device %s", id);
    return deviceService.getById(id);
  }

  @POST
  public Uni<String> add(Device device) {

    return Uni.createFrom().item("sss");
  }

}
