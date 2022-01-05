package ae.etisalat.ems.exception;

public class EmployeeManagementException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	private String message;
	
	private String responseCode;
	
	private String responseMessage;

	public EmployeeManagementException() {
		super();
	}
	
	public EmployeeManagementException(String responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}


	public EmployeeManagementException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public EmployeeManagementException(String message) {
		super(message);
		this.message = message;
	}

	public EmployeeManagementException(Throwable cause) {
		super(cause);
	}

	public String getMessage() {
		return message;
	}
	
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
