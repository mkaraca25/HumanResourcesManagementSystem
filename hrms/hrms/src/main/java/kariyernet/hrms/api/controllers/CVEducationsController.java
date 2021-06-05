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

import kariyernet.hrms.business.abstracts.CVEducationService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.CVEducation;

@RestController
@RequestMapping("/hrms/api/jobseekers/cvs/educations")
public class CVEducationsController {
	private CVEducationService CVEducationService;

	@Autowired
	public CVEducationsController(final CVEducationService jobSeekerCVEducationService) {
		this.CVEducationService = jobSeekerCVEducationService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final CVEducation CVEducation) {
		final Result result = CVEducationService.add(CVEducation);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final CVEducation CVEducation) {
		final Result result = CVEducationService.delete(CVEducation);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CVEducation>>> getAll() {
		final DataResult<List<CVEducation>> result = CVEducationService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvid")
	public ResponseEntity<DataResult<List<CVEducation>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<CVEducation>> result = CVEducationService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvidorderbygraduationdate")
	public ResponseEntity<DataResult<List<CVEducation>>> getAllByJobSeekerCV_IdOrderByGraduationDate(
			@RequestParam final int jobSeekerCVId, @RequestParam final Direction direction) {
		final DataResult<List<CVEducation>> result = CVEducationService
				.getAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId, direction);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final CVEducation jobSeekerCVEducation) {
		final Result result = CVEducationService.update(jobSeekerCVEducation);

		return ResponseEntity.ok(result);
	}
}
