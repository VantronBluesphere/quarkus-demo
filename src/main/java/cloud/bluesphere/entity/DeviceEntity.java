package cloud.bluesphere.entity;

import cloud.bluesphere.assist.Constants;

import javax.persistence.*;

@Cacheable
@Entity(name = Constants.Data.Device.ENTITY_NAME)
@Table(name = Constants.Data.Device.TABLE_NAME)
public class DeviceEntity {

  @Id
  @Column(name = Constants.Data.Device.COLUMN_NAME_ID)
  private String id;
  @Column(name = Constants.Data.Device.COLUMN_NAME_NAME)
  public String name;
  @Column(name = Constants.Data.Device.COLUMN_NAME_UDID, unique = true)
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
}
