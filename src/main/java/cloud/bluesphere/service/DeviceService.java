package cloud.bluesphere.service;

import cloud.bluesphere.assist.ApiErrorCode;
import cloud.bluesphere.assist.ApiException;
import cloud.bluesphere.assist.PageData;
import cloud.bluesphere.dto.Device;
import cloud.bluesphere.entity.DeviceEntity;
import cloud.bluesphere.repository.DeviceRepository;
import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.quarkus.panache.common.Page;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class DeviceService {

  @Inject
  DeviceRepository deviceRepository;

  public Uni<Device> getById(String id) {
//    int x = 1 / 0;
    return deviceRepository.findById(id)
        .onItem().ifNull().failWith(new ApiException(ApiErrorCode.DEVICE_NOT_FOUND))
        .onItem().transform(deviceEntity -> new Device().fromEntity(deviceEntity));
  }

  public Uni<Device> getByUdid(String udid) {
    return deviceRepository.findByUdid(udid)
        .onItem().ifNull().failWith(new ApiException(ApiErrorCode.DEVICE_NOT_FOUND))
        .onItem().transform(new Device()::fromEntity);
  }

  public Uni<Device> getByUdidAndName(String udid, String name) {
    return deviceRepository.findByUdidAndName(udid, name)
        .onItem().ifNull().failWith(new ApiException(ApiErrorCode.DEVICE_NOT_FOUND))
        .onItem().transform(new Device()::fromEntity);
  }

  public Uni<PageData<Device>> getByPage(int pageNum, int pageSize){
    PageData<Device> pageData = new PageData<>();
    pageData.setPageNum(pageNum);
    pageData.setPageSize(pageSize);
    PanacheQuery<DeviceEntity> panacheQuery = deviceRepository.findAll();
    panacheQuery.page(Page.of(pageNum - 1, pageSize));
    return panacheQuery.pageCount()
        .onItem().invoke(pageData::setTotalPages)
        .onItem().transformToUni(i -> panacheQuery.count().invoke(pageData::setTotalElements))
        .onItem().transformToUni(l -> panacheQuery.list().invoke(list -> pageData.setData(list.stream().map(deviceEntity -> new Device().fromEntity(deviceEntity)).collect(Collectors.toList()))))
        .onItem().transform(o -> pageData);
  }

  @ReactiveTransactional
  public Uni<Device> create(Device device) {
    DeviceEntity deviceEntity = device.toEntity();
    deviceEntity.id = UUID.randomUUID().toString();
    return deviceRepository.persist(deviceEntity)
        .onItem().transform(new Device()::fromEntity);
  }

  @ReactiveTransactional
  public Uni<Device> update(Device device) {
    return deviceRepository.findById(device.id)
        .onItem().ifNull().failWith(new ApiException(ApiErrorCode.DEVICE_NOT_FOUND))
        .onItem().ifNotNull().invoke(deviceEntity -> {
          deviceEntity.udid = device.udid;
          deviceEntity.name = device.name;
        })
        .onItem().transform(new Device()::fromEntity);
  }

  @ReactiveTransactional
  public Uni<Void> delete(String id){
    return deviceRepository.deleteById(id).replaceWithVoid();
  }

}
