package dv.farcicDev.EventAPI.aplication.useCases;

import dv.farcicDev.EventAPI.TestEventFactory;
import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.core.domain.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CriarEventUseCaseImplTest {

    private EventGateway gateway;
    private CriarEventUseCaseImpl useCase;

    @BeforeEach
    void setUp() {
        gateway = mock(EventGateway.class);
        useCase = new CriarEventUseCaseImpl(gateway);
    }

    @Test
    void executeShouldGenerateIdentifierAndCreateEvent() {
        Event event = TestEventFactory.eventWithoutIdAndIdentifier();

        when(gateway.existsByIdentificador(anyString())).thenReturn(false);
        when(gateway.criarEvento(any(Event.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Event created = useCase.execute(event);

        assertNotNull(created.identificador());
        assertTrue(created.identificador().matches("[A-Z0-9]{6}"));
        assertEquals(event.name(), created.name());
        assertEquals(event.description(), created.description());
        assertEquals(event.startAt(), created.startAt());
        assertEquals(event.endAt(), created.endAt());
        assertEquals(event.location(), created.location());
        assertEquals(event.organizer(), created.organizer());
        assertEquals(event.enumtype(), created.enumtype());

        ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
        verify(gateway).criarEvento(eventCaptor.capture());
        assertEquals(created.identificador(), eventCaptor.getValue().identificador());
    }
}
