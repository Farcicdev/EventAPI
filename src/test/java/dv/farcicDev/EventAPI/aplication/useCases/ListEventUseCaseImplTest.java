package dv.farcicDev.EventAPI.aplication.useCases;

import dv.farcicDev.EventAPI.TestEventFactory;
import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.core.domain.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ListEventUseCaseImplTest {

    private EventGateway gateway;
    private ListEventUseCaseImpl useCase;

    @BeforeEach
    void setUp() {
        gateway = mock(EventGateway.class);
        useCase = new ListEventUseCaseImpl(gateway);
    }

    @Test
    void executeShouldReturnAllEvents() {
        List<Event> events = List.of(TestEventFactory.event());
        when(gateway.findAll()).thenReturn(events);

        List<Event> result = useCase.execute();

        assertEquals(events, result);
        verify(gateway).findAll();
    }
}
