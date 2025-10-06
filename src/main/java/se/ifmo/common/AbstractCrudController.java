package se.ifmo.common;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.ifmo.common.placemark.Dto;

@RequiredArgsConstructor
public abstract class AbstractCrudController<
        TDto extends Dto,
        TId extends Number,
        TService extends AbstractCrudService<?, ?, TDto, ?, TId>
        > {

    private final TService service;

    //TODO: перейти на батчи
    @GetMapping
    public Page<TDto> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return service.getAll(PageRequest.of(page, size));
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
    public Page<TDto> search(
            @RequestParam String field,
            @RequestParam String value,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return service.searchByValueInField(field, value, PageRequest.of(page, size));
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
