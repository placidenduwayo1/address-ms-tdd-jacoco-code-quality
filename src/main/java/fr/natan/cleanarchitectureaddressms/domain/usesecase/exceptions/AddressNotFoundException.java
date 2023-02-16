package fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions;

public class AddressNotFoundException extends Exception {
    public AddressNotFoundException(String message) {
        super(message);
    }
}
