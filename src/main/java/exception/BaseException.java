package exception;

/**
 * BaseException is an application specific Runtime Exception. All other runtime exceptions defined
 * by this application should extend from this class. Each exception should have an error code
 * defined that can be used to map exceptions to the appropriate error page.
 */
public class BaseException extends RuntimeException {

    //we have this serialVersionUID to define the version for a particular class while serializing and deserialzing. consider a scenario where you have a class Employee which has 3 fields which has been in production for some time (meaning there may exist many serialized versions of employee objects), when you update the class to include (say a 4th field) then all the previous class (which are serialized) cannot be casted or deserialised to the new one & you'll get an exception..to avoid this issue, you can use the serialVersionUID field to tell JVM that the new class is infact of a different version (by changing the serialVersionUID).
    private static final long serialVersionUID = 8786849139445858267L;
    /**
     * The error code for the given exception. This should be as specific as possible so that
     * information can be passed ot the user
     */
    private final ErrorCode errorCode;

    /**
     * Constructs a new BaseException with the given errorCode and message
     *
     * @param message the detailed message about what went wrong
     * @param errorCode The error code that describes this type of error
     */
    public BaseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * Constructs a new BaseException with the given errorCode and message
     *
     * @param errorCode The error code that describes this type of error
     * @param message the detailed message about what went wrong
     * @param cause the cause of this exception
     */
    public BaseException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * Return the error message. This is useful for logging
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return this.getMessage();
    }

    /**
     * Returns true if this is a system error, false otherwise. A system error is defined as an
     * error in configuration or missing data. A non-system error would be specific to the user
     *
     * @return true if this is a system error, false otherwise
     */
    public boolean isSystemError() {
        return true;
    }
}
