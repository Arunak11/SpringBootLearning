package CRUDandGlobalException.CustomException;

public class ControllerException {
    private String errorCode;
    private String errorMessage;
    public ControllerException(){

    }
    public ControllerException(String errorCode,String errorMessage){
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
