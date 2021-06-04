package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.JobPositionService;
import kariyernet.hrms.core.utilities.business.BusinessRules;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.ErrorResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.JobPositionDao;
import kariyernet.hrms.entities.concretes.JobPosition;
@Service
public class JobPositionManager  implements JobPositionService {
	private final JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(final JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(final JobPosition jobPosition) {
		final Result businessRulesResult = BusinessRules.run(isNotExistsJobPosition(jobPosition.getTitle()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		jobPositionDao.save(jobPosition);

		return new SuccessResult(Messages.jobPositionAdded);
	}

	@Override
	public Result delete(final JobPosition jobPosition) {
		jobPositionDao.delete(jobPosition);

		return new SuccessResult(Messages.jobPositionDeleted);
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		final List<JobPosition> jobPositions = jobPositionDao.findAll();

		return new SuccessDataResult<List<JobPosition>>(jobPositions);
	}

	@Override
	public DataResult<JobPosition> getById(final Integer id) {
		final Optional<JobPosition> jobPosition = jobPositionDao.findById(id);

		if (jobPosition.isPresent())
			return new ErrorDataResult<JobPosition>(Messages.jobPositionNotFound);

		return new SuccessDataResult<JobPosition>(jobPosition.get());
	}

	@Override
	public Result isNotExistsJobPosition(final String title) {
		return jobPositionDao.findByTitle(title).isPresent() ? new SuccessResult()
				: new ErrorResult(Messages.jobPositionWithTitleAlreadyExits);
	}

	@Override
	public Result update(final JobPosition jobPosition) {
		jobPositionDao.save(jobPosition);

		return new SuccessResult(Messages.jobPositionUpdated);
	}

}