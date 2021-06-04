package kariyernet.hrms.core.utilities.help.image;

import org.springframework.web.multipart.MultipartFile;

import kariyernet.hrms.core.utilities.result.DataResult;

public interface ImageService {
	DataResult<?> save(MultipartFile file);
}
