package cloud.bluesphere.service;

import cloud.bluesphere.assist.ApiErrorCode;
import cloud.bluesphere.assist.ApiException;
import cloud.bluesphere.dto.Device;
import cloud.bluesphere.entity.DeviceEntity;
import cloud.bluesphere.repository.DeviceRepository;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class DeviceService {

  @Inject
  DeviceRepository deviceRepository;

  public Uni<Device> getById(String id) {
//    int x = 1 / 0;
    return deviceRepository.findById(id)
        .flatMap(deviceEntity -> deviceEntity == null ?
            Uni.createFrom().failure(new ApiException(ApiErrorCode.DEVICE_NOT_FOUND)) :
            Uni.createFrom().item(new Device().fromEntity(deviceEntity)));
  }

  public Uni<Device> getByUdid(String udid) {

    return null;
  }

  @ReactiveTransactional
  public Uni<Device> create(Device device){
    DeviceEntity deviceEntity = device.toEntity();
    deviceEntity.setId(UUID.randomUUID().toString());
    return deviceRepository.persist(deviceEntity).map(new Device()::fromEntity);
  }

  public Uni<Boolean> update(Device device){

    return null;
  }

}
