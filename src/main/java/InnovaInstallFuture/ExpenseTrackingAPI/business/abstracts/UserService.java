package InnovaInstallFuture.ExpenseTrackingAPI.business.abstracts;

import java.util.List;

import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.CreateUserRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.UpdateUserRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetAllUsersResponse;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetByIdUserResponse;

public interface UserService {

	List<GetAllUsersResponse> getAllUsers();
	GetByIdUserResponse getByIdUser(int id);
	void addUser(CreateUserRequest createUserRequest);
	void deleteUser(int id);
	void updateUser(UpdateUserRequest updateUserRequest);
	
}