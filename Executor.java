package Module_EE_02;

import java.util.List;

/**
 * Created by Andrey on 02.06.2016.
 */
public interface Executor<T> {

    // �������� ���� �� ����������. ��������� ����� ����� �������� ����� ����� getValidResults().
    // ������� ������� ���� ��� ��� ������ ����� execute()
    void addTask(Task<? extends T> task) throws Exception;

    // �������� ���� �� ���������� � ��������� ����������. ��������� ����� ����� ������� � ValidResults
    // ���� validator.isValid ������ true ��� ����� ����������
    // ��������� ����� ����� ������� � InvalidResults ���� validator.isValid ������ false ��� ����� ����������
    // ������� ������� ���� ��� ��� ������ ����� execute()
    void addTask(Task<? extends T> task, Validator<? super T> validator) throws Exception;

    // ��������� ��� ���������� �����
    void execute();

    // �������� �������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    List<T> getValidResults() throws Exception;

    // �������� ���������� ����������. ������� ������� ���� �� ��� ������ ����� execute()
    List<T> getInvalidResults() throws Exception;
}
