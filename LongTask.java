package Module_EE_02;

/**
 * Created by Andrey on 03.06.2016.
 */
public class LongTask<T extends Number> implements Task<T> {
    private T result;

    public LongTask(T number){
        result = number;
    }


    public void execute() {
    }


    public T getResult() {
        return result;
    }
}
