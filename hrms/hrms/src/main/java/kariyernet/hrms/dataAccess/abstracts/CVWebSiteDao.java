package kariyernet.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.CVWebSite;

public interface CVWebSiteDao extends JpaRepository<CVWebSite, Integer> {
	List<CVWebSite> findAllByJobSeekerCV_Id(int jobSeekerCVId);

}
