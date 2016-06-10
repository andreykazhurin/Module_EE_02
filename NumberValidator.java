package Module_EE_02;

/**
 * Created by Andrey on 03.06.2016.
 */
public class NumberValidator implements Validator<Number> {

    public boolean isValid(Number result) {
        return (result != null) && (result.intValue() > 0);
    }

}
