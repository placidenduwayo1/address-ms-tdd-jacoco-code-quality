package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("AddressModel")
@DisplayName("Address model tests")
class AddressModelTest {
    private AddressModel addressNoArgsConstructor = null;
    private AddressModel addressArgsConstructor = null;

    @BeforeEach
    void setUp() {
        addressNoArgsConstructor = new AddressModel();
        addressArgsConstructor = new AddressModel(
                null,
                1,
                "street name",
                10000,
                "city name",
                "country name"
        );
    }

    @Test
    void itShouldCreateAddressObjectWithValues() {
        Assertions.assertThat(addressArgsConstructor).isNotNull();
    }

    @Test
    void getAddressIDShouldReturnAddressID() {
        Assertions.assertThat(addressNoArgsConstructor.getAddressID()).isNull();
    }

    @Test
    void getWayNumber() {
        Assertions.assertThat(addressNoArgsConstructor.getWayNum()).isZero();
    }

    @Test
    void getStreet() {
        Assertions.assertThat(addressNoArgsConstructor.getStreet()).isNull();
    }

    @Test
    void getPb() {
        Assertions.assertThat(addressNoArgsConstructor.getPoBox()).isZero();
    }

    @Test
    void getCity() {
        Assertions.assertThat(addressNoArgsConstructor.getCity()).isNull();
    }

    @Test
    void getCountry() {
        Assertions.assertThat(addressNoArgsConstructor.getCountry()).isNull();
    }

    @Test
    void setAddressID() {
        //GIVEN
        Long addressID = 1L;
        addressNoArgsConstructor.setAddressID(addressID);
        //WHEN
        Long id = addressNoArgsConstructor.getAddressID();
        //THEN
        Assertions.assertThat(id).isEqualTo(1L);
    }

    @Test
    void setWayNumber() {
        int wayNum = 1;
        addressNoArgsConstructor.setWayNum(wayNum);
        int actual = addressNoArgsConstructor.getWayNum();
        Assertions.assertThat(actual).isEqualTo(1);
    }

    @Test
    void setStreet() {
        String street = "street name";
        addressNoArgsConstructor.setStreet(street);
        String actual = addressNoArgsConstructor.getStreet();
        Assertions.assertThat(actual).isEqualTo("street name");
    }

    @Test
    void setPb() {
        int pb = 10000;
        addressNoArgsConstructor.setPoBox(pb);
        int actual = addressNoArgsConstructor.getPoBox();
        Assertions.assertThat(actual).isNotZero();
    }

    @Test
    void setCity() {
        String city = "city name";
        addressNoArgsConstructor.setCity(city);
        String actual = addressNoArgsConstructor.getCity();
        Assertions.assertThat(actual).isNotNull();
    }

    @Test
    void setCountry() {
        String country = "country name";
        addressNoArgsConstructor.setCountry(country);
        String actual = addressNoArgsConstructor.getCountry();
        Assertions.assertThat(actual).isNotNull();
    }
}