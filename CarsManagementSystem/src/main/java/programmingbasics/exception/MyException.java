package programmingbasics.exception;

public class MyException extends RuntimeException {
    private ExceptionInfo exceptionInfo;

    public MyException(String exceptionMessage) {
        this.exceptionInfo = new ExceptionInfo(exceptionMessage);

    }
}

