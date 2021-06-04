package kariyernet.hrms.business.abstracts;



import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.JobSeekerCVEducation;
public interface JobSeekerCVEducationService  extends BaseService<JobSeekerCVEducation, Integer> {
	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId,
			Direction direction);

}
