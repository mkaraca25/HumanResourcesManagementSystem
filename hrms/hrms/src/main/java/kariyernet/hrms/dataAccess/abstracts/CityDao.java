package kariyernet.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Short>{
	Optional<City> findByName(String name);

	Optional<List<City>> findByNameContains(String name);
}
