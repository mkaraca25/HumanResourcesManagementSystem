package kariyernet.hrms.business.abstracts;
import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.CVSkill;
import java.util.List;

public interface CVSkillService extends BaseService<CVSkill, Integer> {
	DataResult<List<CVSkill>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

}
