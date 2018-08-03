package Calculator.exceptions;

public class WrongRangeException extends IllegalArgumentException {

    public WrongRangeException(){
        super();
    }

    public WrongRangeException(String message){
        super(message);
    }
}