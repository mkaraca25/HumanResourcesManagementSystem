package kariyernet.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kariyernet.hrms.business.abstracts.LanguageService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(final LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("getall")
	public ResponseEntity<DataResult<List<Language>>> getAll() {
		final DataResult<List<Language>> result = languageService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("getbyid")
	public ResponseEntity<DataResult<Language>> getById(@RequestParam final String id) {
		final DataResult<Language> result = languageService.getById(id);

		return ResponseEntity.ok(result);
	}

}
