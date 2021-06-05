package kariyernet.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.CVExperience;

public interface CVExperienceDao extends JpaRepository<CVExperience, Integer> {
	List<CVExperience> findAllByJobSeekerCV_Id(int jobSeekerCVId);

	List<CVExperience> findAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId);

	List<CVExperience> findAllByJobSeekerCV_IdOrderByQuitDateDesc(int jobSeekerCVId);

}
