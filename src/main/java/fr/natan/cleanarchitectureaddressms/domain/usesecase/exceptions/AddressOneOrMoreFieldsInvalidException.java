package fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions;

public class AddressOneOrMoreFieldsInvalidException extends Exception{
    public AddressOneOrMoreFieldsInvalidException(String message) {
        super(message);
    }
}
