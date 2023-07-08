package InnovaInstallFuture.ExpenseTrackingAPI.business.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExpenseRequest {

	@NotNull
	private String expenseName;
	
	@NotNull
	private int expenseAmount;
	
	@NotNull
	private int userId;
}
