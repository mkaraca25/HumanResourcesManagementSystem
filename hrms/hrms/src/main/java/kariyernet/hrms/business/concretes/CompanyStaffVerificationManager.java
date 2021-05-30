package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.CompanyStaffVerificationService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.ErrorResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.CompanyStaffVerificationDao;
import kariyernet.hrms.entities.concretes.CompanyStaffVerification;

@Service
public class CompanyStaffVerificationManager implements CompanyStaffVerificationService {
	private final CompanyStaffVerificationDao companyStaffVerificationDao;

	@Autowired
	public CompanyStaffVerificationManager(final CompanyStaffVerificationDao companyStaffVerificationDao) {
		this.companyStaffVerificationDao = companyStaffVerificationDao;
	}

	@Override
	public Result add(final CompanyStaffVerification companyStaffVerification) {
		companyStaffVerificationDao.save(companyStaffVerification);

		return new SuccessResult(Messages.companyStaffVerificationAdded);
	}

	@Override
	public Result delete(final CompanyStaffVerification companyStaffVerification) {
		companyStaffVerificationDao.delete(companyStaffVerification);

		return new SuccessResult(Messages.companyStaffVerificationDeleted);
	}

	@Override
	public DataResult<List<CompanyStaffVerification>> getAll() {
		final List<CompanyStaffVerification> companyStaffVerifications = companyStaffVerificationDao.findAll();

		return new SuccessDataResult<List<CompanyStaffVerification>>(companyStaffVerifications);
	}

	@Override
	public DataResult<CompanyStaffVerification> getById(final int id) {
		final Optional<CompanyStaffVerification> companyStaffVerification = companyStaffVerificationDao.findById(id);

		if (companyStaffVerification.isPresent())
			return new ErrorDataResult<CompanyStaffVerification>(Messages.companyStaffVerificationNotFound);

		return new SuccessDataResult<CompanyStaffVerification>(companyStaffVerification.get());
	}

	@Override
	public DataResult<CompanyStaffVerification> getByUserId(final int userId) {
		final Optional<CompanyStaffVerification> companyStaffVerification = companyStaffVerificationDao
				.findByUser_Id(userId);

		if (companyStaffVerification.isPresent())
			return new ErrorDataResult<CompanyStaffVerification>(Messages.companyStaffVerificationNotFound);

		return new SuccessDataResult<CompanyStaffVerification>(companyStaffVerification.get());
	}

	@Override
	public Result update(final CompanyStaffVerification companyStaffVerification) {
		companyStaffVerificationDao.save(companyStaffVerification);

		return new SuccessResult(Messages.companyStaffVerificationUpdated);
	}

	@Override
	public Result verify(final int userId) {
		final DataResult<CompanyStaffVerification> companyStaffVerification = getByUserId(userId);

		if (!companyStaffVerification.isSuccess())
			return new ErrorResult(Messages.companyStaffVerificationNotFound);

		companyStaffVerification.getData().setApproved(true);
		companyStaffVerificationDao.save(companyStaffVerification.getData());

		return new SuccessResult(Messages.companyStaffVerificationVerified);
	}

}