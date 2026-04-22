package dv.farcicDev.EventAPI.infra.gateways;

import dv.farcicDev.EventAPI.TestEventFactory;
import dv.farcicDev.EventAPI.core.domain.Event;
import dv.farcicDev.EventAPI.infra.persistence.EventEntity;
import dv.farcicDev.EventAPI.infra.persistence.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EventRepositoryGatewayTest {

    private EventRepository repository;
    private EventEntityMapper mapper;
    private EventRepositoryGateway gateway;

    @BeforeEach
    void setUp() {
        repository = mock(EventRepository.class);
        mapper = mock(EventEntityMapper.class);
        gateway = new EventRepositoryGateway(repository, mapper);
    }

    @Test
    void criarEventoShouldSaveEntityAndReturnDomain() {
        Event event = TestEventFactory.event();
        EventEntity entity = TestEventFactory.entity();

        when(mapper.toInfra(event)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(event);

        Event result = gateway.criarEvento(event);

        assertEquals(event, result);
        verify(repository).save(entity);
    }

    @Test
    void findAllShouldReturnMappedEvents() {
        Event event = TestEventFactory.event();
        EventEntity entity = TestEventFactory.entity();

        when(repository.findAll()).thenReturn(List.of(entity));
        when(mapper.toDomain(entity)).thenReturn(event);

        List<Event> result = gateway.findAll();

        assertEquals(List.of(event), result);
    }

    @Test
    void existsByIdentificadorShouldDelegateToRepository() {
        when(repository.existsByIdentificador("ABC123")).thenReturn(true);

        assertTrue(gateway.existsByIdentificador("ABC123"));
        verify(repository).existsByIdentificador("ABC123");
    }

    @Test
    void findByIdentificadorShouldReturnMappedEventWhenFound() {
        Event event = TestEventFactory.event();
        EventEntity entity = TestEventFactory.entity();

        when(repository.findByIdentificador("ABC123")).thenReturn(Optional.of(entity));
        when(mapper.toDomain(entity)).thenReturn(event);

        Optional<Event> result = gateway.findByIdentificador("ABC123");

        assertTrue(result.isPresent());
        assertEquals(event, result.get());
    }

    @Test
    void findByIdentificadorShouldReturnEmptyWhenNotFound() {
        when(repository.findByIdentificador("ABC123")).thenReturn(Optional.empty());

        Optional<Event> result = gateway.findByIdentificador("ABC123");

        assertFalse(result.isPresent());
    }
}
