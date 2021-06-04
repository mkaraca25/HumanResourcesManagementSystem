package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.JobSeekerCVService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.JobSeekerCVDao;
import kariyernet.hrms.entities.concretes.JobSeekerCV;
@Service
public class JobSeekerCVManager implements JobSeekerCVService {
	private JobSeekerCVDao jobSeekerCVDao;

	@Autowired
	public JobSeekerCVManager(final JobSeekerCVDao jobSeekerCVDao) {
		this.jobSeekerCVDao = jobSeekerCVDao;
	}

	@Override
	public Result add(final JobSeekerCV jobSeekerCV) {
		jobSeekerCVDao.save(jobSeekerCV);

		return new SuccessResult(Messages.jobSeekerCVAdded);
	}

	@Override
	public Result delete(final JobSeekerCV jobSeekerCV) {
		jobSeekerCVDao.delete(jobSeekerCV);

		return new SuccessResult(Messages.jobSeekerCVDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCV>> getAll() {
		final List<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findAll();

		return new SuccessDataResult<List<JobSeekerCV>>(jobSeekerCV);
	}

	@Override
	public DataResult<JobSeekerCV> getById(final Integer id) {
		final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findById(id);

		if (jobSeekerCV.isPresent())
			return new ErrorDataResult<JobSeekerCV>(Messages.jobSeekerCVNotFound);

		return new SuccessDataResult<JobSeekerCV>(jobSeekerCV.get());
	}

	@Override
	public DataResult<JobSeekerCV> getByJobSeeker_Id(final int jobSeekerId) {
		final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findByJobSeeker_Id(jobSeekerId);

		if (jobSeekerCV.isPresent())
			return new ErrorDataResult<JobSeekerCV>(Messages.jobSeekerCVNotFound);

		return new SuccessDataResult<JobSeekerCV>(jobSeekerCV.get());
	}

	@Override
	public Result update(final JobSeekerCV jobSeekerCV) {
		jobSeekerCVDao.save(jobSeekerCV);

		return new SuccessResult(Messages.jobSeekerCVUpdated);
	}


}
