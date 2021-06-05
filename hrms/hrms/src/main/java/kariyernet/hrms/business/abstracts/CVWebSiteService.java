package kariyernet.hrms.business.abstracts;

import java.util.List;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.CVWebSite;

public interface CVWebSiteService extends BaseService<CVWebSite, Integer> {
	DataResult<List<CVWebSite>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

}
