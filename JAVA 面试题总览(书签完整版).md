JAVA基础
1. JAVA 中的几种基本数据类型是什么,各自占用多少字节。
    1 bit: 二进制的一个数  位
    1 Byte = 8 bit       字节
    1 KB = 1024 Byte     K
    1 MB = 1024 KB       M

    int     32bit   4Byte
    short   16bit
    long    64bit
    byte    8bit
    char    16bit
    float   32bit
    double  64bit
    boolean 1bit

2.String 类能被继承吗,为什么。
    不能, 因为final修饰符, 修饰了String类, 表示其可不以被继承

    很多时候会容易把static和final关键字混淆, static作用于成员变量用来表示只保存一份副本, 而final的作用是用来保证变量不可变

3. String,Stringbuffer,StringBuilder 的区别
    String定义后值是不可以变的, 因为String类中, char[] value 是被final修饰的. 修改字符串的时候, 性能不如后两者
    StringBuilder是非线程安全的. 因为类中方法如, append方法不是synchronized.


    String          不可变字符串
    StringBuilder   可变字符串       效率高     线程不安全
    StringBuffer    可变字符串       效率低     线程安全


