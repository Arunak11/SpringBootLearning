package SpringBoot.AOP.SampleAOP.CustomException;

public class EmptyInputException extends RuntimeException{
    private String errorCode;
    private String errorMessage;
    public EmptyInputException(){

    }
    public EmptyInputException(String errorCode,String errorMessage){
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

