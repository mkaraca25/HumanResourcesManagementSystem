package kariyernet.hrms.business.concretes;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import kariyernet.hrms.core.utilities.result.*;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.dataAccess.abstracts.JobSeekerCVEducationDao;
import kariyernet.hrms.entities.concretes.JobSeekerCVEducation;
import kariyernet.hrms.business.abstracts.JobSeekerCVEducationService;
@Service
public class JobSeekerCVEducationManager implements JobSeekerCVEducationService {
	private JobSeekerCVEducationDao jobSeekerCVEducationDao;

	@Autowired
	public JobSeekerCVEducationManager(final JobSeekerCVEducationDao jobSeekerCVEducationDao) {
		this.jobSeekerCVEducationDao = jobSeekerCVEducationDao;
	}

	@Override
	public Result add(final JobSeekerCVEducation jobSeekerCVEducation) {
		jobSeekerCVEducationDao.save(jobSeekerCVEducation);

		return new SuccessResult(kariyernet.hrms.business.Messages.jobSeekerCVEducationAdded);
	}

	@Override
	public Result delete(final JobSeekerCVEducation jobSeekerCVEducation) {
		jobSeekerCVEducationDao.delete(jobSeekerCVEducation);

		return new SuccessResult(kariyernet.hrms.business.Messages.jobSeekerCVEducationDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAll() {
		final List<JobSeekerCVEducation> jobSeekerCVEducations = jobSeekerCVEducationDao.findAll();

		return new SuccessDataResult<List<JobSeekerCVEducation>>(jobSeekerCVEducations);
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVEducation> jobSeekerCVEducations = jobSeekerCVEducationDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVEducation>>(jobSeekerCVEducations);
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(final int jobSeekerCVId,
			final Direction direction) {
		final List<JobSeekerCVEducation> jobSeekerCVEducations = direction.isAscending()
				? jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId)
				: jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDateDesc(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVEducation>>(jobSeekerCVEducations);
	}

	@Override
	public DataResult<JobSeekerCVEducation> getById(final Integer id) {
		final Optional<JobSeekerCVEducation> jobSeekerCVEducation = jobSeekerCVEducationDao.findById(id);

		if (jobSeekerCVEducation.isPresent())
			return new ErrorDataResult<JobSeekerCVEducation>(kariyernet.hrms.business.Messages.jobSeekerCVEducationNotFound);

		return new SuccessDataResult<JobSeekerCVEducation>(jobSeekerCVEducation.get());
	}

	@Override
	public Result update(final JobSeekerCVEducation jobSeekerCVEducation) {
		jobSeekerCVEducationDao.save(jobSeekerCVEducation);

		return new SuccessResult(kariyernet.hrms.business.Messages.jobSeekerCVEducationUpdated);
	}

}