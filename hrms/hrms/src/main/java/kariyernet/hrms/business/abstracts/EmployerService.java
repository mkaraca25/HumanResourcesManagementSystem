package kariyernet.hrms.business.abstracts;


import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.Employer;
import kariyernet.hrms.entities.dto.EmployerForRegisterDto;

public interface EmployerService extends BaseService<Employer, Integer> {
	Result isNotCorporateEmailExist(final String corporateEmail);

	Result register(EmployerForRegisterDto employerForRegister);
}
