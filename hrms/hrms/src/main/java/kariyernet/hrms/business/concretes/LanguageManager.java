package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.LanguageService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.LanguageDao;
import kariyernet.hrms.entities.concretes.Language;
@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(final LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(final Language language) {
		languageDao.save(language);

		return new SuccessResult(Messages.languageAdded);
	}

	@Override
	public Result delete(final Language language) {
		languageDao.delete(language);

		return new SuccessResult(Messages.languageDeleted);
	}

	@Override
	public DataResult<List<Language>> getAll() {
		final List<Language> language = languageDao.findAll();

		return new SuccessDataResult<List<Language>>(language);
	}

	@Override
	public DataResult<Language> getById(final String id) {
		final Optional<Language> language = languageDao.findById(id);

		if (language.isPresent())
			return new ErrorDataResult<Language>(Messages.languageNotFound);

		return new SuccessDataResult<Language>(language.get());
	}

	@Override
	public Result update(final Language language) {
		languageDao.save(language);

		return new SuccessResult(Messages.languageUpdated);
	}

}
