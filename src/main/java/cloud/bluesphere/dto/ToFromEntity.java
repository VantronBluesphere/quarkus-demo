package cloud.bluesphere.dto;

public interface ToFromEntity<Dto, Entity> {

  Entity toEntity();

  Dto fromEntity(Entity entity);

}
