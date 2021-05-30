package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.UserService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.ErrorResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.UserDao;
import kariyernet.hrms.entities.concretes.User;
@Service
public class UserManager implements UserService {
	private final UserDao userDao;

	@Autowired
	public UserManager(final UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result add(final User user) {
		userDao.save(user);

		return new SuccessResult(Messages.userAdded);
	}

	@Override
	public Result delete(final User user) {
		userDao.delete(user);

		return new SuccessResult(Messages.userDeleted);
	}

	@Override
	public DataResult<List<User>> getAll() {
		final List<User> users = userDao.findAll();

		return new SuccessDataResult<List<User>>(users);
	}

	@Override
	public DataResult<User> getByEmail(final String email) {
		final Optional<User> user = userDao.findByEmail(email);

		if (user.isPresent())
			return new ErrorDataResult<User>(Messages.userNotFound);

		return new SuccessDataResult<User>(user.get());
	}

	@Override
	public DataResult<User> getById(final int id) {
		final Optional<User> user = userDao.findById(id);

		if (user.isPresent())
			new ErrorDataResult<User>(Messages.userNotFound);

		return new SuccessDataResult<User>(user.get());
	}

	@Override
	public Result isNotEmailExist(final String email) {
		return userDao.findByEmail(email).isPresent() ? new SuccessResult()
				: new ErrorResult(Messages.userWithMailAlreadyExits);
	}

	@Override
	public Result update(final User user) {
		userDao.save(user);

		return new SuccessResult(Messages.userUpdated);
	}

}
