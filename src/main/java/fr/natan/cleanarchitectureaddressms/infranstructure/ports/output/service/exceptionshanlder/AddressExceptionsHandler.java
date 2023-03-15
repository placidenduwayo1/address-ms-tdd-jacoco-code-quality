package fr.natan.cleanarchitectureaddressms.infranstructure.ports.output.service.exceptionshanlder;

import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressAlreadyExistsException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressNotFoundException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.AddressOneOrMoreFieldsInvalidException;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions.WarnMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressExceptionsHandler {
    @ExceptionHandler(value = AddressAlreadyExistsException.class)
    private ResponseEntity<String> handleAddressAlreadyExistsException(){
        return new ResponseEntity<>(WarnMsg.ADDRESS_ALREADY_EXISTS.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = AddressOneOrMoreFieldsInvalidException.class)
    private ResponseEntity<String> handleOneOrMoreAddressFieldsInvalidException(){
        return new ResponseEntity<>(WarnMsg.ADDRESS_FIELDS_INVALID.getException(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(value = AddressNotFoundException.class)
    private ResponseEntity<String> handleAddressNotFoundException(){
        return new ResponseEntity<>(WarnMsg.ADDRESS_NOT_FOUND.getException(),HttpStatus.NOT_FOUND);
    }
}

