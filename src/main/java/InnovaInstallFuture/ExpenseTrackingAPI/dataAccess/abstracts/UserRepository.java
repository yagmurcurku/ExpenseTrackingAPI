package InnovaInstallFuture.ExpenseTrackingAPI.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import InnovaInstallFuture.ExpenseTrackingAPI.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	boolean existsByName(String name); 
	boolean existsById(int id);
}