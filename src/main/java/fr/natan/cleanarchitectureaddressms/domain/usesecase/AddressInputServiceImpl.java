package fr.natan.cleanarchitectureaddressms.domain.usesecase;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.domain.ports.input.AddressInputService;
import fr.natan.cleanarchitectureaddressms.domain.ports.output.AddressOutputService;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressAlreadyExistsException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressNotFoundException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressOneOrMoreFieldsInvalidException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.WarnMsg;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.mapper.AddressMapper;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;

import java.util.Collection;
import java.util.Optional;

public class AddressInputServiceImpl implements AddressInputService {
    private final AddressOutputService addressOutputService;

    public AddressInputServiceImpl(AddressOutputService addressOutputService) {
        this.addressOutputService = addressOutputService;
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) throws AddressOneOrMoreFieldsInvalidException, AddressAlreadyExistsException {
        if (!AddressValidation.areValidAddressFields(addressDto)) {
            throw new AddressOneOrMoreFieldsInvalidException(WarnMsg.ADDRESS_FIELDS_INVALID.getException());
        }
        if (!loadAddressByAddressInfos(addressDto).isEmpty()) {
            throw new AddressAlreadyExistsException(WarnMsg.ADDRESS_ALREADY_EXISTS.getException());
        }
        return addressOutputService.createAddress(addressDto);
    }

    @Override
    public Collection<Address> loadAllAddresses() {
        return addressOutputService.loadAllAddresses();
    }

    @Override
    public Collection<Address> loadAddressByAddressInfos(AddressDto addressDto) {
        return addressOutputService.loadAddressByAddressInfos(addressDto);
    }

    @Override
    public Optional<Address> loadAddressByID(Long addressID) throws AddressNotFoundException {
        Optional<Address> address = addressOutputService.loadAddressByID(addressID);
        if (address.isEmpty()) {
            throw new AddressNotFoundException(WarnMsg.ADDRESS_NOT_FOUND.getException());
        }
        return address;
    }

    @Override
    public void deleteAddress(Long addressID) throws AddressNotFoundException {
        Optional<Address> address = loadAddressByID(addressID);
        if (address.isEmpty()) {
            throw new AddressNotFoundException(WarnMsg.ADDRESS_NOT_FOUND.getException());
        }
        addressOutputService.deleteAddress(address.get().getAddressID());
    }

    @Override
    public Address updateAddress(Long addressID, AddressDto addressDto) throws AddressNotFoundException, AddressOneOrMoreFieldsInvalidException {
        if (!AddressValidation.areValidAddressFields(addressDto)) {
            throw new AddressOneOrMoreFieldsInvalidException(WarnMsg.ADDRESS_FIELDS_INVALID.getException());
        }
        Address address = AddressMapper.mapToAddress(addressDto);
        Optional<Address> savedAddress = loadAddressByID(addressID);
        savedAddress.ifPresentOrElse(value -> {
                    address.setAddressID(value.getAddressID());
                    addressOutputService.updateAddress(address);
                },
                () -> new AddressNotFoundException(WarnMsg.ADDRESS_NOT_FOUND.getException())

        );
        return address;
    }
}
