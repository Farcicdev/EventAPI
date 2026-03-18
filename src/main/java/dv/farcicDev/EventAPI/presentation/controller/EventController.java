package dv.farcicDev.EventAPI.presentation.controller;

import dv.farcicDev.EventAPI.core.domain.Event;
import dv.farcicDev.EventAPI.aplication.useCases.CriarEventUseCase;
import dv.farcicDev.EventAPI.aplication.useCases.ListEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final ListEventUseCase listEventUseCase;
    private final CriarEventUseCase saveEvent;
    private final EventDTOMapper dtoMapper;

    @PostMapping("/criar")
    public ResponseEntity<EventResponse> save(@RequestBody EventRequest request) {
        Event event = dtoMapper.toEvent(request);
        Event eventSaved = saveEvent.execute(event);
        EventResponse response = dtoMapper.toResponse(eventSaved);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EventResponse>> listarEventos(){
        List<EventResponse> listar = listEventUseCase.execute()
                .stream()
                .map(event -> dtoMapper.toResponse(event))
                .toList();

        return ResponseEntity.ok(listar);
    }
}
