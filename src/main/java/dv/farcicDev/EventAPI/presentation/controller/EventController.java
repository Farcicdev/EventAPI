package dv.farcicDev.EventAPI.presentation.controller;

import dv.farcicDev.EventAPI.core.domain.Event;
import dv.farcicDev.EventAPI.core.useCases.CriarEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final CriarEventUseCase saveEvent;

    private final EventDTOMapper dtoMapper;

    @PostMapping("/criar")
    public ResponseEntity<EventResponse> save(@RequestBody EventRequest request) {
        Event event = dtoMapper.toEvent(request);
        Event eventSaved = saveEvent.execute(event);
        EventResponse response = dtoMapper.toResponse(eventSaved);

        return ResponseEntity.ok(response);
    }

}
