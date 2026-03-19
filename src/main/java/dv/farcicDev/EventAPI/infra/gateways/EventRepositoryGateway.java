package dv.farcicDev.EventAPI.infra.gateways;

import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.core.domain.Event;
import dv.farcicDev.EventAPI.infra.persistence.EventEntity;
import dv.farcicDev.EventAPI.infra.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository repositoryJpa;
    private final EventEntityMapper entityMapper;


    @Override
    public Event criarEvento(Event event) {
        EventEntity entity = entityMapper.toInfra(event);
        EventEntity entitySaved = repositoryJpa.save(entity);

        return entityMapper.toDomain(entitySaved);
    }

    @Override
    public List<Event> findAll() {
        List<EventEntity> list = repositoryJpa.findAll();

        return list.stream()
                .map(entityMapper::toDomain)
                .toList();

    }

    @Override
    public boolean existsByIdentificador(String identificador) {
        return repositoryJpa.existsByIdentificador(identificador);
    }

    @Override
    public Optional<Event> findByIdentificador(String identificador) {
        Optional<EventEntity> entityOpt = repositoryJpa.findByIdentificador(identificador);
        return entityOpt.map(entityMapper::toDomain);
    }
}
