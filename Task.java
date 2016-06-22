package Module_EE_02;

/**
 * Created by Andrey on 02.06.2016.
 */
public interface  Task<T> {

    void execute();
    T getResult();
}
