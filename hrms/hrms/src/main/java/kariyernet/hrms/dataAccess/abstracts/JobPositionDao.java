package kariyernet.hrms.dataAccess.abstracts;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.JobPosition;
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	Optional<JobPosition> findByTitle(String title);
}
