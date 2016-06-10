package Module_EE_02;

/**
 * Created by Andrey on 02.06.2016.
 */
public interface  Task<T> {
    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();
}
