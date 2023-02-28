package fr.insa.api.repositories;

import fr.insa.api.models.CountryStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidRepository extends CrudRepository<CountryStatistics, Long> {
}
