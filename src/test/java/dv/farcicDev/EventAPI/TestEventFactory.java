package dv.farcicDev.EventAPI;

import dv.farcicDev.EventAPI.core.domain.Event;
import dv.farcicDev.EventAPI.core.domain.TypeEnum;
import dv.farcicDev.EventAPI.infra.persistence.EventEntity;
import dv.farcicDev.EventAPI.presentation.controller.EventRequest;
import dv.farcicDev.EventAPI.presentation.controller.EventResponse;

import java.time.LocalDateTime;

public final class TestEventFactory {

    private static final LocalDateTime START_AT = LocalDateTime.of(2026, 5, 10, 19, 0);
    private static final LocalDateTime END_AT = LocalDateTime.of(2026, 5, 10, 22, 0);

    private TestEventFactory() {
    }

    public static Event event() {
        return new Event(
                1L,
                "Java Meetup",
                "Encontro sobre Spring Boot",
                "ABC123",
                START_AT,
                END_AT,
                "Sao Paulo",
                "FarcicDev",
                TypeEnum.PALESTRA
        );
    }

    public static Event eventWithoutIdAndIdentifier() {
        return new Event(
                null,
                "Java Meetup",
                "Encontro sobre Spring Boot",
                null,
                START_AT,
                END_AT,
                "Sao Paulo",
                "FarcicDev",
                TypeEnum.PALESTRA
        );
    }

    public static EventEntity entity() {
        return EventEntity.builder()
                .id(1L)
                .name("Java Meetup")
                .description("Encontro sobre Spring Boot")
                .identificador("ABC123")
                .startAt(START_AT)
                .endAt(END_AT)
                .location("Sao Paulo")
                .organizer("FarcicDev")
                .enumtype(TypeEnum.PALESTRA)
                .build();
    }

    public static EventRequest request() {
        return new EventRequest(
                "Java Meetup",
                "Encontro sobre Spring Boot",
                START_AT,
                END_AT,
                "Sao Paulo",
                "FarcicDev",
                TypeEnum.PALESTRA
        );
    }

    public static EventResponse response() {
        return EventResponse.builder()
                .id(1L)
                .name("Java Meetup")
                .description("Encontro sobre Spring Boot")
                .identificador("ABC123")
                .startAt(START_AT)
                .endAt(END_AT)
                .location("Sao Paulo")
                .organizer("FarcicDev")
                .enumtype(TypeEnum.PALESTRA)
                .build();
    }
}
