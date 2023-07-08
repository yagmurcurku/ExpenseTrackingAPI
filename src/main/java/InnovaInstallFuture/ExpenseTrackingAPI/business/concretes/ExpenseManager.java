package InnovaInstallFuture.ExpenseTrackingAPI.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import InnovaInstallFuture.ExpenseTrackingAPI.business.abstracts.ExpenseService;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.CreateExpenseRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.requests.UpdateExpenseRequest;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetAllExpensesResponse;
import InnovaInstallFuture.ExpenseTrackingAPI.business.responses.GetByIdExpenseResponse;
import InnovaInstallFuture.ExpenseTrackingAPI.dataAccess.abstracts.ExpenseRepository;
import InnovaInstallFuture.ExpenseTrackingAPI.entities.concretes.Expense;
import InnovaInstallFuture.ExpenseTrackingAPI.utilities.mappers.ModelMapperService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ExpenseManager implements ExpenseService{

	private ExpenseRepository expenseRepository;
	private ModelMapperService modelMapperService;


	
	@Override
	public GetByIdExpenseResponse getByIdExpense(int id) {
		Expense expense = this.expenseRepository.findById(id).orElseThrow();
		GetByIdExpenseResponse getByIdExpenseResponse = this.modelMapperService.forResponse().
				map(expense, GetByIdExpenseResponse.class);
		
		return getByIdExpenseResponse;
	}


	@Override
	public void addExpense(CreateExpenseRequest createExpenseRequest) {
		
		Expense expense = this.modelMapperService.forRequest().map(createExpenseRequest, Expense.class);
		this.expenseRepository.save(expense);
	}
	
	@Override
	public List<GetAllExpensesResponse> getAllExpenses() {
		List<Expense> expenses = expenseRepository.findAll();
		List<GetAllExpensesResponse> expensesResponses = expenses.stream().map(expense -> 
		this.modelMapperService.forResponse().map(expense, GetAllExpensesResponse.class)).collect
				(Collectors.toList());
				
		return expensesResponses;
	}
	
	@Override
	public void deleteExpense(int id) {
		this.expenseRepository.deleteById(id);
	}

	@Override
	public void updateExpense(UpdateExpenseRequest updateExpenseRequest) {
		Expense expense = this.modelMapperService.forRequest().map(updateExpenseRequest, Expense.class);
		this.expenseRepository.save(expense);
	}

	@Override
	public int getByUserIdTotalExpense(int userId) {
		int totalAmountt =0;
				
		
		List<Expense> expenses = this.expenseRepository.findAllByUserId(userId);
		for (Expense e : expenses) {
		   totalAmountt += e.getExpenseAmount();
		}
		return totalAmountt;
	}

	
		
	

}