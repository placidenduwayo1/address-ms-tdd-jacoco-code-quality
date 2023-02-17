package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.repository;

import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
@Tag("AddressRepositoryTest")
@DisplayName("Tests for address repository")
class AddressRepositoryTest {
    @Autowired
    private AddressRepository underTest;
    AddressModel address1;
    AddressModel address2;
    AddressModel address3;
    List<AddressModel> addresses = null;

    @BeforeEach
    void setUp() {
        address1 = AddressModel.builder()
                .wayNum(1)
                .street("street name")
                .poBox(10000)
                .city("city name")
                .country("country name")
                .build();
        address2 = AddressModel.builder()
                .wayNum(2)
                .street("street name")
                .poBox(10000)
                .city("city name")
                .build();
        address3 = AddressModel.builder()
                .wayNum(3)
                .street("street name")
                .poBox(10000)
                .build();

        addresses = new ArrayList<>();
        addresses.addAll(List.of(address1, address2, address3));
    }

    @Test
    void findByWayNumAndStreetAndPoBoxAndCity() {
        //when
       underTest.saveAll(addresses);
        Collection<AddressModel> actualAddresses = underTest.findByWayNumAndStreetAndPoBoxAndCity(
                1, "street name", 10000, "city name");
        assertAll(
                ()->  assertThat(actualAddresses).hasSize(1),
                ()-> assertThat (underTest.findAll()).hasSize(3),
                () -> assertThat(underTest.findById(2L).get().getWayNum()).isEqualTo(2)
        );
    }
}