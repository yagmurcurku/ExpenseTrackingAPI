package InnovaInstallFuture.ExpenseTrackingAPI.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateExpenseRequest {

	private int id;
	private String name;
	private int expenseAmount;
	private int userId;
}
