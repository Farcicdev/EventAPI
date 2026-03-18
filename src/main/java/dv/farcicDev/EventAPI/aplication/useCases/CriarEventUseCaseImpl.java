package dv.farcicDev.EventAPI.aplication.useCases;

import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.core.domain.Event;

public class CriarEventUseCaseImpl implements CriarEventUseCase {

    private final EventGateway gateway;

    public CriarEventUseCaseImpl(EventGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Event execute(Event event) {
        return null;
    }
}

