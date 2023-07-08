package InnovaInstallFuture.ExpenseTrackingAPI.business.rules;

import java.util.Optional;

import org.springframework.stereotype.Service;

import InnovaInstallFuture.ExpenseTrackingAPI.dataAccess.abstracts.UserRepository;
import InnovaInstallFuture.ExpenseTrackingAPI.utilities.exceptions.BusinessException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserBusinessRules {

	private UserRepository userRepository;
	
	
	//eklenen User db'de olmamalı !
	public void checkIfUserNameExists(String name) {
		if(this.userRepository.existsByName(name)) {
			throw new BusinessException("User name already exists");
		}
	}
	


	
}