package project.simpleboard.crud;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import project.simpleboard.common.Api;

import java.util.List;
import java.util.Optional;

public abstract class CRUDApiAbstractController<DTO, ENTITY> implements CRUDInterface<DTO> {

    @Autowired(required = false)
    private CRUDAbstractService<DTO, ENTITY> crudAbstractService;


    @PostMapping("")
    @Override
    public DTO create(
            @Valid  @RequestBody DTO dto
    ) {
        return crudAbstractService.create(dto);
    }

    @GetMapping("/id/{id}")
    @Override
    public Optional<DTO> read(
            @PathVariable Long id
    ) {
        return crudAbstractService.read(id);
    }

    @PutMapping("")
    @Override
    public DTO update(
            @Valid @RequestBody DTO dto
    ) {
        return crudAbstractService.update(dto);
    }

    @DeleteMapping("/id/{id}")
    @Override
    public Long delete(
            @PathVariable Long id
    ) {
        crudAbstractService.delete(id);
        return id;
    }

    @GetMapping("/all")
    @Override
    public Api<List<DTO>> list(Pageable pageable) {
        return crudAbstractService.list(pageable);
    }
}
