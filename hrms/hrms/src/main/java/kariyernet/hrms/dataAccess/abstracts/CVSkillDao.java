package kariyernet.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kariyernet.hrms.entities.concretes.CVSkill;

public interface CVSkillDao extends JpaRepository<CVSkill, Integer> {
	List<CVSkill> findAllByJobSeekerCV_Id(int jobSeekerCVId);

}
