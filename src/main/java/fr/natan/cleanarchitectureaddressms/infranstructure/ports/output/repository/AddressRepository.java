package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.repository;

import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
public interface AddressRepository extends JpaRepository<AddressModel, Long> {
    Collection<AddressModel> findByWayNumAndStreetAndPoBoxAndCity(
            int wayNum,
            String street,
            int pb,
            String city
            );
}
