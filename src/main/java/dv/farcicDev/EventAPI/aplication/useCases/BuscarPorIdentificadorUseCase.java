package dv.farcicDev.EventAPI.aplication.useCases;

import dv.farcicDev.EventAPI.core.domain.Event;

public interface BuscarPorIdentificadorUseCase {

    Event execute(String identificador);
}
