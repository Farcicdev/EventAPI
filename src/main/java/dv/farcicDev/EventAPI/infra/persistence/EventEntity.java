package dv.farcicDev.EventAPI.infra.persistence;

import dv.farcicDev.EventAPI.core.domain.TypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Column(name = "description", nullable = false,columnDefinition = "TEXT")
    private String description;
    @Column(name = "identificador", unique = true, nullable = false, length = 50)
    private String identificador;
    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt;
    @Column(name = "end_at", nullable = false)
    private LocalDateTime endAt;
    @Column(name = "location", nullable = false, length = 200)
    private String location;
    @Column(name = "organizer",nullable = false, length = 150)
    private String organizer;
    @Enumerated(EnumType.STRING)
    @Column(name = "enumtype",nullable = false,length = 30)
    private TypeEnum enumtype;

}
