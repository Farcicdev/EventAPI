package dv.farcicDev.EventAPI.infra.dtos.request;

import dv.farcicDev.EventAPI.core.domain.TypeEnum;

import java.time.LocalDateTime;

public record EventRequest(
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
