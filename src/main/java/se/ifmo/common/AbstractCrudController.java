package se.ifmo.common;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.ifmo.common.placemark.Dto;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractCrudController<
        TDto extends Dto,
        TId extends Number,
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
    public ResponseEntity<TId> create(@RequestBody TDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public List<TDto> search(@RequestParam String field, @RequestParam String value) {
        return service.searchByValueInField(field, value);
    }

    @PutMapping
    public void update(@RequestBody TDto dto) {
        service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable TId id) {
        service.delete(id);
    }
}
