package dv.farcicDev.EventAPI.aplication.useCases;

import dv.farcicDev.EventAPI.TestEventFactory;
import dv.farcicDev.EventAPI.aplication.exeption.EventNotFoundExeption;
import dv.farcicDev.EventAPI.aplication.gateways.EventGateway;
import dv.farcicDev.EventAPI.core.domain.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BuscarPorIdentificadorImplTest {

    private EventGateway gateway;
    private BuscarPorIdentificadorImpl useCase;

    @BeforeEach
    void setUp() {
        gateway = mock(EventGateway.class);
        useCase = new BuscarPorIdentificadorImpl(gateway);
    }

    @Test
    void executeShouldReturnEventWhenIdentifierExists() {
        Event event = TestEventFactory.event();
        when(gateway.findByIdentificador("ABC123")).thenReturn(Optional.of(event));

        Event result = useCase.execute("ABC123");

        assertEquals(event, result);
        verify(gateway).findByIdentificador("ABC123");
    }

    @Test
    void executeShouldThrowWhenIdentifierDoesNotExist() {
        when(gateway.findByIdentificador("ABC123")).thenReturn(Optional.empty());

        EventNotFoundExeption exception = assertThrows(
                EventNotFoundExeption.class,
                () -> useCase.execute("ABC123")
        );

        assertEquals("evento inexistente", exception.getMessage());
    }
}
