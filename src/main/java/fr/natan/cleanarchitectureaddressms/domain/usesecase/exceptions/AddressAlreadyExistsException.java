package fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions;

public class AddressAlreadyExistsException extends Exception {
    public AddressAlreadyExistsException(String message) {
        super(message);
    }
}
