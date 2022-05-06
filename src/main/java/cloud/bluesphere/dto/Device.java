package cloud.bluesphere.dto;

import cloud.bluesphere.entity.DeviceEntity;

import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

public class Device implements ToFromEntity<Device, DeviceEntity>{

  private String id;
  @NotBlank(message = "Device name can not be blank")
  private String name;
  @NotBlank(message = "Device udid can not be blank")
  private String udid;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUdid() {
    return udid;
  }

  public void setUdid(String udid) {
    this.udid = udid;
  }

  @Override
  public DeviceEntity toEntity() {
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setId(this.id);
    deviceEntity.setName(this.name);
    deviceEntity.setUdid(this.udid);
    return deviceEntity;
  }

  @Override
  public Device fromEntity(DeviceEntity deviceEntity) {
    this.id = deviceEntity.getId();
    this.name = deviceEntity.getName();
    this.udid = deviceEntity.getUdid();
    return this;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Device.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("name='" + name + "'")
        .add("udid='" + udid + "'")
        .toString();
  }
}
