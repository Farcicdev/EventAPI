package dv.farcicDev.EventAPI.infra.beanConfig;

import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.aplication.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigEventBean {

    @Bean
    public CriarEventUseCase criarEvento(EventGateway gateway){
        return new CriarEventUseCaseImpl(gateway);
    }

    @Bean
    public ListEventUseCase listarEventos(EventGateway gateway){
        return new ListEventUseCaseImpl(gateway);
    }

    @Bean
    public BuscarPorIdentificadorUseCase buscarPorIdentificadorUseCase(EventGateway gateway){
        return new BuscarPorIdentificadorImpl(gateway);
    }


}
