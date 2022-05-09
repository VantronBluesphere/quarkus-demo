package cloud.bluesphere.dto;

import cloud.bluesphere.entity.DeviceEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

public class Device implements ToFromEntity<Device, DeviceEntity> {

  public String id;
  @NotBlank(message = "Device name can not be blank")
  @Length(min = 1, max = 10, message = "Device name length should between 1 to 10")
  public String name;
  @NotBlank(message = "Device udid can not be blank")
  public String udid;

  @Override
  public DeviceEntity toEntity() {
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.id = this.id;
    deviceEntity.name = this.name;
    deviceEntity.udid = this.udid;
    return deviceEntity;
  }

  @Override
  public Device fromEntity(DeviceEntity deviceEntity) {
    this.id = deviceEntity.id;
    this.name = deviceEntity.name;
    this.udid = deviceEntity.udid;
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
