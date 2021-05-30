package kariyernet.hrms.business.abstracts;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.User;

public interface UserService extends BaseService<User> {
	DataResult<User> getByEmail(String email);

	Result isNotEmailExist(final String email);
}
