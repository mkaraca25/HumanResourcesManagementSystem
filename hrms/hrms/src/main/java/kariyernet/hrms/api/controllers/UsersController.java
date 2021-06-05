package kariyernet.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kariyernet.hrms.entities.concretes.User;
import kariyernet.hrms.business.abstracts.UserService;
import kariyernet.hrms.core.utilities.result.DataResult;
import kariyernet.hrms.core.utilities.result.Result;


@RestController
@RequestMapping("/hrms/api/users")
public class UsersController {
	private final UserService userService;

	@Autowired
	public UsersController(final UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	@PostMapping("/update")
	    public Result update(@RequestBody User user) {
		return this.userService.update(user);
	}
//
//	@PostMapping("/delete")
//	public Result delete(@PathVariable("id") int id) {
//		return this.userService.delete(id);
//	}
//
//	@GetMapping("/getbyid")
//	public DataResult<User> getById(@PathVariable("id") int id) {
//		return this.userService.getById(id);
//	}
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<User>>> getAll() {
		final DataResult<List<User>> result = userService.getAll();

		return ResponseEntity.ok(result);
	}


}
