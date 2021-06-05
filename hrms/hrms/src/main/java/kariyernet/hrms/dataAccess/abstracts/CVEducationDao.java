package kariyernet.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.CVEducation;

public interface CVEducationDao extends JpaRepository<CVEducation, Integer> {
	List<CVEducation> findAllByJobSeekerCV_Id(int jobSeekerId);

	List<CVEducation> findAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId);

	List<CVEducation> findAllByJobSeekerCV_IdOrderByGraduationDateDesc(int jobSeekerCVId);

}
