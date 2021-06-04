package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.WebSiteService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.WebSiteDao;
import kariyernet.hrms.entities.concretes.WebSite;
@Service
public class WebSiteManager implements WebSiteService {
	private WebSiteDao webSiteDao;

	@Autowired
	public WebSiteManager(final WebSiteDao webSiteDao) {
		this.webSiteDao = webSiteDao;
	}

	@Override
	public Result add(final WebSite webSite) {
		webSiteDao.save(webSite);

		return new SuccessResult(Messages.webSiteAdded);
	}

	@Override
	public Result delete(final WebSite webSite) {
		webSiteDao.delete(webSite);

		return new SuccessResult(Messages.webSiteDeleted);
	}

	@Override
	public DataResult<List<WebSite>> getAll() {
		final List<WebSite> webSites = webSiteDao.findAll();

		return new SuccessDataResult<List<WebSite>>(webSites);
	}

	@Override
	public DataResult<WebSite> getById(final Short id) {
		final Optional<WebSite> webSite = webSiteDao.findById(id);

		if (webSite.isPresent())
			return new ErrorDataResult<WebSite>(Messages.webSiteNotFound);

		return new SuccessDataResult<WebSite>(webSite.get());
	}

	@Override
	public DataResult<WebSite> getByName(final String name) {
		final Optional<WebSite> webSite = webSiteDao.findByName(name);

		if (webSite.isPresent())
			return new ErrorDataResult<WebSite>(Messages.webSiteNotFound);

		return new SuccessDataResult<WebSite>(webSite.get());
	}

	@Override
	public Result update(final WebSite webSite) {
		webSiteDao.save(webSite);

		return new SuccessResult(Messages.webSiteUpdated);
	}

}
