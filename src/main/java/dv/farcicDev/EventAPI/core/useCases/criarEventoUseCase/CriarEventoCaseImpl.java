package dv.farcicDev.EventAPI.core.useCases.criarEventoUseCase;

import dv.farcicDev.EventAPI.core.domain.Event;

public class CriarEventoCaseImpl implements CriarEventoCase{

    private final CriarEventoCase repository;

    public CriarEventoCaseImpl(CriarEventoCase repository) {
        this.repository = repository;
    }

    @Override
    public Event execute(Event event){




        return repository.execute(event);
    }
}

