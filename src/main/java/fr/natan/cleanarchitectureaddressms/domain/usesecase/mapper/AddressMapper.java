package fr.natan.cleanarchitectureaddressms.domain.usesecase.mapper;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;

public class AddressMapper {
    private AddressMapper(){}
    public static Address mapToAddress(AddressDto addressDto){
        Address address = new Address();
        address.setWayNum(addressDto.getWayNum());
        address.setStreet(addressDto.getStreet());
        address.setPoBox(addressDto.getPoBox());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());

        return address;
    }

    public static AddressDto mapToDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setWayNum(address.getWayNum());
        addressDto.setStreet(address.getStreet());
        addressDto.setPoBox(address.getPoBox());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());

        return addressDto;
    }
}
