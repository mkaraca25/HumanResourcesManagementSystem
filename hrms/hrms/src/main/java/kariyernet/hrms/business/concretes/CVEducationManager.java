package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kariyernet.hrms.business.abstracts.CVEducationService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.CVEducationDao;
import kariyernet.hrms.entities.concretes.CVEducation;
@Service
public class CVEducationManager implements CVEducationService {
	private CVEducationDao CVEducationDao;

	@Autowired
	public CVEducationManager(final CVEducationDao CVEducationDao) {
		this.CVEducationDao = CVEducationDao;
	}

	@Override
	public Result add(final CVEducation CVEducation) {
		CVEducationDao.save(CVEducation);

		return new SuccessResult(kariyernet.hrms.business.Messages.CVEducationAdded);
	}

	@Override
	public Result delete(final CVEducation CVEducation) {
		CVEducationDao.delete(CVEducation);

		return new SuccessResult(kariyernet.hrms.business.Messages.CVEducationDeleted);
	}

	@Override
	public DataResult<List<CVEducation>> getAll() {
		final List<CVEducation> CVEducations = CVEducationDao.findAll();

		return new SuccessDataResult<List<CVEducation>>(CVEducations);
	}

	@Override
	public DataResult<List<CVEducation>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<CVEducation> CVEducations = CVEducationDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<CVEducation>>(CVEducations);
	}

	@Override
	public DataResult<List<CVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(final int jobSeekerCVId,
			final Direction direction) {
		final List<CVEducation> CVEducations = direction.isAscending()
				? CVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId)
				: CVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDateDesc(jobSeekerCVId);

		return new SuccessDataResult<List<CVEducation>>(CVEducations);
	}

	@Override
	public DataResult<CVEducation> getById(final Integer id) {
		final Optional<CVEducation> CVEducation = CVEducationDao.findById(id);

		if (CVEducation.isPresent())
			return new ErrorDataResult<CVEducation>(kariyernet.hrms.business.Messages.CVEducationNotFound);

		return new SuccessDataResult<CVEducation>(CVEducation.get());
	}

	@Override
	public Result update(final CVEducation CVEducation) {
		CVEducationDao.save(CVEducation);

		return new SuccessResult(kariyernet.hrms.business.Messages.CVEducationUpdated);
	}

}
