package fr.natan.cleanarchitectureaddressms.domain.usesecase.mapper;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressMapperTest {

    @Test
    void mapToAddressShouldReturnAddress() {
        //GIVEN
        AddressDto addressDto = new AddressDto(
                1,
                "street name",
                10000,
                "city name",
                "country name"
        );

        //WHEN

        Address mappedAddress = AddressMapper.mapToAddress(addressDto);
        int actualWayNum = mappedAddress.getWayNum();
        String actualStreet = mappedAddress.getStreet();
        int actualPb = mappedAddress.getPoBox();
        String actualCity = mappedAddress.getCity();
        String actualCountry = mappedAddress.getCountry();
        String actual =""+actualWayNum+actualStreet+actualPb+actualCity+actualCountry;
        Assertions.assertThat(actual).isEqualTo(
                ""+addressDto.getWayNum()
                        +addressDto.getStreet()
                        +addressDto.getPoBox()
                        +addressDto.getCity()
                        +addressDto.getCountry()
        );
    }
}