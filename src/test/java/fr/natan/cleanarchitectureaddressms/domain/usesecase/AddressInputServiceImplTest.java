package fr.natan.cleanarchitectureaddressms.domain.usesecase;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.domain.ports.output.AddressOutputService;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressAlreadyExistsException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressNotFoundException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressOneOrMoreFieldsInvalidException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.WarnMsg;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@Tag("AddressInputServiceImplTest")
@DisplayName("All tests for AddressInputServiceImpl")
class AddressInputServiceImplTest {
    private AddressInputServiceImpl underTest = null;
    private final AddressOutputService addressOutputService = mock(AddressOutputService.class);
    private AddressDto addressDto = null;
    private Address address =null;
    @BeforeEach
    void setUp() {
        underTest = new AddressInputServiceImpl(addressOutputService);
        addressDto = new AddressDto(
                1,
                "street name",
                10000,
                "city name",
                "country name"
        );
        address = new Address(
                1L,
                1,
                "street name",
                10000,
                "city name",
                "country name"
        );
    }

    @Test
    void createAddressShouldCreateAddress() throws AddressAlreadyExistsException, AddressOneOrMoreFieldsInvalidException {
        underTest.createAddress(addressDto);
        verify(addressOutputService).createAddress(addressDto);
    }

    @Test
    void invalidAddressCreateAddressShouldReturnException() {
        AddressDto invalidAddress = new AddressDto();
        Exception exception = assertThrows(AddressOneOrMoreFieldsInvalidException.class,
                () -> underTest.createAddress(invalidAddress)
        );

        assertThat(exception.getMessage()).isEqualTo(WarnMsg.ADDRESS_FIELDS_INVALID.getException());
    }
    @Test
    void loadAllAddressesShouldReturnAddresses() {
        underTest.loadAllAddresses();
        verify(addressOutputService).loadAllAddresses();
    }
    @Test
    void loadAddressByAddressInfosShouldReturnAnAddress() {

        underTest.loadAddressByAddressInfos(addressDto);
        verify(addressOutputService).loadAddressByAddressInfos(addressDto);
    }
    @Test
    void testLoadAddressByID() throws AddressNotFoundException {
        when(addressOutputService.loadAddressByID(1L)).thenReturn(Optional.of(address));
        underTest.loadAddressByID(1L);
        verify(addressOutputService).loadAddressByID(1L);
    }
    @Test
    void deleteAddressByIDInvalidIDShouldReturnException() {
        when(addressOutputService.deleteAddress(1L)).thenReturn(null);
       Exception exception = assertThrows(AddressNotFoundException.class,
                ()->underTest.deleteAddress(1L)) ;
        assertThat(exception.getMessage()).isNotNull();
    }
    @Test
    void testAddressUpdate() {
        Address newAddress = new Address(1L,1,"",0,"","");
        when(addressOutputService.updateAddress(address)).thenReturn(newAddress);
        Exception exception = assertThrows(AddressNotFoundException.class,
                ()-> underTest.updateAddress(newAddress.getAddressID(),addressDto)
        );
        assertAll(
                ()-> assertThat(exception.getMessage()).isEqualTo(WarnMsg.ADDRESS_NOT_FOUND.getException())
        );
    }
}