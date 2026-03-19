package dv.farcicDev.EventAPI.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    boolean existsByIdentificador(String identificador);

    Optional<EventEntity> findByIdentificador(String identificador);

}
