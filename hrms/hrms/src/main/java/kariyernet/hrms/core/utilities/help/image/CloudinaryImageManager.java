package kariyernet.hrms.core.utilities.help.image;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.ErrorDataResult;
import kariyernet.hrms.core.utilities.result.SuccessDataResult;

@Service
public class CloudinaryImageManager implements ImageService {
	private Environment environment;

	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryImageManager(final Environment environment) {
		this.environment = environment;
		cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name",
				environment.getProperty("cloudinary.cloud.name"),
				"api_key",
				environment.getProperty("cloudinary.api.key"),
				"api_secret",
				environment.getProperty("cloudinary.api.secret")));
	}

	@Override
	public DataResult<?> save(final MultipartFile file) {
		Map result;
		try {
			result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		} catch (final IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<Map>(e.getMessage());
		}

		return new SuccessDataResult<Map>(result);
	}
}
