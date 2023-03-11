package fr.insa.processor.repositories;

import fr.insa.processor.models.Global;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GlobalRepository extends JpaRepository<Global, UUID> {
    Global findFirstByOrderByDateDesc();
}
