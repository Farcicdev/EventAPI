package dv.farcicDev.EventAPI.aplication.useCases;

import dv.farcicDev.EventAPI.aplication.exeption.EventAlreadyExistsException;
import dv.farcicDev.EventAPI.aplication.exeption.EventNotFoundExeption;
import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.core.domain.Event;

public class CriarEventUseCaseImpl implements CriarEventUseCase {

    private final EventGateway gateway;

    public CriarEventUseCaseImpl(EventGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Event execute(Event event) {

        if(gateway.existsByIdentificador(event.identificador())){

            throw new EventAlreadyExistsException("Evento ja cadastrado");

        }

        return gateway.criarEvento(event);
    }
}

