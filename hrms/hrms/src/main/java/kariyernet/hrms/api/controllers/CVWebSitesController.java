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

import kariyernet.hrms.business.abstracts.CVWebSiteService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.CVWebSite;

@RestController
@RequestMapping("/hrms/api/jobseekers/cvs/websites")
public class CVWebSitesController {
	private CVWebSiteService CVWebSiteService;

	@Autowired
	public CVWebSitesController(final CVWebSiteService CVWebSiteService) {
		this.CVWebSiteService = CVWebSiteService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final CVWebSite CVWebSite) {
		final Result result = CVWebSiteService.add(CVWebSite);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final CVWebSite CVWebSite) {
		final Result result = CVWebSiteService.delete(CVWebSite);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CVWebSite>>> getAll() {
		final DataResult<List<CVWebSite>> result = CVWebSiteService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvid")
	public ResponseEntity<DataResult<List<CVWebSite>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<CVWebSite>> result = CVWebSiteService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final CVWebSite CVWebSite) {
		final Result result = CVWebSiteService.update(CVWebSite);

		return ResponseEntity.ok(result);
	}
}
