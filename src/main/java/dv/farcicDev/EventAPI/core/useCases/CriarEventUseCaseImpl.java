package dv.farcicDev.EventAPI.core.useCases;

import dv.farcicDev.EventAPI.core.domain.Event;

public class CriarEventUseCaseImpl implements CriarEventUseCase {

    private final CriarEventUseCase repository;

    public CriarEventUseCaseImpl(CriarEventUseCase repository) {
        this.repository = repository;
    }

    @Override
    public Event execute(Event event){
        return repository.execute(event);
    }
}

