package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.CVLanguageService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.CVLanguageDao;
import kariyernet.hrms.entities.concretes.CVLanguage;
@Service
public class CVLanguageManager  implements CVLanguageService {
	private CVLanguageDao jobSeekerCVLanguageDao;

	@Autowired
	public CVLanguageManager(final CVLanguageDao jobSeekerCVLanguageDao) {
		this.jobSeekerCVLanguageDao = jobSeekerCVLanguageDao;
	}

	@Override
	public Result add(final CVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.save(jobSeekerCVLanguage);

		return new SuccessResult(Messages.CVLanguageAdded);
	}

	@Override
	public Result delete(final CVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.delete(jobSeekerCVLanguage);

		return new SuccessResult(Messages.CVLanguageDeleted);
	}

	@Override
	public DataResult<List<CVLanguage>> getAll() {
		final List<CVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao.findAll();

		return new SuccessDataResult<List<CVLanguage>>(jobSeekerCVLanguages);
	}

	@Override
	public DataResult<List<CVLanguage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<CVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<CVLanguage>>(jobSeekerCVLanguages);
	}

	@Override
	public DataResult<CVLanguage> getById(final Integer id) {
		final Optional<CVLanguage> jobSeekerCVLanguage = jobSeekerCVLanguageDao.findById(id);

		if (jobSeekerCVLanguage.isPresent())
			return new ErrorDataResult<CVLanguage>(Messages.CVLanguageNotFound);

		return new SuccessDataResult<CVLanguage>(jobSeekerCVLanguage.get());
	}

	@Override
	public Result update(final CVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.save(jobSeekerCVLanguage);

		return new SuccessResult(Messages.CVLanguageUpdated);
	}


}
