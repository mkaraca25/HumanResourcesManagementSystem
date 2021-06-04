package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.JobSeekerCVImageService;
import kariyernet.hrms.core.utilities.help.image.ImageService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.JobSeekerCVImageDao;
import kariyernet.hrms.entities.concretes.JobSeekerCVImage;

@Service
public class JobSeekerCVImageManager implements JobSeekerCVImageService {
	private JobSeekerCVImageDao jobSeekerCVImageDao;
	private ImageService imageService;

	@Autowired
	public JobSeekerCVImageManager(final JobSeekerCVImageDao jobSeekerCVImageDao, final ImageService imageService) {
		this.jobSeekerCVImageDao = jobSeekerCVImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(final JobSeekerCVImage jobSeekerCVImage) {
		jobSeekerCVImageDao.save(jobSeekerCVImage);

		return new SuccessResult(Messages.jobSeekerCVImageAdded);
	}

	@Override
	public Result addAndSave(final JobSeekerCVImage jobSeekerCVImage, final MultipartFile file) {
		final Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		jobSeekerCVImage.setUrl(result.get("url"));

		return add(jobSeekerCVImage);
	}

	@Override
	public Result delete(final JobSeekerCVImage jobSeekerCVImage) {
		jobSeekerCVImageDao.delete(jobSeekerCVImage);

		return new SuccessResult(Messages.jobSeekerCVImageDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCVImage>> getAll() {
		final List<JobSeekerCVImage> jobSeekerCVImages = jobSeekerCVImageDao.findAll();

		return new SuccessDataResult<List<JobSeekerCVImage>>(jobSeekerCVImages);
	}

	@Override
	public DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVImage> jobSeekerCVImages = jobSeekerCVImageDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVImage>>(jobSeekerCVImages);
	}

	@Override
	public DataResult<JobSeekerCVImage> getById(final Integer id) {
		final Optional<JobSeekerCVImage> jobSeekerCVImage = jobSeekerCVImageDao.findById(id);

		if (jobSeekerCVImage.isPresent())
			new ErrorDataResult<JobSeekerCVImage>(Messages.jobSeekerCVImageNotFound);

		return new SuccessDataResult<JobSeekerCVImage>(jobSeekerCVImage.get());
	}

	@Override
	public Result update(final JobSeekerCVImage jobSeekerCVImage) {
		jobSeekerCVImageDao.save(jobSeekerCVImage);

		return new SuccessResult(Messages.jobSeekerCVImageUpdated);
	}

}
