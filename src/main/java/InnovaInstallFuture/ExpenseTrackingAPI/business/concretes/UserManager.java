package InnovaInstallFuture.ExpenseTrackingAPI.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import InnovaInstallFuture.ExpenseTrackingAPI.business.abstracts.UserService;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.CreateUserRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.UpdateUserRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetAllUsersResponse;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetByIdUserResponse;
import InnovaInstallFuture.ExpenseTrackingAPI.business.rules.UserBusinessRules;
import InnovaInstallFuture.ExpenseTrackingAPI.dataAccess.abstracts.UserRepository;
import InnovaInstallFuture.ExpenseTrackingAPI.entities.concretes.User;
import InnovaInstallFuture.ExpenseTrackingAPI.utilities.mappers.ModelMapperService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserManager implements UserService{

	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	private UserBusinessRules userBusinessRules;
	
	@Override
	public List<GetAllUsersResponse> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<GetAllUsersResponse> usersResponse = users.stream().map(user -> this.modelMapperService.
				forResponse().map(user, GetAllUsersResponse.class)).collect(Collectors.toList());
		
		return usersResponse;
	}

	@Override
	public GetByIdUserResponse getByIdUser(int id) {
		User user = userRepository.findById(id).orElseThrow();
		GetByIdUserResponse getByIdUserResponse = this.modelMapperService.forResponse().
				map(user, GetByIdUserResponse.class);
		
		return getByIdUserResponse;
	}

	@Override
	public void addUser(CreateUserRequest createUserRequest) {
		this.userBusinessRules.checkIfUserNameExists(createUserRequest.getName());
		
		User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
		this.userRepository.save(user);
	}

	@Override
	public void deleteUser(int id) {

		this.userRepository.deleteById(id);
	}

	@Override
	public void updateUser(UpdateUserRequest updateUserRequest) {
		User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
		this.userRepository.save(user);
	}

	

}
