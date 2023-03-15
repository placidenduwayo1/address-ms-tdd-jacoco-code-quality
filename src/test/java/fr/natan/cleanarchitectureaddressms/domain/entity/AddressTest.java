package fr.natan.cleanarchitectureaddressms.domain.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

@Tag("AddressTest")
@DisplayName("Test related to entity address")
class AddressTest {
    private Address address;
    @BeforeEach
    void setUp(){
        address = new Address();
    }

    @Test
    void getAddressIDShouldReturnAddressID() {
        Assertions.assertThat(address.getAddressID()).isNull();
    }

    @Test
    void setAddressIDShouldSetAddressID() {
        Long addressID =1L;
        address.setAddressID(addressID);
        Long actual = address.getAddressID();
        Assertions.assertThat(actual).isNotZero();
    }

    @Test
    void getWayNumberShouldReturnAddressWayNum() {
        Assertions.assertThat(address.getWayNum()).isZero();
    }

    @Test
    void setWayNumberShouldSetAddressWayNum() {
        int wayNum = 1;
        address.setWayNum(wayNum);
        int actual = address.getWayNum();
        Assertions.assertThat(actual).isNotZero();
    }

    @Test
    void getStreetShouldReturnAddressStreet() {
        Assertions.assertThat(address.getStreet()).isNull();
    }

    @Test
    void setStreetShouldSetAddressStreet() {
        String street ="street name";
        address.setStreet(street);
        String actual = address.getStreet();
        Assertions.assertThat(actual).isEqualTo("street name");
    }

    @Test
    void getPbShouldReturnAddressPb() {
        Assertions.assertThat(address.getPoBox()).isZero();
    }

    @Test
    void setPbShouldSetAddressPb() {
        int pb = 10000;
        address.setPoBox(pb);
        int actual = address.getPoBox();
        Assertions.assertThat(actual).isNotZero();
    }

    @Test
    void getCityShouldReturnAddressCity() {
        Assertions.assertThat(address.getCity()).isNull();
    }

    @Test
    void setCityShouldSetAddressCity() {
        String city = "city name";
        address.setCity(city);
        String actual = address.getCity();
        Assertions.assertThat(actual).isNotNull();
    }

    @Test
    void getCountryShouldReturnAddressCountry() {
        Assertions.assertThat(address.getCountry()).isNull();
    }

    @Test
    void setCountryShouldAddressCountry() {
        String country ="country name";
        address.setCountry(country);
        String actual = address.getCountry();
        Assertions.assertThat(actual).isNotNull();
    }
}