package se.ifmo.common;

import se.ifmo.common.placemark.AbstractEntity;
import se.ifmo.common.placemark.Dto;

public interface GenericMapper<D extends Dto, E extends AbstractEntity> {
    D toDto(E entity);
    E toEntity(D dto);
}
