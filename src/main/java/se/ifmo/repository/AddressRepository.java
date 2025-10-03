package se.ifmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
