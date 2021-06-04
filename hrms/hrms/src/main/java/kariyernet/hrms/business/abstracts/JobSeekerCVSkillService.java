package kariyernet.hrms.business.abstracts;
import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.*;
import java.util.List;
public interface JobSeekerCVSkillService extends BaseService<JobSeekerCVSkill, Integer> {
	DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

}
