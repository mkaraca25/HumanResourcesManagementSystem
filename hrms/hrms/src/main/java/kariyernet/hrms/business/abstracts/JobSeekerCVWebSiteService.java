package kariyernet.hrms.business.abstracts;

import java.util.List;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.JobSeekerCVWebSite;

public interface JobSeekerCVWebSiteService extends BaseService<JobSeekerCVWebSite, Integer> {
	DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

}
