package kariyernet.hrms.business.abstracts;


import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.CompanyStaffVerification;

public interface CompanyStaffVerificationService extends BaseService<CompanyStaffVerification, Integer>{
	DataResult<CompanyStaffVerification> getByUserId(final int userId);

	Result verify(int id);
}
