package kariyernet.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.JobSeekerCVImage;

public interface JobSeekerCVImageService extends BaseService<JobSeekerCVImage, Integer> {
	Result addAndSave(JobSeekerCVImage jobSeekerImage, MultipartFile file);

	DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

}
