package kariyernet.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import kariyernet.hrms.core.adapters.BaseService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.CVImage;

public interface CVImageService extends BaseService<CVImage, Integer> {
	Result addAndSave(CVImage jobSeekerImage, MultipartFile file);

	DataResult<List<CVImage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

}
