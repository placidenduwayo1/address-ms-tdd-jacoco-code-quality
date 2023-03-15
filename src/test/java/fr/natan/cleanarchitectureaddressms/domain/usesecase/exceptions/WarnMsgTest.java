package fr.natan.cleanarchitectureaddressms.domain.usesecase.exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WarnMsgTest {
    @Test
    void getException() {
        assertAll(
                () -> assertThat(WarnMsg.ADDRESS_FIELDS_INVALID.getException())
                        .isEqualTo("address exception: One or more address fields invalid"),
                () -> assertThat(WarnMsg.ADDRESS_NOT_FOUND.getException())
                        .isEqualTo("address exception: address not found"),
                () -> assertThat(WarnMsg.ADDRESS_ALREADY_EXISTS.getException())
                        .isEqualTo("address exception: address  already exists")
        );
    }
}