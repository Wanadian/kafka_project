package fr.insa.injector.repositories;

import fr.insa.injector.model.data.GlobalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GlobalRepository extends JpaRepository<GlobalEntity, UUID> {
}
