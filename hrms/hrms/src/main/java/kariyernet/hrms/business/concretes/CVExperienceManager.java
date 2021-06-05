package kariyernet.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kariyernet.hrms.core.utilities.result.*;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.CVExperienceService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.dataAccess.abstracts.CVExperienceDao;
import kariyernet.hrms.entities.concretes.CVExperience;
import java.util.*;
@Service
public class CVExperienceManager implements CVExperienceService {
	private CVExperienceDao CVExperienceDao;

	@Autowired
	public CVExperienceManager(final CVExperienceDao CVExperienceDao) {
		this.CVExperienceDao = CVExperienceDao;
	}

	@Override
	public Result add(final CVExperience CVExperience) {
		CVExperienceDao.save(CVExperience);

		return new SuccessResult(Messages.CVExperienceAdded);
	}

	@Override
	public Result delete(final CVExperience CVExperience) {
		CVExperienceDao.delete(CVExperience);

		return new SuccessResult(Messages.CVExperienceDeleted);
	}

	@Override
	public DataResult<List<CVExperience>> getAll() {
		final List<CVExperience> CVExperiences = CVExperienceDao.findAll();

		return new SuccessDataResult<List<CVExperience>>(CVExperiences);
	}

	@Override
	public DataResult<List<CVExperience>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<CVExperience> CVExperiences = CVExperienceDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<CVExperience>>(CVExperiences);
	}

	@Override
	public DataResult<List<CVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(final int jobSeekerCVId,
			final Direction direction) {
		final List<CVExperience> Educations = direction.isAscending()
				? CVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId)
				: CVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDateDesc(jobSeekerCVId);

		return new SuccessDataResult<List<CVExperience>>(Educations);
	}

	@Override
	public DataResult<CVExperience> getById(final Integer id) {
		final Optional<CVExperience> CVExperience = CVExperienceDao.findById(id);

		if (CVExperience.isPresent())
			return new ErrorDataResult<CVExperience>(Messages.CVExperienceNotFound);

		return new SuccessDataResult<CVExperience>(CVExperience.get());
	}

	@Override
	public Result update(final CVExperience CVExperience) {
		CVExperienceDao.save(CVExperience);

		return new SuccessResult(Messages.CVExperienceUpdated);
	}

}
