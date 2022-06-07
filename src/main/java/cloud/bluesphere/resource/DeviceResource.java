package cloud.bluesphere.resource;

import cloud.bluesphere.assist.PageData;
import cloud.bluesphere.dto.Device;
import cloud.bluesphere.service.DeviceService;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/devices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeviceResource {

  @Inject
  DeviceService deviceService;

  @Path("/{id}")
  @GET
  public Uni<Device> get(@RestPath String id) {
    Log.debugf("Get device %s", id);
    return deviceService.getById(id);
  }

  @Path("/udid/{udid}")
  @GET
  public Uni<Device> getByUdid(@RestPath String udid) {
    Log.debugf("Get device by udid: %s", udid);
    return deviceService.getByUdid(udid);
  }

  @Path("/udidandname")
  @GET
  public Uni<Device> getByUdid(@RestQuery String udid, @RestQuery String name) {
    Log.debugf("Get device by udid and name: %s", udid, name);
    return deviceService.getByUdidAndName(udid, name);
  }

  @GET
  public Uni<PageData<Device>> getByPage(@RestQuery int pageNum, @RestQuery int pageSize) {
    Log.debugf("Get devices by pageNum and pageSize: %s", pageNum, pageSize);
    return deviceService.getByPage(pageNum, pageSize);
  }

  @POST
  public Uni<Device> add(@Valid Device device) {
    Log.debugf("Create device: %s", device.toString());
    return deviceService.create(device);
  }

  @PUT
  @Path("/{id}")
  public Uni<Device> update(@RestPath String id, Device device) {
    Log.debugf("Update device: %s, %s", id, device.toString());
    device.id = id;
    return deviceService.update(device);
  }

  @DELETE
  @Path("/{id}")
  public Uni<Void> delete(@RestPath String id) {
    Log.debugf("Delete device: %s", id);
    return deviceService.delete(id);
  }

}
