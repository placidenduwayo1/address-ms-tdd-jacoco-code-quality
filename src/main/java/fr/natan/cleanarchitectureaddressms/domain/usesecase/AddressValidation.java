package fr.natan.cleanarchitectureaddressms.domain.usesecase;


import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;

public class AddressValidation {
    private AddressValidation(){
    }
    public static boolean areValidAddressFields(AddressDto addressDto){
        return addressDto.getWayNum() > 0
                && !addressDto.getStreet().isEmpty()
                && addressDto.getPoBox() >= 10000
                && !addressDto.getCity().isEmpty()
                && !addressDto.getCountry().isEmpty();
    }
}
