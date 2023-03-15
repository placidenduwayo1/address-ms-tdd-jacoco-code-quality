package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.service;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressNotFoundException;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DataJpaTest
@Tag("AddressOutputServiceImpl Test")
@DisplayName("Address output implementation tests")
class AddressOutputServiceImplementationTest {
    private final AddressRepository addressRepository = mock(AddressRepository.class);
    private AddressOutputServiceImplementation addressOutputServiceImplementation = null;
    private AddressDto addressDto = null;

    @BeforeEach
    void setUp() {
        addressOutputServiceImplementation = new AddressOutputServiceImplementation(addressRepository);
        addressDto = new AddressDto(1, "street", 10000, "city", "country");
    }

    @Test
    void loadAllAddresses() {
        //WHEN
        addressOutputServiceImplementation.loadAllAddresses();
        verify(addressRepository).findAll();
    }

    @Test
    void loadAddressByAddressInfos() {
        addressOutputServiceImplementation.loadAddressByAddressInfos(addressDto);
        verify(addressRepository).findByWayNumAndStreetAndPoBoxAndCity(
                addressDto.getWayNum(), addressDto.getStreet(), addressDto.getPoBox(), addressDto.getCity());
    }

    @Test
    void loadAddressByInvalidAddressIDShouldReturnException()  {
        Exception exception = assertThrows(AddressNotFoundException.class,
                ()->addressOutputServiceImplementation.loadAddressByID(1L));
        assertThat(exception.getMessage()).isNotNull();
    }
}