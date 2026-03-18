package dv.farcicDev.EventAPI.aplication.useCases;

import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.core.domain.Event;

import java.util.List;

public class ListEventUseCaseImpl implements ListEventUseCase {

    private final EventGateway gateway;

    public ListEventUseCaseImpl(EventGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Event> execute() {
        return null;
    }
}
