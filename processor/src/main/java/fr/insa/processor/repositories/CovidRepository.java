package fr.insa.processor.repositories;

import fr.insa.processor.models.CountryStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidRepository extends CrudRepository<CountryStatistics, Long> {
}
