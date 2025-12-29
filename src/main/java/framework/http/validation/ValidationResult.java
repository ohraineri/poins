package framework.http.validation;

public class ValidationResult {
    public final int statusCode; 
    public final String responseMessage; 
    public final boolean validRequest;

    public ValidationResult(int statusCode, String responseMessage, boolean validRequest) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.validRequest = validRequest;
    }

    public static ValidationResult ok() {
        return new ValidationResult(200, null, true);
    }

    public static  ValidationResult error(int statusCode, String responseMessage) {
        return new ValidationResult(statusCode, responseMessage, false);
    }
}
