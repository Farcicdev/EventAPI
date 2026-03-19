package dv.farcicDev.EventAPI.aplication.gateways;

import dv.farcicDev.EventAPI.core.domain.Event;

import java.util.List;

public interface EventGateway {

    Event criarEvento(Event event);

    List<Event> findAll();

    boolean existsByIdentificador(String identificador);
}


