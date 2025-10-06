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

    @GetMapping
    public PageDto<TDto> getAll(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int size) {

        return mapToPageDto(service.getAll(PageRequest.of(pageNumber, size)));
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
    public PageDto<TDto> search(
            @RequestParam String field,
            @RequestParam String value,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int size) {

        return mapToPageDto(service.searchByValueInField(field, value, PageRequest.of(pageNumber, size)));
    }

    @PutMapping
    public void update(@RequestBody TDto dto) {
        service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable TId id) {
        service.delete(id);
    }

    private PageDto<TDto> mapToPageDto(Page<TDto> page) {
        return new PageDto<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements()
        );
    }
}
