package InnovaInstallFuture.ExpenseTrackingAPI.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import InnovaInstallFuture.ExpenseTrackingAPI.entities.concretes.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer>{
	List<Expense> findAllByUserId(int userId);
	
}	
