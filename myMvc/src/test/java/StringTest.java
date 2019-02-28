import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by robin on 19/1/21.
 */
public class StringTest {

    @Test
    public void name() throws Exception {

        String a = null;
        String b = "b";

        System.out.println(a + b);

    }

    @Test
    public void testFor() throws Exception {

        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        System.out.println();
        for (int i = 0; i < 3; ++i) {
            System.out.println(i);
        }

    }

    @Test
    public void name2() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");

        for (String s : list) {
            System.out.println(s.hashCode());
        }

    }

    @Test
    public void testHashCode() throws Exception {

        TestObject a = new TestObject();
        TestObject b = new TestObject();
        TestObject c = a;

        a.setX(1);
        b.setX(2);
        c.setX(3);

        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println();

        System.out.println(a == c);
        System.out.println(a.equals(c));
        System.out.println();

        System.out.println(a.getX());
        System.out.println(b.getX());
        System.out.println(c.getX());
    }

    @Test
    public void testPlus() throws Exception {
        System.out.println(testPlus1());
        System.out.println(testPlus2());
    }

    private int testPlus1() {
        int a = 1;
        return a++;
    }

    private int testPlus2() {
        int a = 1;
        return ++a;
    }

    @Test
    public void testNullInList() throws Exception {
        List<Object> list = new ArrayList<>();
        list.add(null);
        list.add(null);

        System.out.println(list.size());


        for (int i = 0; i < 100000; i++) {
            list.add(null);
        }

        System.out.println(list.size());
    }

    @Test
    public void testPlusPlus() throws Exception {
        int a = 0;
        int b = 0;
        System.out.println(b = a++);
//        System.out.println(a=a++);
        System.out.println(a);

    }

    @Test
    public void testFor2() throws Exception {
        int i = 0;
        for (int j = 0; j < 5; j++) {
            System.out.println(i = i++);
        }
    }

    @Test
    public void testHash() throws Exception {
        Set<Student> set = new HashSet<>();
        set.add(new Student("张三", 18));
        set.add(new Student("张三", 19));

        System.out.println(set.size());
    }

    private class Student {
        String name;
        int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }


        @Override
        public boolean equals(Object obj) {

//            return super.equals(obj);
//            if(obj instanceof Student) {
//
//            }
//            return this.name == ((Student) obj).name;
            return this.hashCode() == obj.hashCode();
        }
    }

}
