package dv.farcicDev.EventAPI.infra.dtos.response;
import dv.farcicDev.EventAPI.core.domain.TypeEnum;
import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record EventResponse(

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
