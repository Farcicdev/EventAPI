package dv.farcicDev.EventAPI.infra.gateways;

import dv.farcicDev.EventAPI.TestEventFactory;
import dv.farcicDev.EventAPI.core.domain.Event;
import dv.farcicDev.EventAPI.infra.persistence.EventEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventEntityMapperTest {

    private final EventEntityMapper mapper = new EventEntityMapper();

    @Test
    void toDomainShouldMapAllFields() {
        EventEntity entity = TestEventFactory.entity();

        Event event = mapper.toDomain(entity);

        assertEquals(entity.getId(), event.id());
        assertEquals(entity.getName(), event.name());
        assertEquals(entity.getDescription(), event.description());
        assertEquals(entity.getIdentificador(), event.identificador());
        assertEquals(entity.getStartAt(), event.startAt());
        assertEquals(entity.getEndAt(), event.endAt());
        assertEquals(entity.getLocation(), event.location());
        assertEquals(entity.getOrganizer(), event.organizer());
        assertEquals(entity.getEnumtype(), event.enumtype());
    }

    @Test
    void toInfraShouldMapAllFields() {
        Event event = TestEventFactory.event();

        EventEntity entity = mapper.toInfra(event);

        assertEquals(event.id(), entity.getId());
        assertEquals(event.name(), entity.getName());
        assertEquals(event.description(), entity.getDescription());
        assertEquals(event.identificador(), entity.getIdentificador());
        assertEquals(event.startAt(), entity.getStartAt());
        assertEquals(event.endAt(), entity.getEndAt());
        assertEquals(event.location(), entity.getLocation());
        assertEquals(event.organizer(), entity.getOrganizer());
        assertEquals(event.enumtype(), entity.getEnumtype());
    }
}
