package se.ifmo.common;

import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import se.ifmo.common.placemark.AbstractRepository;
import se.ifmo.common.placemark.Dto;
import se.ifmo.errors.BadRequestException;
import se.ifmo.errors.NotFoundException;
import se.ifmo.notification.NotificationService;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractCrudService<
        TEntity extends AbstractEntity<TId>,
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
    public TDto getById(TId id) {
        var dto = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Entity with id: " + id + "not found"));
        return mapper.toDto(dto);
    }

    public List<TDto> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public void create(TDto dto) {
        try {
            TEntity entity = mapper.toEntity(dto);
            notificationService.sendAddNotification(
                    repository.save(entity).getStringId(),
                    getEntityName());
        }
        catch (DataIntegrityViolationException | ConstraintViolationException e) {
            throw new BadRequestException("incorrect field value");
        }
    }

    public void update(TDto dto) {
        try {
            TEntity entity = mapper.toEntity(dto);
            checkIdExists(entity.getId());
            notificationService.sendUpdateNotification(
                    repository.save(entity).getStringId(),
                    getEntityName());
        }
        catch (DataIntegrityViolationException | ConstraintViolationException e) {
            throw new BadRequestException("incorrect field value");
        }
    }

    public void delete(TId id) {
        checkIdExists(id);
        repository.deleteById(id);
        notificationService.sendDeleteNotification(id.toString(), getEntityName());
    }

    //TODO как переработать, хотя бы на конфиг
    public abstract String getEntityName();

    private void checkIdExists(TId id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Entity with id " + id + " not found");
        }
    }
}
