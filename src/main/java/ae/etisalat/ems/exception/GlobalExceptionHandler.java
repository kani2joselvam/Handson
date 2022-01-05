package ae.etisalat.ems.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;



@ControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler({InvalidFormatException.class,
					   JsonMappingException.class,
					   ConstraintViolationException.class})
	public ResponseEntity<ErrorResponse> handleException(WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add("Invalid input passed");
		ErrorResponse error = new ErrorResponse("INVALD_INPUT", details);
	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgException(MethodArgumentNotValidException ex, WebRequest request) {
		 System.out.println("inside MethodArgumentNotValidException");

/*		BindingResult result = ex.getBindingResult();
		System.out.println("result"+result);
	        List<FieldError> fieldErrors = result.getFieldErrors();
	        System.out.println("fieldErrors"+fieldErrors);
	        List<String> details =new ArrayList<>();
	        for (FieldError fieldError: fieldErrors) {
	        	details.add(fieldError.getDefaultMessage());
	        }*/
	        List<String> details  =  ex.getFieldErrors()
				 .parallelStream()
                 .map(e -> e.getDefaultMessage())
                 .collect(Collectors.toList());
		 System.out.println(details);
		 ErrorResponse error = new ErrorResponse("BAD_REQUEST", details);
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(EmployeeManagementException.class)
	public ResponseEntity<ErrorResponse> handleLibraryManagementException(EmployeeManagementException ex,WebRequest request) {
	
		List<String> details = new ArrayList<String>();
		details.add(ex.getResponseMessage());
		ErrorResponse error = new ErrorResponse(ex.getResponseCode(), details);
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}