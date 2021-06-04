package kariyernet.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.JobSeekerCVExperience;

public interface JobSeekerCVExperienceDao extends JpaRepository<JobSeekerCVExperience, Integer> {
	List<JobSeekerCVExperience> findAllByJobSeekerCV_Id(int jobSeekerCVId);

	List<JobSeekerCVExperience> findAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId);

	List<JobSeekerCVExperience> findAllByJobSeekerCV_IdOrderByQuitDateDesc(int jobSeekerCVId);

}
