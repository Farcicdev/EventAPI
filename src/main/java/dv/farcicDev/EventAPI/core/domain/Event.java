package dv.farcicDev.EventAPI.core.domain;

import java.time.LocalDateTime;

public record Event(

        Long id,
        String name,
        String description,
        String identificador,
        LocalDateTime startAt,
        LocalDateTime endAt,
        String location,
        String organizer,
        TypeEnum enumtype

) {
}
