package cloud.bluesphere.repository;

import cloud.bluesphere.entity.DeviceEntity;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeviceRepository implements PanacheRepositoryBase<DeviceEntity, String> {

}
