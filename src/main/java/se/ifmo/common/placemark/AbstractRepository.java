package se.ifmo.common.placemark;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository<TEntity, TId> extends JpaRepository<TEntity, TId>{
}
