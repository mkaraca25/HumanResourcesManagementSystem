package kariyernet.hrms.business.abstracts;
import kariyernet.hrms.entities.concretes.JobSeekerCV;
import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;

public interface JobSeekerCVService extends BaseService<JobSeekerCV, Integer> {
	DataResult<JobSeekerCV> getByJobSeeker_Id(int jobSeekerId);

}
