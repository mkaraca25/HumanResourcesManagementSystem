package kariyernet.hrms.business.abstracts;
import kariyernet.hrms.entities.concretes.CVLanguage;

import java.util.List;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;

public interface CVLanguageService extends BaseService<CVLanguage, Integer> {
	DataResult<List<CVLanguage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

}
