package thread;

import org.junit.Test;

import java.util.Map;

/**
 * Created by Administrator on 2019/2/24.
 */
public class StackTraces {

    @Test
    public void name() throws Exception {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        System.out.println(allStackTraces);

    }
}
