package Module_EE_02;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andrey on 03.06.2016.
 */
public class ExecutorImpl<T> implements Executor<T> {

    private List<T> validResult = new ArrayList<>();
    private List<T> invalidResult = new ArrayList<>();
    private List<TaskAndValidator<T>> tasks = new ArrayList<>();

    private static final Validator<Object> DEFAULT_VALIDATOR = value -> true;
    private boolean executed = false;


    @Override
    public void addTask(Task<? extends T> task) throws Exception {
        addTask(task, DEFAULT_VALIDATOR);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) throws Exception {
        checkNotExecuted();
        tasks.add(new TaskAndValidator<T>(task, validator));
    }



    @Override
    public void execute() {
        checkNotExecuted();
        for(TaskAndValidator<T> taskAndValidator : tasks){
            Task<? extends T> task = taskAndValidator.task;
            task.execute();
            if(taskAndValidator.validator.isValid(task.getResult())) {
                validResult.add(task.getResult());
            }else{
                invalidResult.add(task.getResult());
            }

        }
        executed = true;
    }

    @Override
    public List<T> getValidResults() throws Exception {
        checkExecuted();
        return validResult;
    }

    @Override
    public List<T> getInvalidResults() throws Exception {
        checkExecuted();
        return invalidResult;
    }

    private static class TaskAndValidator<T>{
        private Task<? extends T> task;
        private Validator<? super T> validator;

        public TaskAndValidator(Task<? extends T> task, Validator<? super T> validator) {
            this.task = task;
            this.validator = validator;
        }
    }

    public void checkExecuted(){
        if(!executed){throw new IllegalStateException("Executor already executed");}
    }
    public void checkNotExecuted(){
        if(executed){throw new IllegalStateException("Executor already executed");}
    }
}
