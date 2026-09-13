package com.example.demo.DTO;

public class ApiResponseDTO<T> {
	  private String message;
	    private boolean success;
	    private T body;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public T getBody() {
			return body;
		}
		public void setBody(T body) {
			this.body = body;
		}
		public ApiResponseDTO(String message, boolean success, T body) {
			super();
			this.message = message;
			this.success = success;
			this.body = body;
		}
		
		public ApiResponseDTO() {
			super();
			
		}
	    
	    

}
