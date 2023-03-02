package fr.insa.injector.repositories;

import fr.insa.injector.model.data.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, String> {
}
