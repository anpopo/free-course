package free.course.baseball.exception;

public class NotValidInputException extends RuntimeException {
    public NotValidInputException(String message) {
        super(message);
    }
}
