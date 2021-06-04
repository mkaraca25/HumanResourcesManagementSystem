package kariyernet.hrms.business.abstracts;
import kariyernet.hrms.entities.concretes.JobSeekerCVLanguage;

import java.util.List;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;

public interface JobSeekerCVLanguageService extends BaseService<JobSeekerCVLanguage, Integer> {
	DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

}
