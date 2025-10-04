package se.ifmo.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import se.ifmo.notification.NotificationService;
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
    @Autowired
    private NotificationService notificationService;

    //TODO: прописать кастомные исключения
    public TDto getById(TId id){
        var dto = repository.findById(id).orElseThrow(RuntimeException::new);
        return mapper.toDto(dto);
    }

    public List<TDto> getAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public void create(TDto dto){
        TEntity entity = mapper.toEntity(dto);
        repository.save(entity);
        notificationService.sendNotification(dto);
    }

    public void update(TDto dto){
        create(dto); // )))))))))
    }

    public void delete(TId id){
        repository.deleteById(id);
    }
}
