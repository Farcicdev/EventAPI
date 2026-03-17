package dv.farcicDev.EventAPI.presentation.controller;

import dv.farcicDev.EventAPI.core.domain.Event;
import org.springframework.stereotype.Component;

@Component
public class EventDTOMapper {

    public Event toEvent(EventRequest request){
        return new Event(
                null,
                request.name(),
                request.description(),
                request.identificador(),
                request.startAt(),
                request.endAt(),
                request.location(),
                request.organizer(),
                request.enumtype()
        );
    }

    public EventResponse toResponse(Event event){
        return EventResponse.builder()
                .id(event.id())
                .name(event.name())
                .description(event.description())
                .identificador(event.identificador())
                .startAt(event.startAt())
                .endAt(event.endAt())
                .location(event.location())
                .organizer(event.organizer())
                .enumtype(event.enumtype())
                .build();
    }

}
