package Module_EE_02;

import java.util.List;

/**
 * Created by Andrey on 02.06.2016.
 */
public interface Executor<T> {

    void addTask(Task<? extends T> task) throws Exception;

    void addTask(Task<? extends T> task, Validator<? super T> validator) throws Exception;

    void execute();

    List<T> getValidResults() throws Exception;

    List<T> getInvalidResults() throws Exception;
}
