package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.CVSkillService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.CVSkillDao;
import kariyernet.hrms.entities.concretes.CVSkill;
@Service
public class CVSkillManager implements CVSkillService {
	private CVSkillDao jobSeekerCVSkillDao;

	@Autowired
	public CVSkillManager(final CVSkillDao jobSeekerCVSkillDao) {
		this.jobSeekerCVSkillDao = jobSeekerCVSkillDao;
	}

	@Override
	public Result add(final CVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.save(jobSeekerCVSkill);

		return new SuccessResult(Messages.CVSkillAdded);
	}

	@Override
	public Result delete(final CVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.delete(jobSeekerCVSkill);

		return new SuccessResult(Messages.CVSkillDeleted);
	}

	@Override
	public DataResult<List<CVSkill>> getAll() {
		final List<CVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAll();

		return new SuccessDataResult<List<CVSkill>>(jobSeekerCVSkills);
	}

	@Override
	public DataResult<List<CVSkill>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<CVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<CVSkill>>(jobSeekerCVSkills);
	}

	@Override
	public DataResult<CVSkill> getById(final Integer id) {
		final Optional<CVSkill> jobSeekerCVSkill = jobSeekerCVSkillDao.findById(id);

		if (jobSeekerCVSkill.isPresent())
			return new ErrorDataResult<CVSkill>(Messages.CVSkillNotFound);

		return new SuccessDataResult<CVSkill>(jobSeekerCVSkill.get());
	}

	@Override
	public Result update(final CVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.save(jobSeekerCVSkill);

		return new SuccessResult(Messages.CVSkillUpdated);
	}

}
