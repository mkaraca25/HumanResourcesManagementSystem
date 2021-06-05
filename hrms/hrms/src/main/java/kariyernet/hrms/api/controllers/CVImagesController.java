package kariyernet.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kariyernet.hrms.business.abstracts.CVImageService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.JobSeekerCV;
import kariyernet.hrms.entities.concretes.CVImage;

@RestController
@RequestMapping("/hrms/api/jobseekers/cvs/images")
public class CVImagesController {
	private CVImageService CVImageService;

	@Autowired
	public CVImagesController(final CVImageService CVImageService) {
		this.CVImageService = CVImageService;
	}

	@PostMapping("/addandsave")
	public ResponseEntity<Result> addAndSave(@RequestParam final int jobSeekerCVId,
			@RequestBody final MultipartFile file) {
		final Result result = CVImageService.addAndSave(
				CVImage.builder().jobSeekerCV(JobSeekerCV.builder().id(jobSeekerCVId).build()).build(),
				file);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final CVImage CVImage) {
		final Result result = CVImageService.delete(CVImage);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CVImage>>> getAll() {
		final DataResult<List<CVImage>> result = CVImageService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvid")
	public ResponseEntity<DataResult<List<CVImage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<CVImage>> result = CVImageService.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}
}
