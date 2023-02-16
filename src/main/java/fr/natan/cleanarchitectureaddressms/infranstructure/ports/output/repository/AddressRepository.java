package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.repository;

import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Long> {
    Collection<AddressModel> findByWayNumAndStreetAndPoBoxAndCity(
            int wayNum,
            String street,
            int pb,
            String city
            );
}
