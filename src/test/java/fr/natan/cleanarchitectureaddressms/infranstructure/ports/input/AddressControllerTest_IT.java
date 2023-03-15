package fr.natan.cleanarchitectureaddressms.infranstructure.ports.input;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressModel;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.repository.AddressRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Tag("IT")
@DisplayName("Integration tests, test of controller")
class AddressControllerTest_IT {
    private static RestTemplate restTemplate;
    @Autowired
    private AddressRepository addressRepository;
    @LocalServerPort
    private int randomPort;
    private String baseUrl = "http://localhost";

    @BeforeAll
    public static void initRestTemplate() {
        restTemplate = new RestTemplate();
    }


    @BeforeEach
    void setUp() {
        baseUrl = baseUrl.concat(":").concat(randomPort + "");
    }

    @Test
    void createAddressEndPoint() {
        AddressDto addressDto = new AddressDto(
                1, "street", 10000, "city", "country"
        );
        AddressDto response = restTemplate.postForObject(baseUrl + "/addresses", addressDto, AddressDto.class);
        assert response != null;
        assertAll(
                () -> assertThat(response.getCity()).isEqualTo("city"),
                () -> assertThat(addressRepository.findAll()).hasSize(1)
        );
    }

    @Test
    @Sql(statements = "INSERT INTO ADDRESSES(ADDRESSID,WAY_NUM,STREET,PO_BOX,CITY,COUNTRY) " +
            "VALUES (1L, 1,'street',10000,'city','country')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM ADDRESSES WHERE CITY='city'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void loadAllAddresses() {
        List<Address> addresses = restTemplate.getForObject(baseUrl + "/addresses", List.class);
        assertThat(addresses).isNotEmpty();
        assertAll(
                () -> assertThat(addressRepository.findAll()).isNotEmpty(),
                () -> assertThat(addressRepository.findAll()).hasSize(1),
                () -> assertThat(addressRepository
                        .findById(1L)
                        .get()
                        .getStreet())
                        .isEqualTo("street")
        );
    }

    @Test
    @Sql(statements = "INSERT INTO ADDRESSES(WAY_NUM,STREET,PO_BOX,CITY,COUNTRY) " +
            "VALUES (1,'street',10000,'city','country')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM ADDRESSES WHERE CITY='city'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testFindAddressByID() {
        Address address = restTemplate.getForObject(baseUrl + "/addresses/{addressID}", Address.class, 1L);
        assertThat(address).isNotNull();
    }

    @Test
    @Sql(statements = "INSERT INTO ADDRESSES(ADDRESSID,WAY_NUM,STREET,PO_BOX,CITY,COUNTRY) " +
            "VALUES (1L, 1,'street',10000,'city','country')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void testDeleteAddress() {
        int record = addressRepository.findAll().size();
        assertThat(record).isEqualTo(1);
        restTemplate.delete(baseUrl + "/addresses/{addressID}", 1L);
        assertAll(
                () -> assertThat(addressRepository.findAll()).isEmpty()
        );
    }

    @Test
    @Sql(statements = "INSERT INTO ADDRESSES(ADDRESSID,WAY_NUM,STREET,PO_BOX,CITY,COUNTRY) " +
            "VALUES (1L, 1,'street',10000,'city','country')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM ADDRESSES WHERE ADDRESSID=1L", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testUpdateAddress() {
        AddressDto addressDto = new AddressDto(4, "street name", 10, "city name", "country name");
        Exception exception = assertThrows(Exception.class,
                () -> restTemplate.put(baseUrl + "/addresses/{addressID}", addressDto, 1L));
        AddressModel addressModel = addressRepository.findById(1L).get();
        assertAll(
                () -> assertThat(addressModel).isNotNull(),
                () -> assertThat(exception.getMessage()).isNotNull()
        );
    }
}