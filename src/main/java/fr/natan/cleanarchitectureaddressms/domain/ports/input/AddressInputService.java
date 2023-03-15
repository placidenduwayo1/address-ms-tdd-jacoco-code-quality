package fr.natan.cleanarchitectureaddressms.domain.ports.input;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressAlreadyExistsException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressNotFoundException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressOneOrMoreFieldsInvalidException;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;

import java.util.Collection;
import java.util.Optional;

public interface AddressInputService {
    AddressDto createAddress(AddressDto addressDto) throws AddressOneOrMoreFieldsInvalidException, AddressAlreadyExistsException;
    Collection<Address> loadAllAddresses();
    Collection<Address> loadAddressByAddressInfos(AddressDto addressDto);
    Optional<Address> loadAddressByID(Long addressID) throws AddressNotFoundException;
    void deleteAddress(Long addressID) throws AddressNotFoundException;
    Address updateAddress(Long addressID, AddressDto addressDto) throws AddressNotFoundException, AddressOneOrMoreFieldsInvalidException;
}
