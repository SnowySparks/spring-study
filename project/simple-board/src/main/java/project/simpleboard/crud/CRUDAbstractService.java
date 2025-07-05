package project.simpleboard.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import project.simpleboard.common.Api;
import project.simpleboard.common.Pagination;

import java.util.List;
import java.util.Optional;

public abstract class CRUDAbstractService<DTO, ENTITY> implements CRUDInterface<DTO> {

    @Autowired(required = false)
    private JpaRepository<ENTITY, Long> jpaRepository;

    @Autowired(required = false)
    private Converter<DTO, ENTITY> converter;

    @Override
    public DTO create(DTO dto) {
        // dto -> entity
        var eneity  = converter.toEntity(dto);

        // entity -> save
        jpaRepository.save(eneity);

        // save -> dto
        return converter.toDTO(eneity);
    }

    @Override
    public Optional<DTO> read(Long id) {
        var optionalEntity = jpaRepository.findById(id);

        var dto = optionalEntity.map(
                entity -> converter.toDTO(entity)
        ).orElseGet(() -> null);

        return Optional.ofNullable(dto);
    }

    @Override
    public DTO update(DTO dto) {
        var entity = converter.toEntity(dto);
        jpaRepository.save(entity);
        var returnDto = converter.toDTO(entity);
        return returnDto;
    }

    @Override
    public Long delete(Long id) {
        jpaRepository.deleteById(id);
        return id;
    }

    @Override
    public Api<List<DTO>> list(Pageable pageable) {
        var list = jpaRepository.findAll(pageable);
        var pagination = Pagination.builder()
                .page(pageable.getPageNumber())
                .size(pageable.getPageSize())
                .currentElements(list.getNumberOfElements())
                .totalElements(list.getTotalElements())
                .totalPages(list.getTotalPages())
                .build();

        var dtoList = list.stream()
                .map(it -> converter.toDTO(it))
                .toList();

        Api<List<DTO>> response;
        response = Api.<List<DTO>>builder()
                .body(dtoList)
                .pagination(pagination)
                .build();
        return response;
    }
}
