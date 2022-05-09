package cloud.bluesphere.entity;

import cloud.bluesphere.assist.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity(name = Constants.Data.Device.ENTITY_NAME)
@Table(name = Constants.Data.Device.TABLE_NAME)
public class DeviceEntity {

  @Id
  @Column(name = Constants.Data.Device.COLUMN_NAME_ID)
  public String id;
  @Column(name = Constants.Data.Device.COLUMN_NAME_NAME)
  public String name;
  @Column(name = Constants.Data.Device.COLUMN_NAME_UDID, unique = true)
  public String udid;

  @Override
  public String toString() {
    return new StringJoiner(", ", DeviceEntity.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("name='" + name + "'")
        .add("udid='" + udid + "'")
        .toString();
  }
}
