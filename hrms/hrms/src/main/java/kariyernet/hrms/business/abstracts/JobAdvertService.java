package kariyernet.hrms.business.abstracts;

import java.util.List;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.JobAdvert;
import kariyernet.hrms.entities.dto.JobAdvertForListDto;

public interface JobAdvertService  extends BaseService<JobAdvert, Integer> {
	Result disableById(int id);

	DataResult<List<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
			String companyName);

	DataResult<List<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive);

	DataResult<List<JobAdvertForListDto>> getAllByIsActiveOrderByCreatedAtByForList(boolean isActive, String sort);
}
