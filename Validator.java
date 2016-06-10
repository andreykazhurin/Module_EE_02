package Module_EE_02;

/**
 * Created by Andrey on 02.06.2016.
 */
public interface Validator<T> {
    // Валидирует переданое значение
    boolean isValid(T result);
}
