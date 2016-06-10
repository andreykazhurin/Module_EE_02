package Module_EE_02;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andrey on 03.06.2016.
 */
public class ExecutorImpl<T> implements Executor<T> {

    private boolean isExecute = false;
    private List<T> validResults = new ArrayList<>();
    private List<T> invalidResults = new ArrayList<>();
    private List<Task<? extends T>> tasks = new ArrayList<>();

    // Добавить таск на выполнение. Результат таска будет доступен через метод getValidResults().
    // Бросает Эксепшн если уже был вызван метод execute()
    public void addTask(Task<? extends T> task) throws Exception {
        if(isExecute){
            throw new Exception();
        }
        tasks.add(task);
        validResults.add(task.getResult());
    }

    // Добавить таск на выполнение и валидатор результата. Результат таска будет записан в ValidResults
    // если validator.isValid вернет true для этого результата
    // Результат таска будет записан в InvalidResults если validator.isValid вернет false для этого результата
    // Бросает Эксепшн если уже был вызван метод execute()
    public void addTask(Task<? extends T> task, Validator<? super T> validator) throws Exception{
        if(isExecute){
            throw new Exception();
        }
        tasks.add(task);
        if (validator.isValid(task.getResult())) {
            validResults.add(task.getResult());
        } else
            invalidResults.add(task.getResult());
    }

    // Выполнить все добавленые таски
    public void execute() {

        for(Task task: tasks){
            task.execute();
        }

        isExecute = true;
    }

    // Получить валидные результаты. Бросает Эксепшн если не был вызван метод execute()
    public List<T> getValidResults() throws Exception{
        if (!isExecute){
            throw new Exception();
        }

        return validResults;
    }

    // Получить невалидные результаты. Бросает Эксепшн если не был вызван метод execute()
    public List<T> getInvalidResults() throws Exception{
        if (!isExecute){
            throw new Exception();
        }

        return invalidResults;
    }
}
