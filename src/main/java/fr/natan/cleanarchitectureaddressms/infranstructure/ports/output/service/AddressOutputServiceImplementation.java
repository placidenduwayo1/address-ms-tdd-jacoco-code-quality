package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.service;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.domain.ports.output.AddressOutputService;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressNotFoundException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.WarnMsg;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressModel;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.repository.AddressRepository;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.service.mapper.AddressMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class AddressOutputServiceImplementation implements AddressOutputService {
    private final AddressRepository addressRepository;

    public AddressOutputServiceImplementation(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        AddressModel mappedAddress = AddressMapper.mapDtoToModel(addressDto);
        AddressModel savedAddress = addressRepository.save(mappedAddress);
        return AddressMapper.mapModelToDto(savedAddress);
    }

    @Override
    public Collection<Address> loadAllAddresses() {
        Collection<AddressModel> addresses = addressRepository.findAll();
        return addresses.stream().
                map(AddressMapper::mapModelToClass)
                .toList();

    }

    @Override
    public Collection<Address> loadAddressByAddressInfos(AddressDto addressDto) {
        Collection<AddressModel> addresses = addressRepository.findByWayNumAndStreetAndPoBoxAndCity(
                addressDto.getWayNum(),
                addressDto.getStreet(),
                addressDto.getPoBox(),
                addressDto.getCity()
        );
        return addresses.stream().map(AddressMapper::mapModelToClass).toList();
    }

    @Override
    public Optional<Address> loadAddressByID(Long addressID) throws AddressNotFoundException {
        Optional<AddressModel> addressModel = addressRepository.findById(addressID);
        if (addressModel.isEmpty()) {
            throw new AddressNotFoundException(WarnMsg.ADDRESS_NOT_FOUND.getException());
        }
        return Optional.of(AddressMapper.mapModelToClass(addressModel.get()));
    }

    @Override
    public String deleteAddress(Long addressID) {
        addressRepository.deleteById(addressID);
        return null;
    }

    @Override
    public Address updateAddress(Address address) {
        AddressModel addressModel = addressRepository
                .save(AddressMapper.mapClassToModel(address));
        return AddressMapper.mapModelToClass(addressModel);
    }
}
