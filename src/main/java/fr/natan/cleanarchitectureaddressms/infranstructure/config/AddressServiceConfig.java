package fr.natan.cleanarchitectureaddressms.infranstructure.config;

import fr.natan.cleanarchitectureaddressms.domain.ports.output.AddressOutputService;
import fr.natan.cleanarchitectureaddressms.domain.usesecase.AddressInputServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceConfig {
    @Bean
    public AddressInputServiceImpl configureAddressUseCase(
            @Autowired AddressOutputService addressOutputService){
        return new AddressInputServiceImpl(addressOutputService);
    }
}
