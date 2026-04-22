package dv.farcicDev.EventAPI.presentation.controller;

import dv.farcicDev.EventAPI.TestEventFactory;
import dv.farcicDev.EventAPI.core.domain.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EventDTOMapperTest {

    private final EventDTOMapper mapper = new EventDTOMapper();

    @Test
    void toEventShouldMapRequestToDomain() {
        EventRequest request = TestEventFactory.request();

        Event event = mapper.toEvent(request);

        assertNull(event.id());
        assertNull(event.identificador());
        assertEquals(request.name(), event.name());
        assertEquals(request.description(), event.description());
        assertEquals(request.startAt(), event.startAt());
        assertEquals(request.endAt(), event.endAt());
        assertEquals(request.location(), event.location());
        assertEquals(request.organizer(), event.organizer());
        assertEquals(request.enumtype(), event.enumtype());
    }

    @Test
    void toResponseShouldMapDomainToResponse() {
        Event event = TestEventFactory.event();

        EventResponse response = mapper.toResponse(event);

        assertEquals(event.id(), response.id());
        assertEquals(event.name(), response.name());
        assertEquals(event.description(), response.description());
        assertEquals(event.identificador(), response.identificador());
        assertEquals(event.startAt(), response.startAt());
        assertEquals(event.endAt(), response.endAt());
        assertEquals(event.location(), response.location());
        assertEquals(event.organizer(), response.organizer());
        assertEquals(event.enumtype(), response.enumtype());
    }
}
