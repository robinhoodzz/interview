import java.util.HashMap;

/**
 * Created by robin on 19/2/19.
 */
public class KeyTest {


    public static void main(String[] args) {
        HashMap<Key, Integer> hashMap = new HashMap<>();

        hashMap.put(new Key(1), 2);
        hashMap.put(new Key(1), 2);
        hashMap.put(new Key(1), 2);
        hashMap.put(new Key(1), 2);

        System.out.println(hashMap.size());


//        HashMap<Integer, Object> hashMap = new HashMap<>();
//
//        hashMap.put(1, 2);
//        hashMap.put(2, 2);
//        hashMap.put(3, 2);
//        hashMap.put(1, 2);
//
//        System.out.println(hashMap.size());
    }
}
