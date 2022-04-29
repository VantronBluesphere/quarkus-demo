package cloud.bluesphere.entity;

import cloud.bluesphere.config.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = Constants.Data.Device.ENTITY_NAME)
@Table(name = Constants.Data.Device.TABLE_NAME)
public class DeviceEntity {

  @Id
  @Column(name = Constants.Data.Device.COLUMN_NAME_ID)
  private String id;
  @Column(name = Constants.Data.Device.COLUMN_NAME_NAME)
  public String name;
  @Column(name = Constants.Data.Device.COLUMN_NAME_SN, unique = true)
  private String sn;

  public String getId() {
    return id;
  }

  public DeviceEntity setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public DeviceEntity setName(String name) {
    this.name = name;
    return this;
  }

  public String getSn() {
    return sn;
  }

  public DeviceEntity setSn(String sn) {
    this.sn = sn;
    return this;
  }

}
