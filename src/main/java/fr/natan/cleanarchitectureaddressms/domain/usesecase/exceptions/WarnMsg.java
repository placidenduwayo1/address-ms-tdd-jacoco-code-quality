package fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions;

public enum WarnMsg {
    ADDRESS_ALREADY_EXISTS("address exception: address  already exists"),
    ADDRESS_FIELDS_INVALID("address exception: One or more address fields invalid"),
    ADDRESS_NOT_FOUND("address exception: address not found");

    private final String exception;

    WarnMsg(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
    }
}
