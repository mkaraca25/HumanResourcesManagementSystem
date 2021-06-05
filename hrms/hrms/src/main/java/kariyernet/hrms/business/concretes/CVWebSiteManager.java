package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.CVWebSiteService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.CVWebSiteDao;
import kariyernet.hrms.entities.concretes.CVWebSite;
@Service
public class CVWebSiteManager implements CVWebSiteService {
	private CVWebSiteDao jobSeekerCVWebSiteDao;

	@Autowired
	public CVWebSiteManager(final CVWebSiteDao jobSeekerCVWebSiteDao) {
		this.jobSeekerCVWebSiteDao = jobSeekerCVWebSiteDao;
	}

	@Override
	public Result add(final CVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.save(jobSeekerCVWebSite);

		return new SuccessResult(Messages.CVWebSiteAdded);
	}

	@Override
	public Result delete(final CVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.delete(jobSeekerCVWebSite);

		return new SuccessResult(Messages.CVWebSiteDeleted);
	}

	@Override
	public DataResult<List<CVWebSite>> getAll() {
		final List<CVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao.findAll();

		return new SuccessDataResult<List<CVWebSite>>(jobSeekerCVWebSites);
	}

	@Override
	public DataResult<List<CVWebSite>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<CVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<CVWebSite>>(jobSeekerCVWebSites);
	}

	@Override
	public DataResult<CVWebSite> getById(final Integer id) {
		final Optional<CVWebSite> jobSeekerCVWebSite = jobSeekerCVWebSiteDao.findById(id);

		if (jobSeekerCVWebSite.isPresent())
			return new ErrorDataResult<CVWebSite>(Messages.CVWebSiteNotFound);

		return new SuccessDataResult<CVWebSite>(jobSeekerCVWebSite.get());
	}

	@Override
	public Result update(final CVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.save(jobSeekerCVWebSite);

		return new SuccessResult(Messages.CVWebSiteUpdated);
	}

}
