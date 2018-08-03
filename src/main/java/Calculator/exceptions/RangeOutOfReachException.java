package Calculator.exceptions;

public class RangeOutOfReachException  extends IllegalArgumentException {

    public RangeOutOfReachException(){
        super();
    }

    public RangeOutOfReachException(String message){
        super(message);
    }
}
