package 书籍统计;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计书籍
 * <p>
 * Created by robin on 19/2/13.
 */
public class 书籍统计 {


    private String path = "/Users/robin/Work/p2p-project/做实验/interview/src/test/java/书籍统计/书.txt";


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void name() throws Exception {
        File file = new File(path);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        Map<String, Integer> hashMap = new HashMap<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if ("".equals(line.trim())) continue;

            Integer count = hashMap.get(line);
            count = (count == null ? 0 : ++count);

            hashMap.put(line, count);
        }


        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {

            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }


    }


}
