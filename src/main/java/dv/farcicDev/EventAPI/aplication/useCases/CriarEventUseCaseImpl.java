package dv.farcicDev.EventAPI.aplication.useCases;

import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.core.domain.Event;

import java.util.UUID;

public class CriarEventUseCaseImpl implements CriarEventUseCase {

    private final EventGateway gateway;

    public CriarEventUseCaseImpl(EventGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Event execute(Event event) {
        String identificador = identificadorUnico();

        Event novoEvento = new Event(
                event.id(),
                event.name(),
                event.description(),
                identificador,
                event.startAt(),
                event.endAt(),
                event.location(),
                event.organizer(),
                event.enumtype()
        );

        return gateway.criarEvento(novoEvento);
    }

    private String identificadorUnico(){
        String identificador;

        do{
            identificador = gerarIdentificador();
        }while (gateway.existsByIdentificador(identificador));

        return identificador;
    }

    private String gerarIdentificador(){
       return UUID.randomUUID().toString().replace("-", "").substring(0,6).toUpperCase();

    }
}

