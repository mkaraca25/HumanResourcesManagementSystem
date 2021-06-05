package kariyernet.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.CVExperience;
public interface CVExperienceService extends BaseService<CVExperience, Integer> {
	DataResult<List<CVExperience>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<CVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId,
			Direction direction);
}


