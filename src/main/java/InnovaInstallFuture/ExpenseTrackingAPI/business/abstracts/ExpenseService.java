package InnovaInstallFuture.ExpenseTrackingAPI.business.abstracts;

import java.util.List;

import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.CreateExpenseRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.UpdateExpenseRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetAllExpensesResponse;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetByIdExpenseResponse;

public interface ExpenseService {

	List<GetAllExpensesResponse> getAllExpenses();	
	GetByIdExpenseResponse getByIdExpense(int id);	
	int getByUserIdTotalExpense(int userId); 
	void addExpense(CreateExpenseRequest createExpenseRequest);
	void deleteExpense(int id);									
	void updateExpense(UpdateExpenseRequest updateExpenseRequest);	
}