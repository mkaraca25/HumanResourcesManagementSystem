package kariyernet.hrms.business.abstracts;



import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.CVEducation;
public interface CVEducationService  extends BaseService<CVEducation, Integer> {
	DataResult<List<CVEducation>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<CVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId,
			Direction direction);

}
