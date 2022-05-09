package cloud.bluesphere.repository;

import cloud.bluesphere.entity.DeviceEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeviceRepository implements PanacheRepositoryBase<DeviceEntity, String> {

  public Uni<DeviceEntity> findByUdid(String udid){
    return find("udid", udid).firstResult();
  }

  public Uni<DeviceEntity> findByUdidAndName(String udid, String name){
    return find("udid = ?1 and name = ?2", udid, name).firstResult();
  }

}
