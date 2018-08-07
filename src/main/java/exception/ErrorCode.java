package exception;

public enum  ErrorCode {

    BAD_USER_INPUT("Bad user input");

    private final String errorMsg;

    ErrorCode(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
