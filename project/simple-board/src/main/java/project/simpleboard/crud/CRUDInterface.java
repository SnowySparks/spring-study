package project.simpleboard.crud;

import org.springframework.data.domain.Pageable;
import project.simpleboard.common.Api;

import java.util.List;
import java.util.Optional;

public interface CRUDInterface<DTO> {
    DTO create(DTO dto);

    Optional<DTO> read(Long id);

    DTO update(DTO dto);

    Long delete(Long id);

    Api<List<DTO>> list(Pageable pageable);

}
