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


4. ArrayList 和 LinkedList 有什么区别
    简单区别
        ArrayList   基于动态数组实现    随机访问时间复杂度低                  插入和删除操作性能低, 以为要移动数据
        LinkedList  基于双链表实现的    随机访问时间复杂度高(因为要移动指针)    性能高
    深度区别
        ArrayList   末尾插入删除  开销大(因为当调整数组长度时,拷贝, 数组重新分配)
        LinkedList  末尾插入删除  开销固定, 分配一个Entry对象


        ArrayList   中间插入和删除 剩余元素都会移动
        LinkedList  中间插入和删除 开销固定

        ArrayList   空间浪费体现在 数组末端没有没填充数据的部分
        LinkedList  不支持随机访问, 因为他没有实现RandomAccess接口, 也就是说用iterator比用for性能高

5. 讲讲类的实例化顺序,比如父类静态数据,构造函数,字段,子类静态数据,构造函数,字段,当 new 的时候,他们的执行顺序。
    加载–>连接->初始化
    父类静态变量、
    父类静态代码块、
    子类静态变量、
    子类静态代码块、
    父类非静态变量（父类实例成员变量）、
    父类构造函数、
    子类非静态变量（子类实例成员变量）、
    子类构造函数。

6. 用过哪些 Map 类,都有什么区别,HashMap 是线程安全的吗,并发下使用的 Map 是什么, 他们内部原理分别是什么,比如存储方式,hashcode,扩容,默认容量等。
    Hashtable           Key不能为null  value不能为null   线程安全
    ConcurrentHashMap   Key不能为null  value不能为null   锁分段技术(JDK8: CAS)
    TreeMap             Key不能为null  value不能为null   线程不安全
    HashMap             Key可以null    value可以是null   线程不安全

    有没有顺序的Map实现类，如果有，他们是怎么保证有序的。
    TreeMap和LinkedHashMap是有序的（TreeMap默认升序，LinkedHashMap则记录了插入顺序）。


7. JAVA8 的 ConcurrentHashMap 为什么放弃了分段锁,有什么问题吗,如果你来设计,你如何设计。
    主要目的: 维护并发可读性
    次要目的: 空间消耗比HashMap相同或者更好, 且支持多线程高效率的初始插入
    HashTable线程安全, 但是使用synchronized方法, 多线程效率低下, 线程1进行put时,线程2无法put或者get.
    1.8前实现原理:
        锁分离:
            在HashMap基础上, 将数据分成多段存储, 由多个segment组成, 每个segment有一把锁, segment下包含很多node, 也就是键值对
    1.8后实现原理:
        unsafe.compareAndSwapInt(this, valueOffSet, expect, update)
        意思是如果valueOffSet位置包含的值与expect值相同, 则更新valueOffSet位置的值为update, 并返回true, 否则返回false.

    CAS原理
        底层C和汇编 先判断是否多核, 如果多核加锁, 锁的是总线, 使得其他CPU内核无法通过总线访问内存
        后续, 优化为: 锁CPU缓存以锁定对应的内存地址映射, 但静态程度很高或缓存与内存地址未对其时, 还是会锁总线

    CAS缺点
        1. 循环时间开销很大
        2. 只能保证一个共享变量的原子操作
        3. ABA问题

    ABA问题
        线程X当前读取数据为A, 并复制前检查为, 这个不能说明没有被其他线程修改过
        线程Y, 修改值为B, 又修改回A. 此时看山去还是A, 但是是被修改过的
        Java并发包里的带有原子标记的类AtomicStampedReference, 可以控制版本

    看考: https://blog.csdn.net/v123411739/article/details/79561458


?8. 有没有有顺序的 Map 实现类,如果有,他们是怎么保证有序的。
    LinkedHashMap   按插入顺序   维护着一个运行于所有条目的双重链接列表
    TreeMap         按值的顺序   红黑树实现

9. 抽象类和接口的区别,类可以继承多个类么,接口可以继承多个接口么,类可以实现多个接口么
    1. 抽象类和接口都不能实例化, 如果要实例化, 抽象类变量必须指向实现所有抽象方法的子类对象, 接口变量必须指向实现所有接口方法的类对象.
    2. 抽象类要被子类继承, 接口要被类实现
    3. 接口只能做方法申明, 抽象类中可以做方法申明, 也可以做方法实现
    4. 接口里定义的变量只能是公共静态的常量, 抽象类中的变量是普通变量
    5. 抽象类里的抽象方法必须全部被子类实现, 如果子类不能全部实现父类抽象方法, 那么该子类只能是抽象类. 同样, 一个类实现接口的时候,如不能全部实现接口方法, 那也只能是抽象类.
    6. 抽象方法只能申明, 不能实现. abstract void asd(); 不能写成abstract void asd(){}
    7. 抽象类里可以有抽象方法
    8. 如果一个类里有抽象方法, 这个类只能是抽象类
    9. 抽象方法要被实现, 所以不能是静态的, 也不能是私有的
    10. 接口可以继承接口, 并可以多继承, 但是能单根继承

10. 继承和聚合的区别在哪儿?
    继承: 是一个类继承另外一个类的功能, 并增加自己新功能的能力
    聚合: 是属于包含的关系, 类和类是可分离的, 各自有各自的生命周期

?11. IO 模型有哪些,讲讲你理解的 nio,他和 bio 的区别是啥,谈谈 reactor 模型
    IO是面向流的, NIO是面向缓冲区的

?12. 反射的原理,反射创建类实例的三种方式是什么。

13. 反射中,Class.forName 和 ClassLoader 区别。

    类加载过程:
        装载: 查找和导入类或接口的二进制数据
        链接: 执行下面的校验、准备和解析步骤，其中解析步骤是可以选择的
        校验: 检查导入类或接口的二进制数据的正确性
        准备: 给类的静态变量分配并初始化存储空间
        解析: 将符号引用转成直接引用
        初始化: 激活类的静态变量的初始化Java代码和静态Java代码块


    Class.forName(className)方法，其实调用的方法是Class.forName(className,true,classloader)
    注意看第2个boolean参数，它表示的意思，在loadClass后必须初始化

    ClassLoader.loadClass(className)方法, 其实他调用的方法是ClassLoader.loadClass(className,false)
    注意看第2个boolean参数，该参数表示目标对象被装载后不进行链接，这就意味这不会去执行该类静态块中间的内容

    https://my.oschina.net/gpzhang/blog/486743

14. 描述动态代理的几种实现方式,分别说出相应的优缺点。
    JDK cglib
    JDK
        jdk底层是利用反射机制, 需要基于接口方式, 这是由于
    Cglib
        则是基于asm框架, 实现了无反射机制进行代理, 利用空间来换取了时间, 代理效率高于jdk cglib

?15. 动态代理与cglib实现的区别。
    JDK动态代理只能对实现了接口的类生成代理, 而不能针对类
    CGLIB是针对类实现代理, 主要是对指定的类生成一个子类, 覆盖其中的方法(继承)

    Spring的选择
    当Bean实现接口时, Spring就会用JDK动态代理
    当Bean没有实现接口是, Spring使用CGlib代理

    CGlib实现的动态代理, 底层采用ASM字节码生成框架, 使用字节码技术生成代理类, 比使用java反射效率高, 但不能对声明为final的方法进行代理, 因为Cglib原理是动态生成被代理类的子类
    JDK动态代理性能比cglib要好20%左右

    https://www.cnblogs.com/bigmonkeys/p/7823268.html

16. 为什么CGlib方式可以对接口实现代理。

17. final的用途。
    类         不能被继承
    方法       不能被重写
    成员变量    把变量作为只读
    本地变量    把变量作为只读

18. 写出三种单例模式实现。
    懒汉式单例   直接new
    饿汉式单例   使用的时候new, 但是线程不安全
    双重检查等   synchronized修饰符 + volatile修饰符
    内部类方式   利用JVM类加载机制, 首次主动使用类的时候加载,连接,初始化

19. 如何在父类中为子类自动完成所有的 hashcode 和 equals 实现?这么做有何优劣。


20. 请结合 OO 设计理念,谈谈访问修饰符 public、private、protected、default 在应用设计中的作用。
    访问修饰符, 用于隔离防护
                同类  同包  不同包子类   不同包非子类
    private     Y
    default     Y     Y
    protected   Y     Y     Y
    public      Y     Y     Y          Y



21. 深拷贝和浅拷贝区别。
    掐拷贝: 创建一个对象, 但是引用还是一个引用
    深拷贝: 创建一个副本, 创建对象, 并创建引用的副本

22. 数组和链表数据结构描述,各自的时间复杂度。
23. error 和 exception 的区别,CheckedException,RuntimeException 的区别。
24. 请列出 5 个运行时异常。
25. 在自己的代码中,如果创建一个 java.lang.String 类,这个类是否可以被类加载器加载?为什么。
26. 说一说你对 java.lang.Object 对象中 hashCode 和 equals 方法的理解。在什么场景 下需要重新实现这两个方法。
27. 在 jdk1.5 中,引入了泛型,泛型的存在是用来解决什么问题。
28. 这样的 a.hashcode() 有什么用,与 a.equals(b)有什么关系。
29. 有没有可能 2 个不相等的对象有相同的 hashcode。
30. Java 中的 HashSet 内部是如何工作的。
31. 什么是序列化,怎么序列化,为什么序列化,反序列化会遇到什么问题,如何解决。 32. java8 的新特性。





