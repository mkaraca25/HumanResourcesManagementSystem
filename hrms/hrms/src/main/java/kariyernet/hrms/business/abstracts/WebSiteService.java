package kariyernet.hrms.business.abstracts;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.WebSite;

public interface WebSiteService extends BaseService<WebSite, Short> {
	DataResult<WebSite> getByName(String name);

}
