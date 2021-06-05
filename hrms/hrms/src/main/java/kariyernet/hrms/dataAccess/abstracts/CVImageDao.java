package kariyernet.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.CVImage;

public interface CVImageDao extends JpaRepository<CVImage, Integer> {
	List<CVImage> findAllByJobSeekerCV_Id(int jobSeekerCVId);

}
