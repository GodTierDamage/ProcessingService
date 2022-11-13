package exceptions;

public class SheetNotFoundException extends RuntimeException{

    public SheetNotFoundException(String exceptionDescribe) {
        throw new RuntimeException(exceptionDescribe);
    }
}
