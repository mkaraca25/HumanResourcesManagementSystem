package kariyernet.hrms.business.concretes;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kariyernet.hrms.business.Messages;
import kariyernet.hrms.business.abstracts.CVImageService;
import kariyernet.hrms.core.utilities.help.image.ImageService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;
import kariyernet.hrms.core.utilities.result.SuccessResult;
import kariyernet.hrms.dataAccess.abstracts.CVImageDao;
import kariyernet.hrms.entities.concretes.CVImage;

@Service
public class CVImageManager implements CVImageService {
	private CVImageDao CVImageDao;
	private ImageService imageService;

	@Autowired
	public CVImageManager(final CVImageDao CVImageDao, final ImageService imageService) {
		this.CVImageDao = CVImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(final CVImage CVImage) {
		CVImageDao.save(CVImage);

		return new SuccessResult(Messages.CVImageAdded);
	}

	@Override
	public Result addAndSave(final CVImage CVImage, final MultipartFile file) {
		final Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		CVImage.setUrl(result.get("url"));

		return add(CVImage);
	}

	@Override
	public Result delete(final CVImage CVImage) {
		CVImageDao.delete(CVImage);

		return new SuccessResult(Messages.CVImageDeleted);
	}

	@Override
	public DataResult<List<CVImage>> getAll() {
		final List<CVImage> jobSeekerCVImages = CVImageDao.findAll();

		return new SuccessDataResult<List<CVImage>>(jobSeekerCVImages);
	}

	@Override
	public DataResult<List<CVImage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<CVImage> jobSeekerCVImages = CVImageDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<CVImage>>(jobSeekerCVImages);
	}

	@Override
	public DataResult<CVImage> getById(final Integer id) {
		final Optional<CVImage> jobSeekerCVImage = CVImageDao.findById(id);

		if (jobSeekerCVImage.isPresent())
			new ErrorDataResult<CVImage>(Messages.CVImageNotFound);

		return new SuccessDataResult<CVImage>(jobSeekerCVImage.get());
	}

	@Override
	public Result update(final CVImage jobSeekerCVImage) {
		CVImageDao.save(jobSeekerCVImage);

		return new SuccessResult(Messages.CVImageUpdated);
	}

}
