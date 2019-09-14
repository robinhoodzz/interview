import lombok.Data;
import org.junit.Test;

/**
 * Created by Administrator on 2019/6/8.
 */
public class StringTest {

    @Test
    public void name() throws Exception {
        Job job1 = new Job();
        Job job2 = new Job();

        job1.setName("dev");
        job2 = job1;

        System.out.println("job1 " + job1.getName());
        System.out.println("job2 " + job2.getName());
        job1.setName("test");
        System.out.println();
        System.out.println("job1 " + job1.getName());
        System.out.println("job2 " + job2.getName());




        job2 = (Job) job1.clone();
        job1.setName("boss");
        System.out.println();
        System.out.println("job1 " + job1.getName());
        System.out.println("job2 " + job2.getName());

    }



    @Data
    class Job implements Cloneable{
        private String name;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
