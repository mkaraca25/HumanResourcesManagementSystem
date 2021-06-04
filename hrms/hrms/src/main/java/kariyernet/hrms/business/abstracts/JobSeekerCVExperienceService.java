package kariyernet.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.JobSeekerCVExperience;
public interface JobSeekerCVExperienceService extends BaseService<JobSeekerCVExperience, Integer> {
	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId,
			Direction direction);
}


