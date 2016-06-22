package Module_EE_02;

/**
 * Created by Andrey on 03.06.2016.
 */
public class LongTask implements Task<Long> {
    private Long result;

    public LongTask(Long number){
        result = number;
    }


    public void execute() {
    }


    public Long getResult() {
        return result;
    }
}
