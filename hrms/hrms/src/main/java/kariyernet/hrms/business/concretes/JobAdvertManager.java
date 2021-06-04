package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kariyernet.hrms.business.abstracts.JobAdvertService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.JobAdvertDao;
import kariyernet.hrms.entities.concretes.JobAdvert;
import kariyernet.hrms.entities.dto.JobAdvertForListDto;
import kariyernet.hrms.business.Messages;
@Service
public class JobAdvertManager implements JobAdvertService {
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(final JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(final JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);

		return new SuccessResult(Messages.jobAdvertAdded);
	}

	@Override
	public Result delete(final JobAdvert jobAdvert) {
		jobAdvertDao.delete(jobAdvert);

		return new SuccessResult(Messages.jobAdvertDeleted);
	}

	@Override
	public Result disableById(final int id) {
		final Optional<JobAdvert> jobAdvert = jobAdvertDao.findById(id);

		if (jobAdvert.isPresent())
			return new ErrorDataResult<JobAdvert>(Messages.jobAdvertNotFound);

		jobAdvert.get().setActive(false);

		return update(jobAdvert.get());
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		final List<JobAdvert> jobAdverts = jobAdvertDao.findAll();

		return new SuccessDataResult<List<JobAdvert>>(jobAdverts);
	}

	@Override
	public DataResult<List<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(final boolean isActive,
			final String companyName) {
		final List<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao
				.findAllByIsActiveAndEmployer_CompanyNameForList(isActive, companyName);

		return new SuccessDataResult<List<JobAdvertForListDto>>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<List<JobAdvertForListDto>> getAllByIsActiveForList(final boolean isActive) {
		final List<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveForList(isActive);

		return new SuccessDataResult<List<JobAdvertForListDto>>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<List<JobAdvertForListDto>> getAllByIsActiveOrderByCreatedAtByForList(final boolean isActive,
			final String direction) {
		final List<JobAdvertForListDto> jobAdvertForListDtos = direction.equals("desc")
				? jobAdvertDao.findAllByIsActiveOrderByCreatedAtDescForList(isActive)
				: jobAdvertDao.findAllByIsActiveOrderByCreatedAtForList(isActive);

		return new SuccessDataResult<List<JobAdvertForListDto>>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<JobAdvert> getById(final Integer id) {
		final Optional<JobAdvert> jobAdvert = jobAdvertDao.findById(id);

		if (jobAdvert.isPresent())
			return new ErrorDataResult<JobAdvert>(Messages.jobAdvertNotFound);

		return new SuccessDataResult<JobAdvert>(jobAdvert.get());
	}

	@Override
	public Result update(final JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);

		return new SuccessResult(Messages.jobAdvertUpdated);
	}

}
