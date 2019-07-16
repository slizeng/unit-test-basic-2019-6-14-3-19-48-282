package ExpenseService.Exception;

public class UnexpectedProjectTypeException extends RuntimeException {
    public UnexpectedProjectTypeException(String errorMsg) {
        super(errorMsg);
    }
}
