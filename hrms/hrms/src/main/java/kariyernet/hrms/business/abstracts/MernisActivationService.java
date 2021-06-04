package kariyernet.hrms.business.abstracts;

import kariyernet.hrms.business.adapters.PersonForValidateFromMernisService;
import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.MernisActivation;


public interface MernisActivationService extends BaseService<MernisActivation, Integer> {
	Result check(PersonForValidateFromMernisService personForValidateFromMernisService);
}
