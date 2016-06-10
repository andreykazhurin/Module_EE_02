package Module_EE_02;

import java.util.List;

/**
 * Created by Andrey on 02.06.2016.
 */

//1 Переписать интерфейс Task так что бы он был типизирован по результату (значению возращаемуому методом getResult()).
//
//2 Переписать интерфейс Validator так что бы он был типизирован по принемаемому значению isValid(Object result);
//
//3 Переписать интерфейс Executor так чтоб он был типизирован в соответсвии с с типизацией Task и Validator
//
//4 Импелементирвать интерфейс Executor
//
//5 Написать к нему тесты.

public class Main {
    public static void main(String[] args) {

    }
    public void test(List<Task<Integer>> intTasks) throws Exception{
        Executor<Number> numberExecutor = new ExecutorImpl<Number>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }
}
