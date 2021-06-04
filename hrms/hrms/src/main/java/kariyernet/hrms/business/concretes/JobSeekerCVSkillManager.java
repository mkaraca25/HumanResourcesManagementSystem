package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.JobSeekerCVSkillService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.JobSeekerCVSkillDao;
import kariyernet.hrms.entities.concretes.JobSeekerCVSkill;
@Service
public class JobSeekerCVSkillManager implements JobSeekerCVSkillService {
	private JobSeekerCVSkillDao jobSeekerCVSkillDao;

	@Autowired
	public JobSeekerCVSkillManager(final JobSeekerCVSkillDao jobSeekerCVSkillDao) {
		this.jobSeekerCVSkillDao = jobSeekerCVSkillDao;
	}

	@Override
	public Result add(final JobSeekerCVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.save(jobSeekerCVSkill);

		return new SuccessResult(Messages.jobSeekerCVSkillAdded);
	}

	@Override
	public Result delete(final JobSeekerCVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.delete(jobSeekerCVSkill);

		return new SuccessResult(Messages.jobSeekerCVSkillDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCVSkill>> getAll() {
		final List<JobSeekerCVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAll();

		return new SuccessDataResult<List<JobSeekerCVSkill>>(jobSeekerCVSkills);
	}

	@Override
	public DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVSkill>>(jobSeekerCVSkills);
	}

	@Override
	public DataResult<JobSeekerCVSkill> getById(final Integer id) {
		final Optional<JobSeekerCVSkill> jobSeekerCVSkill = jobSeekerCVSkillDao.findById(id);

		if (jobSeekerCVSkill.isPresent())
			return new ErrorDataResult<JobSeekerCVSkill>(Messages.jobSeekerCVSkillNotFound);

		return new SuccessDataResult<JobSeekerCVSkill>(jobSeekerCVSkill.get());
	}

	@Override
	public Result update(final JobSeekerCVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.save(jobSeekerCVSkill);

		return new SuccessResult(Messages.jobSeekerCVSkillUpdated);
	}

}
