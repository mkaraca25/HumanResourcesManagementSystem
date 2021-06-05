package kariyernet.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kariyernet.hrms.business.abstracts.CVExperienceService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.CVExperience;

@RestController
@RequestMapping("/hrms/api/jobseekers/cvs/experiences")
public class CVExperiencesController {
	private CVExperienceService CVExperienceService;

	@Autowired
	public CVExperiencesController(final CVExperienceService CVExperienceService) {
		this.CVExperienceService = CVExperienceService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final CVExperience jobSeekerCVExperience) {
		final Result result =CVExperienceService.add(jobSeekerCVExperience);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final CVExperience CVExperience) {
		final Result result = CVExperienceService.delete(CVExperience);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CVExperience>>> getAll() {
		final DataResult<List<CVExperience>> result = CVExperienceService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvid")
	public ResponseEntity<DataResult<List<CVExperience>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<CVExperience>> result = CVExperienceService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvidorderbyquitdate")
	public ResponseEntity<DataResult<List<CVExperience>>> getAllByJobSeekerCV_IdOrderByQuitDate(
			@RequestParam final int jobSeekerCVId, @RequestParam final Direction direction) {
		final DataResult<List<CVExperience>> result = CVExperienceService
				.getAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId, direction);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final CVExperience CVExperience) {
		final Result result = CVExperienceService.update(CVExperience);

		return ResponseEntity.ok(result);
	}

}
