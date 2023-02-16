package fr.natan.cleanarchitectureaddressms.infranstructure.ports.input;

import fr.natan.cleanarchitectureaddressms.domain.entity.Address;
import fr.natan.cleanarchitectureaddressms.domain.ports.input.AddressInputService;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressAlreadyExistsException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressNotFoundException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressOneOrMoreFieldsInvalidException;
import fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.models.AddressDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class AddressController {
    private final AddressInputService addressInputService;

    public AddressController(AddressInputService addressService) {
        this.addressInputService = addressService;
    }

    @PostMapping(value = "/addresses")
    public AddressDto createAddress(@RequestBody AddressDto addressDto) throws AddressAlreadyExistsException,
            AddressOneOrMoreFieldsInvalidException {
        return addressInputService.createAddress(addressDto);
    }

    @GetMapping(value = "/addresses")
    public Collection<Address> loadAllAddresses(){
        return addressInputService.loadAllAddresses();
    }
    @GetMapping(value = "/addresses/{addressID}")
    public Optional<Address> loadAddressByID(@PathVariable(name = "addressID") Long addressID) throws AddressNotFoundException {
        return addressInputService.loadAddressByID(addressID);
    }
    @DeleteMapping(value = "/addresses/{addressID}")
    public String deleteAddress(@PathVariable(name = "addressID") Long addressID) throws AddressNotFoundException {
        addressInputService.deleteAddress(addressID);
        return null;
    }
    @PutMapping(value = "/addresses/{addressID}")
    public Address updateAddress(@RequestBody AddressDto addressDto, @PathVariable(name = "addressID") Long addressID)
            throws AddressOneOrMoreFieldsInvalidException, AddressNotFoundException {
       return addressInputService.updateAddress(addressID, addressDto);
    }
}
