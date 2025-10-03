package se.ifmo.common;

import lombok.RequiredArgsConstructor;
import se.ifmo.common.placemark.AbstractEntity;
import se.ifmo.common.placemark.AbstractRepository;
import se.ifmo.common.placemark.Dto;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractCrudService <
        TEntity extends AbstractEntity,
        TRepository extends AbstractRepository<TEntity, TId>,
        TDto extends Dto,
        TMapper extends GenericMapper<TDto, TEntity>,
        TId
        > {

    private final TRepository repository;
    private final TMapper mapper;

    //TODO: прописать кастомные исключения
    public TDto getById(TId id){
        return mapper.toDto(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    public List<TDto> getAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public void create(TDto dto){
        repository.save(mapper.toEntity(dto));
    }

    public void update(TDto dto){
        create(dto); // )))))))))
    }

    public void delete(TId id){
        repository.deleteById(id);
    }
}
