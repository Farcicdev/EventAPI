package dv.farcicDev.EventAPI.core.useCases.criarEventoUseCase;

import dv.farcicDev.EventAPI.core.domain.Event;

public interface CriarEventoCase {

    Event execute(Event event);

}
