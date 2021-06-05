package kariyernet.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import kariyernet.hrms.business.abstracts.CompanyStaffVerificationService;
import kariyernet.hrms.core.utilities.result.Result;

@RestController
@RequestMapping("/hrms/api/companystaffverifications")
public class CompanyStaffVerificationsController {
	private final CompanyStaffVerificationService companyStaffVerificationService;

	@Autowired
	public CompanyStaffVerificationsController(final CompanyStaffVerificationService companyStaffVerificationService) {
		this.companyStaffVerificationService = companyStaffVerificationService;
	}

	@GetMapping("/verify")
	public ResponseEntity<Result> verify(@RequestParam final int userId) {
		final Result result = companyStaffVerificationService.verify(userId);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
