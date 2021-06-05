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

import kariyernet.hrms.business.abstracts.CVSkillService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;
import kariyernet.hrms.entities.concretes.CVSkill;

@RestController
@RequestMapping("/hrms/api/jobseekers/cvs/skills")
public class CVSkillsController {
	private CVSkillService CVSkillService;

	@Autowired
	public CVSkillsController(final CVSkillService CVSkillService) {
		this.CVSkillService = CVSkillService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final CVSkill CVSkill) {
		final Result result = CVSkillService.add(CVSkill);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final CVSkill CVSkill) {
		final Result result = CVSkillService.delete(CVSkill);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<CVSkill>>> getAll() {
		final DataResult<List<CVSkill>> result = CVSkillService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byjobseekercvid")
	public ResponseEntity<DataResult<List<CVSkill>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<CVSkill>> result = CVSkillService.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byid")
	public ResponseEntity<DataResult<CVSkill>> getById(final int id) {
		final DataResult<CVSkill> result = CVSkillService.getById(id);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final CVSkill jobSeekerCVSkill) {
		final Result result = CVSkillService.update(jobSeekerCVSkill);

		return ResponseEntity.ok(result);
	}
}
