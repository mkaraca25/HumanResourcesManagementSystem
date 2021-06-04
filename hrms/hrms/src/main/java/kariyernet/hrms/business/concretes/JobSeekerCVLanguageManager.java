package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.JobSeekerCVLanguageService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.JobSeekerCVLanguageDao;
import kariyernet.hrms.entities.concretes.JobSeekerCVLanguage;
@Service
public class JobSeekerCVLanguageManager  implements JobSeekerCVLanguageService {
	private JobSeekerCVLanguageDao jobSeekerCVLanguageDao;

	@Autowired
	public JobSeekerCVLanguageManager(final JobSeekerCVLanguageDao jobSeekerCVLanguageDao) {
		this.jobSeekerCVLanguageDao = jobSeekerCVLanguageDao;
	}

	@Override
	public Result add(final JobSeekerCVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.save(jobSeekerCVLanguage);

		return new SuccessResult(Messages.jobSeekerCVLanguageAdded);
	}

	@Override
	public Result delete(final JobSeekerCVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.delete(jobSeekerCVLanguage);

		return new SuccessResult(Messages.jobSeekerCVLanguageDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAll() {
		final List<JobSeekerCVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao.findAll();

		return new SuccessDataResult<List<JobSeekerCVLanguage>>(jobSeekerCVLanguages);
	}

	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVLanguage>>(jobSeekerCVLanguages);
	}

	@Override
	public DataResult<JobSeekerCVLanguage> getById(final Integer id) {
		final Optional<JobSeekerCVLanguage> jobSeekerCVLanguage = jobSeekerCVLanguageDao.findById(id);

		if (jobSeekerCVLanguage.isPresent())
			return new ErrorDataResult<JobSeekerCVLanguage>(Messages.jobSeekerCVLanguageNotFound);

		return new SuccessDataResult<JobSeekerCVLanguage>(jobSeekerCVLanguage.get());
	}

	@Override
	public Result update(final JobSeekerCVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.save(jobSeekerCVLanguage);

		return new SuccessResult(Messages.jobSeekerCVLanguageUpdated);
	}


}
