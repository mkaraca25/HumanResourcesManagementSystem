package kariyernet.hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.JobSeekerCVLanguage;
public interface JobSeekerCVLanguageDao extends JpaRepository<JobSeekerCVLanguage, Integer> {
	List<JobSeekerCVLanguage> findAllByJobSeekerCV_Id(int jobSeekerCVId);

}
