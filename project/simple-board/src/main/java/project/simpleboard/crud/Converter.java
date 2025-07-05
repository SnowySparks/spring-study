package project.simpleboard.crud;

public interface Converter<DTO, ENTITY> {
    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO dto);
}
