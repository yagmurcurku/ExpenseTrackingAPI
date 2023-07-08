package InnovaInstallFuture.ExpenseTrackingAPI;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import InnovaInstallFuture.ExpenseTrackingAPI.utilities.exceptions.BusinessException;
import InnovaInstallFuture.ExpenseTrackingAPI.utilities.exceptions.ProblemDetails;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })  //BU ŞEKİLDE ÇALIŞIYOR FAKAT SECURITY ÇALIŞMIYOR
@RestControllerAdvice  //exception handler'ın çalışması için
public class ExpenseTrackingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackingApiApplication.class, args);
	}


	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException ) {//business exception alırsa çalışır
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	} //sistemle ilgili fazla bilgi vermemek için sadece message'ı döner


	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
