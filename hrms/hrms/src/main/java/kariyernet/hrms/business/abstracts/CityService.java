package kariyernet.hrms.business.abstracts;

import java.util.List;

import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.City;

public interface CityService extends BaseService<City, Integer> {
	 DataResult<List<City>> getAll();
	 DataResult<List<City>> getAllSorted();
	 DataResult<List<City>> getAll(int pageNo, int pageSize);
	DataResult<City> getByName(String name);
	DataResult<List<City>> getByNameContains(String name);
	DataResult<City> getById(Short id);
}
