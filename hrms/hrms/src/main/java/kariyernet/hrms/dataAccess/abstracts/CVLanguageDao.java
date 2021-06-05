package kariyernet.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.CVLanguage;

public interface CVLanguageDao extends JpaRepository<CVLanguage, Integer> {
	List<CVLanguage> findAllByJobSeekerCV_Id(int jobSeekerCVId);

}
