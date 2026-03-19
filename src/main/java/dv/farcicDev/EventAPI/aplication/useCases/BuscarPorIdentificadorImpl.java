package dv.farcicDev.EventAPI.aplication.useCases;

import dv.farcicDev.EventAPI.aplication.exeption.EventNotFoundExeption;
import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.core.domain.Event;

public class BuscarPorIdentificadorImpl implements BuscarPorIdentificadorUseCase {

    private final EventGateway gateway;

    public BuscarPorIdentificadorImpl(EventGateway gateway) {
        this.gateway = gateway;
    }


    @Override
    public Event execute(String identificador) {
        return gateway.findByIdentificador(identificador)
                .orElseThrow(() -> new EventNotFoundExeption("evento inexistente"));
    }
}

