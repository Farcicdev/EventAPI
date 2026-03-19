package dv.farcicDev.EventAPI.infra.gateways;

import dv.farcicDev.EventAPI.core.domain.Event;
import dv.farcicDev.EventAPI.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public Event toDomain(EventEntity entityInfra){
        return new Event(
                entityInfra.getId(),
                entityInfra.getName(),
                entityInfra.getDescription(),
                entityInfra.getIdentificador(),
                entityInfra.getStartAt(),
                entityInfra.getEndAt(),
                entityInfra.getLocation(),
                entityInfra.getOrganizer(),
                entityInfra.getEnumtype()
        );
    }

    public EventEntity toInfra(Event event){
        return EventEntity.builder()
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
