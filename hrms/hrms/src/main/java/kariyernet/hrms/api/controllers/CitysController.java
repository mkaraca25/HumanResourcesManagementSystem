package kariyernet.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kariyernet.hrms.business.abstracts.CityService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.entities.concretes.City;

@RestController
@RequestMapping("/hrms/api/cities")
public class CitysController {
	private CityService cityService;

	@Autowired
	public CitysController(final CityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<City>>> getAll() {
		final DataResult<List<City>> result = cityService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getbyid")
	public ResponseEntity<DataResult<City>> getById(final short id) {
		final DataResult<City> result = cityService.getById(id);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getbyname")
	public ResponseEntity<DataResult<City>> getByName(final String name) {
		final DataResult<City> result = cityService.getByName(name);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getbynamecontains")
	public ResponseEntity<DataResult<List<City>>> getByNameContains(final String name) {
		final DataResult<List<City>> result = cityService.getByNameContains(name);

		return ResponseEntity.ok(result);
	}
	@GetMapping("/getAllByPage")
	DataResult<List<City>> getAll(int pageNo, int pageSize){
		return this.cityService.getAll(pageNo, pageSize);
	}
	@GetMapping("/getAllAsc")
	public DataResult<List<City>> getAllSorted() {
		return this.cityService.getAllSorted();
	}
}
