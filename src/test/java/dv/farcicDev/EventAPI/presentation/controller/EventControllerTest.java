package dv.farcicDev.EventAPI.presentation.controller;

import dv.farcicDev.EventAPI.TestEventFactory;
import dv.farcicDev.EventAPI.aplication.useCases.BuscarPorIdentificadorUseCase;
import dv.farcicDev.EventAPI.aplication.useCases.CriarEventUseCase;
import dv.farcicDev.EventAPI.aplication.useCases.ListEventUseCase;
import dv.farcicDev.EventAPI.core.domain.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EventControllerTest {

    private BuscarPorIdentificadorUseCase findByIdentificador;
    private ListEventUseCase listEventUseCase;
    private CriarEventUseCase saveEvent;
    private EventDTOMapper dtoMapper;
    private EventController controller;

    @BeforeEach
    void setUp() {
        findByIdentificador = mock(BuscarPorIdentificadorUseCase.class);
        listEventUseCase = mock(ListEventUseCase.class);
        saveEvent = mock(CriarEventUseCase.class);
        dtoMapper = mock(EventDTOMapper.class);
        controller = new EventController(findByIdentificador, listEventUseCase, saveEvent, dtoMapper);
    }

    @Test
    void saveShouldCreateEventAndReturnResponse() {
        EventRequest request = TestEventFactory.request();
        Event event = TestEventFactory.eventWithoutIdAndIdentifier();
        Event savedEvent = TestEventFactory.event();
        EventResponse response = TestEventFactory.response();

        when(dtoMapper.toEvent(request)).thenReturn(event);
        when(saveEvent.execute(event)).thenReturn(savedEvent);
        when(dtoMapper.toResponse(savedEvent)).thenReturn(response);

        ResponseEntity<EventResponse> result = controller.save(request);

        assertEquals(200, result.getStatusCode().value());
        assertEquals(response, result.getBody());
        verify(saveEvent).execute(event);
    }

    @Test
    void listarEventosShouldReturnMappedResponses() {
        Event event = TestEventFactory.event();
        EventResponse response = TestEventFactory.response();

        when(listEventUseCase.execute()).thenReturn(List.of(event));
        when(dtoMapper.toResponse(event)).thenReturn(response);

        ResponseEntity<List<EventResponse>> result = controller.listarEventos();

        assertEquals(200, result.getStatusCode().value());
        assertEquals(List.of(response), result.getBody());
    }

    @Test
    void buscarPorIdentificadorShouldReturnMappedResponse() {
        Event event = TestEventFactory.event();
        EventResponse response = TestEventFactory.response();

        when(findByIdentificador.execute("ABC123")).thenReturn(event);
        when(dtoMapper.toResponse(event)).thenReturn(response);

        ResponseEntity<EventResponse> result = controller.buscarPorIdentificador("ABC123");

        assertEquals(200, result.getStatusCode().value());
        assertEquals(response, result.getBody());
        verify(findByIdentificador).execute("ABC123");
    }
}
