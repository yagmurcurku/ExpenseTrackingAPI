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

import InnovaInstallFuture.ExpenseTrackingAPI.business.abstracts.ExpenseService;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.CreateExpenseRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.UpdateExpenseRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetAllExpensesResponse;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetByIdExpenseResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/expenses")
public class ExpenseController {
	
	private ExpenseService expenseService;
	
	@GetMapping
	public List<GetAllExpensesResponse> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
	
	@GetMapping("/{id}")
	public GetByIdExpenseResponse getByIdExpense(@PathVariable int id) {
		return expenseService.getByIdExpense(id);
	}
	
	@GetMapping("/total/{userId}")
	public int totalExpense(@PathVariable int userId) {
		return expenseService.getByUserIdTotalExpense(userId);
	}
	
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createExpense(@RequestBody @Valid CreateExpenseRequest createExpenseRequest) {
		this.expenseService.addExpense(createExpenseRequest);
	}
	
	@DeleteMapping("/{id}")
	public void deleteExpense(@PathVariable int id) {
		this.expenseService.deleteExpense(id);
	}
	
	@PutMapping
	public void updateExpense(@RequestBody UpdateExpenseRequest updateExpenseRequest) {
		this.expenseService.updateExpense(updateExpenseRequest);
	}
	
}
