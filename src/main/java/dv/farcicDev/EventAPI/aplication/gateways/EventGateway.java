package dv.farcicDev.EventAPI.aplication.gateways;

import dv.farcicDev.EventAPI.core.domain.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {

    Event criarEvento(Event event);

    List<Event> findAll();

    boolean existsByIdentificador(String identificador);

    Optional<Event> findByIdentificador(String identificador);
}


