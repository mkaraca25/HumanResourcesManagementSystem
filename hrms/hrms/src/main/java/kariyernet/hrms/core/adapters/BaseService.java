package kariyernet.hrms.core.adapters;

import java.util.List;

import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;

public interface BaseService<T> {
	Result add(T entity);

	Result delete(T entity);

	DataResult<List<T>> getAll();

	DataResult<T> getById(int id);

	Result update(T entity);
}
