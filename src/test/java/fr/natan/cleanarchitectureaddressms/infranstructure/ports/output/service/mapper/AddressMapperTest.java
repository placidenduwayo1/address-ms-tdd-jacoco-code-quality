package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.service.mapper;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AddressMapperTest {
    private AddressDto addressDto = null;
    private AddressModel addressModel = null;
    private Address address = null;
    @BeforeEach
    void setUp(){
        addressDto = new AddressDto(
                1,
                "street name",
                10000,
                "city name",
                "country name"
        );

        addressModel = AddressModel.builder()
                .addressID(null)
                .wayNum(1)
                .street("street name")
                .poBox(10000)
                .city("city name")
                .country("country name")
                .build();

        address = new Address(
                null,
                1,
                "street name",
                10000,
                "city name",
                "country name"
        );
    }

    @Test
    void testMapDtoToModel() {
        //WHEN
        AddressModel mappedAddress = AddressMapper.mapDtoToModel(addressDto);
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

    @Test
    void testMapModelToDto() {
        AddressDto addressDto = AddressMapper.mapModelToDto(addressModel);
        int actualWayNum = addressDto.getWayNum();
        String actualStreet = addressDto.getStreet();
        int actualPb = addressDto.getPoBox();
        String actualCity = addressDto.getCity();
        String actualCountry = addressDto.getCountry();
        String actual =""+actualWayNum+actualStreet+actualPb+actualCity+actualCountry;

        Assertions.assertThat(actual).isEqualTo(
                ""+addressModel.getWayNum()
                        +addressModel.getStreet()
                        +addressModel.getPoBox()
                        +addressModel.getCity()
                        +addressModel.getCountry()
        );
    }

    @Test
    void testMapModelToClass(){
        //WHEN
        Address mappedAddress = AddressMapper.mapModelToClass(addressModel);
        int actualWayNum = mappedAddress.getWayNum();
        String actualStreet = mappedAddress.getStreet();
        int actualPb = mappedAddress.getPoBox();
        String actualCity = mappedAddress.getCity();
        String actualCountry = mappedAddress.getCountry();
        String actual =""+actualWayNum+actualStreet+actualPb+actualCity+actualCountry;
        Assertions.assertThat(actual).isEqualTo(
                ""+addressModel.getWayNum()
                        +addressModel.getStreet()
                        +addressModel.getPoBox()
                        +addressModel.getCity()
                        +addressModel.getCountry()
        );
    }
    @Test
    void testMapClassToModel(){
        AddressModel mapped = AddressMapper.mapClassToModel(address);
        int wayNum = mapped.getWayNum();
        String street = mapped.getStreet();
        int pb = mapped.getPoBox();
        String city = mapped.getCity();
        String country = mapped.getCountry();
        String actual =""+wayNum+street+pb+city+country;
        assertThat(actual).isEqualTo(
                ""+address.getWayNum()
                +address.getStreet()
                +address.getPoBox()
                +address.getCity()
                +address.getCountry()
        );
    }
}