package cloud.bluesphere.dto;

import cloud.bluesphere.entity.DeviceEntity;

import javax.validation.constraints.NotBlank;

public class Device {

  private String id;
  @NotBlank(message = "Device name can not be blank")
  private String name;
  private String sn;

  public static Device fromEntity(DeviceEntity deviceEntity){
    Device device = new Device();
    device.setId(deviceEntity.getId());
    device.setName(deviceEntity.getName());
    device.setSn(deviceEntity.getSn());
    return device;
  }

  public String getId() {
    return id;
  }

  public Device setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Device setName(String name) {
    this.name = name;
    return this;
  }

  public String getSn() {
    return sn;
  }

  public Device setSn(String sn) {
    this.sn = sn;
    return this;
  }

}
