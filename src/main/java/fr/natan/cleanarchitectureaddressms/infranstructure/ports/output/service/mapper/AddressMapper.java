package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.service.mapper;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressModel;
import org.springframework.beans.BeanUtils;

public class AddressMapper {
    private AddressMapper (){
    }
    public static AddressModel mapDtoToModel(AddressDto addressDto) {
        AddressModel addressModel = new AddressModel();
        BeanUtils.copyProperties(addressDto, addressModel);

        return addressModel;
    }
    public static AddressDto mapModelToDto(AddressModel addressModel) {
        AddressDto addressDto = new AddressDto();
        BeanUtils.copyProperties(addressModel, addressDto);
        return addressDto;
    }

    public static Address mapModelToClass(AddressModel addressModel) {
        Address address = new Address();
        BeanUtils.copyProperties(addressModel, address);
        return address;
    }

    public static AddressModel mapClassToModel(Address address){
        AddressModel addressModel = new AddressModel();
        BeanUtils.copyProperties(address, addressModel);
        return addressModel;
    }
}
