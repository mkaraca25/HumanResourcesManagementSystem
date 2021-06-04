package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.JobSeekerCVWebSiteService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.JobSeekerCVWebSiteDao;
import kariyernet.hrms.entities.concretes.JobSeekerCVWebSite;
@Service
public class JobSeekerCVWebSiteManager implements JobSeekerCVWebSiteService {
	private JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao;

	@Autowired
	public JobSeekerCVWebSiteManager(final JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao) {
		this.jobSeekerCVWebSiteDao = jobSeekerCVWebSiteDao;
	}

	@Override
	public Result add(final JobSeekerCVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.save(jobSeekerCVWebSite);

		return new SuccessResult(Messages.jobSeekerCVWebSiteAdded);
	}

	@Override
	public Result delete(final JobSeekerCVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.delete(jobSeekerCVWebSite);

		return new SuccessResult(Messages.jobSeekerCVWebSiteDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCVWebSite>> getAll() {
		final List<JobSeekerCVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao.findAll();

		return new SuccessDataResult<List<JobSeekerCVWebSite>>(jobSeekerCVWebSites);
	}

	@Override
	public DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVWebSite>>(jobSeekerCVWebSites);
	}

	@Override
	public DataResult<JobSeekerCVWebSite> getById(final Integer id) {
		final Optional<JobSeekerCVWebSite> jobSeekerCVWebSite = jobSeekerCVWebSiteDao.findById(id);

		if (jobSeekerCVWebSite.isPresent())
			return new ErrorDataResult<JobSeekerCVWebSite>(Messages.jobSeekerCVWebSiteNotFound);

		return new SuccessDataResult<JobSeekerCVWebSite>(jobSeekerCVWebSite.get());
	}

	@Override
	public Result update(final JobSeekerCVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.save(jobSeekerCVWebSite);

		return new SuccessResult(Messages.jobSeekerCVWebSiteUpdated);
	}

}
