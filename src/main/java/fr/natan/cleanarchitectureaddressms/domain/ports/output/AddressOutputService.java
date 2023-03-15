package fr.natan.cleanarchitectureaddressms.domain.ports.output;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressNotFoundException;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;

import java.util.Collection;
import java.util.Optional;

public interface AddressOutputService {
    AddressDto createAddress(AddressDto addressDto);

    Collection<Address> loadAllAddresses();

    Collection<Address> loadAddressByAddressInfos(AddressDto addressDto);
    Optional<Address> loadAddressByID(Long addressID) throws AddressNotFoundException;
    String deleteAddress(Long addressID);
    Address updateAddress(Address address);
}
