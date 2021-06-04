package kariyernet.hrms.business.abstracts;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.JobSeeker;
import kariyernet.hrms.entities.dto.JobSeekerForRegisterDto;

public interface JobSeekerService extends BaseService<JobSeeker, Integer> {
	DataResult<JobSeeker> getByIdentityNumber(String identityNumber);

	Result isNotNationalIdentityExist(String identityNumber);

	Result register(JobSeekerForRegisterDto jobSeekerForRegisterDto);
}
