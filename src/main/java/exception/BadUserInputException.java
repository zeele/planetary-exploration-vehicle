package exception;

public class BadUserInputException extends BaseException {
    private static final long serialVersionUID = 5804271613446754829L;

    public BadUserInputException(String input) {
        super(ErrorCode.BAD_USER_INPUT,
                String.format("Bad user input, user input is %s", input));
    }
}
