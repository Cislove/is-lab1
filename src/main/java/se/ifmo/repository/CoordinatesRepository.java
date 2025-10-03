package se.ifmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.model.Coordinates;

@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {
}
