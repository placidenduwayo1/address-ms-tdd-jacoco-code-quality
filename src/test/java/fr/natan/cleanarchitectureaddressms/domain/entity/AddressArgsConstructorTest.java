package fr.natan.cleanarchitectureaddressms.domain.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("AddressTest")
@DisplayName("Test of constructor")
class AddressArgsConstructorTest {

    private Address address;
    @BeforeEach
    void setUp() {
        address = new Address(1L, 1, "street name", 10000, "city name", "country name"
        );
    }
    @Test
    void argsConstructorShouldCreateObject(){
        Assertions.assertThat(address).isNotNull();
    }
}