package InnovaInstallFuture.ExpenseTrackingAPI.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllExpensesResponse {

	private String expenseName;
	private int userId;
	private int id;
}
