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

    // �������� ���� �� ����������. ��������� ����� ����� �������� ����� ����� getValidResults().
    // ������� ������� ���� ��� ��� ������ ����� execute()
    public void addTask(Task<? extends T> task) throws Exception {
        if(isExecute){
            throw new Exception();
        }
        tasks.add(task);
        validResults.add(task.getResult());
    }

    // �������� ���� �� ���������� � ��������� ����������. ��������� ����� ����� ������� � ValidResults
    // ���� validator.isValid ������ true ��� ����� ����������
    // ��������� ����� ����� ������� � InvalidResults ���� validator.isValid ������ false ��� ����� ����������
    // ������� ������� ���� ��� ��� ������ ����� execute()
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

    // ��������� ��� ���������� �����
    public void execute() {

        for(Task task: tasks){
            task.execute();
        }

        isExecute = true;
    }

    // �������� �������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    public List<T> getValidResults() throws Exception{
        if (!isExecute){
            throw new Exception();
        }

        return validResults;
    }

    // �������� ���������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    public List<T> getInvalidResults() throws Exception{
        if (!isExecute){
            throw new Exception();
        }

        return invalidResults;
    }
}
