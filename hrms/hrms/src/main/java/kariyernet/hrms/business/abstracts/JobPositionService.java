package kariyernet.hrms.business.abstracts;

import java.util.List;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.JobPosition;
public interface JobPositionService extends BaseService<JobPosition> {
	Result isNotExistsJobPosition(final String title);
}
