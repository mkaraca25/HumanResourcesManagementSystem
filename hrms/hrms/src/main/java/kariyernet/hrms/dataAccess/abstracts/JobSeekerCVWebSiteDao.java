package kariyernet.hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.JobSeekerCVWebSite;
public interface JobSeekerCVWebSiteDao extends JpaRepository<JobSeekerCVWebSite, Integer> {
	List<JobSeekerCVWebSite> findAllByJobSeekerCV_Id(int jobSeekerCVId);

}
