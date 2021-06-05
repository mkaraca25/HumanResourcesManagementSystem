package kariyernet.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kariyernet.hrms.business.abstracts.CVLanguageService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.CVLanguage;

@RestController
@RequestMapping("/hrms/api/jobseekers/cvs/languages")
public class CVLanguagesController {
	private CVLanguageService CVLanguageService;

	@Autowired
	public CVLanguagesController(final CVLanguageService CVLanguageService) {
		this.CVLanguageService = CVLanguageService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final CVLanguage CVLanguage) {
		final Result result = CVLanguageService.add(CVLanguage);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final CVLanguage CVLanguage) {
		final Result result = CVLanguageService.delete(CVLanguage);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CVLanguage>>> getAll() {
		final DataResult<List<CVLanguage>> result = CVLanguageService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvid")
	public ResponseEntity<DataResult<List<CVLanguage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<CVLanguage>> result = CVLanguageService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byid")
	public ResponseEntity<DataResult<CVLanguage>> getbyid(final int id) {
		final DataResult<CVLanguage> result = CVLanguageService.getById(id);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final CVLanguage CVLanguage) {
		final Result result = CVLanguageService.update(CVLanguage);

		return ResponseEntity.ok(result);
	}
}
