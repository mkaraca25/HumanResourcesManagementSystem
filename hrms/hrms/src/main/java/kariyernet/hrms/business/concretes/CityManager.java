package kariyernet.hrms.business.concretes;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.CityService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.CityDao;
import kariyernet.hrms.entities.concretes.City;
@Service
public class CityManager implements CityService {
	private CityDao cityDao;

	@Autowired
	public CityManager(final CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public Result add(final City city) {
		cityDao.save(city);
		return new SuccessResult(Messages.cityAdded);
	}

	@Override
	public Result delete(final City city) {
		cityDao.delete(city);
		return new SuccessResult(Messages.cityDeleted);
	}

	@Override
	public DataResult<List<City>> getAll() {
		final List<City> cities = cityDao.findAll();
		return new SuccessDataResult<List<City>>(cities);
	}

	
	@Override
	public DataResult<City> getById(final Short id) {
		final Optional<City> city = cityDao.findById(id);

		if (city.isPresent())
			return new ErrorDataResult<City>(Messages.cityNotFound);

		return new SuccessDataResult<City>(city.get());
	}

	@Override
	public DataResult<City> getByName(final String name) {
		final Optional<City> city = cityDao.findByName(name);

		if (city.isPresent())
			return new ErrorDataResult<City>(Messages.cityNotFound);

		return new SuccessDataResult<City>(city.get());
	}

	@Override
	public DataResult<List<City>> getByNameContains(final String name) {
		final Optional<List<City>> city = cityDao.findByNameContains(name);

		return new SuccessDataResult<List<City>>(city.get());
	}

	@Override
	public Result update(final City city) {
		cityDao.save(city);
		return new SuccessResult(Messages.cityUpdated);
	}

	@Override
	public DataResult<City> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<City>> getAllSorted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<City>> getAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
}