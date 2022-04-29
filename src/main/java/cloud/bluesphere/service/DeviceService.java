package cloud.bluesphere.service;

import cloud.bluesphere.assist.ApiErrorCode;
import cloud.bluesphere.assist.ApiException;
import cloud.bluesphere.dto.Device;
import cloud.bluesphere.repository.DeviceRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeviceService {

  @Inject
  DeviceRepository deviceRepository;

  public Uni<Device> getById(String id) {
    int x = 1 / 0;
    return deviceRepository.findById(id)
        .flatMap(deviceEntity -> deviceEntity == null ?
            Uni.createFrom().failure(new ApiException(ApiErrorCode.DEVICE_NOT_FOUND)) :
            Uni.createFrom().item(Device.fromEntity(deviceEntity)));
  }

}
