package se.ifmo.common;

public interface GenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
}
