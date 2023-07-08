package InnovaInstallFuture.ExpenseTrackingAPI.webAPI;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import InnovaInstallFuture.ExpenseTrackingAPI.business.abstracts.UserService;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.CreateUserRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.UpdateUserRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetAllUsersResponse;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetByIdUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;
	

	@GetMapping("/index")
	public String index() {
		return "deneme";
	}
	
	@GetMapping
	public List<GetAllUsersResponse> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
		this.userService.addUser(createUserRequest);
	}
	
	@GetMapping("/{id}")
	public GetByIdUserResponse getByIdUser(@PathVariable int id) {
		return userService.getByIdUser(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		this.userService.deleteUser(id);
	}
	
	@PutMapping
	public void updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
		this.userService.updateUser(updateUserRequest);
	}
	
}
