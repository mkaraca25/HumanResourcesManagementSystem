package kariyernet.hrms.business.abstracts;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.EmailActivation;
import kariyernet.hrms.entities.concretes.User;
import kariyernet.hrms.entities.dto.EmailActivationForVerifyDto;

public interface EmailActivationService extends BaseService<EmailActivation,Integer>{
	Result createAndSendActivationCodeByMail(User user, String... emails);

	Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto);
}
