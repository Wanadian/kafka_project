package fr.insa.api.repositories;

import fr.insa.api.models.CountryStatistics;
import org.springframework.data.repository.CrudRepository;

public interface CovidRepository extends CrudRepository<CountryStatistics, Long> {
}
