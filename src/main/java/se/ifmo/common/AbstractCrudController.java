package se.ifmo.common;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.ifmo.common.placemark.Dto;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractCrudController<
        TDto extends Dto,
        TId,
        TService extends AbstractCrudService<?, ?, TDto, ?, TId>
        > {

    private final TService service;

    //TODO: перейти на батчи
    @GetMapping
    public List<TDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TDto getById(@PathVariable TId id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TDto dto) {
        service.create(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody TDto dto) {
        service.update(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable TId id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
