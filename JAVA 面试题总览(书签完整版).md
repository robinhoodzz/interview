https://blog.csdn.net/qq_35661171/article/details/80181192


### JAVA基础

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

?16. 为什么CGlib方式可以对接口实现代理。

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

19. 如何在父类中为子类自动完成所有的 hashcode 和 equals 实现*?*这么做有何优劣。


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
    数组:
        连续存储
        随机访问
        从栈中分配空间
        需要初始分配长度

    链表:
        在开辟内存紧张时, 有效利用内存碎片空间
        从堆中分配空间

        存取方式    存储位置    存储空间    查找      插入/删除           空间分配
    数组  顺序/随机   相邻      密度大     随机访问    平均移动n/2个元素      创建时就要分配
    链表  顺序        不相邻    密度小     顺序访问   修改指针即可          需要的时候

    https://blog.csdn.net/snow_wu/article/details/53172721




23. error 和 exception 的区别,CheckedException,RuntimeException 的区别。

24. 请列出 5 个运行时异常。
25. 在自己的代码中,如果创建一个 java.lang.String 类,这个类是否可以被类加载器加载?为什么。
    不可以
    类加载的双亲委托模型
    BootstrapClassLoader    rt.jat
    ExtensionClassLoader    ext/lib/*.jar
    APPClassLoader          CLASSPATH

    即使自定义类加载器, 最终会到BootStrapClassLoader, 因为rt.jar里有java.lang.String类,并且已经被加载
    会抛出SecurityException

    http://www.cnblogs.com/jasonstorm/p/5663864.html

26. 说一说你对 java.lang.Object 对象中 hashCode 和 equals 方法的理解。在什么场景 下需要重新实现这两个方法。
    如果 两个对象 equals 为true, ashCode必须相等
    对象需要在在集合里操作的时候, 需要重写

27. 在 jdk1.5 中,引入了泛型,泛型的存在是用来解决什么问题。
    泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数，泛型的好处是在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的，以提高代码的重用率

28. 这样的 x.hashcode() 有什么用,与 x.equals(b)有什么关系。
    HashCode
        用一个数字来标识一个对象
        HashCode方提供了对象的HashCode值, 是一个native方法, 返回的默认值与System.identityHashCode(obj)一致
        通常这个值是对象头部的一部分二进制位组成的数字, 具有一定的标识对象的意义, 但对不等于地址
        
    equals
        equals相等则hashCode一定相等, hashCode相等的对象, 不一定equals相等
    

29. 有没有可能 2 个不相等的对象有相同的 hashcode。
    有, HashCode不一定是唯一的.
    原因: 因为HashCode的长度是固定的, 所以有可能产生Hash碰撞
    
    
30. Java 中的 HashSet 内部是如何工作的。
    底层基于HashMap实现, 底层采用HashMap来保存元素.
    初始容量大小 initial capacity为16, 负载因子 load factor是0.75
    
    
31. 什么是序列化,怎么序列化,为什么序列化,反序列化会遇到什么问题,如何解决。
    Serialization 是将对象的状态信息转换为可以存储或传输的形式
    JVM停止后, 对象就会丢失, 所以序列化是一种途径来保持对象(类似持久化)
    
    实现Serializiable接口, 也就是该类被标记为可以序列化
    
    SerialVersionUID如果对不上, 则序列化后的数据 被 反序列化会报错
    
    
    
 
32. java8 的新特性。



### JVM 知识
1. 什么情况下会发生栈内存溢出
    如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverflowError异常。 
    如果虚拟机在动态扩展栈时无法申请到足够的内存空间，则抛出OutOfMemoryError异常。
    
    Java内存区域
    
        线程共享
            堆
            方法区
        
        线程独享
            本地方法栈
            虚拟机栈
            程序计数器
            
    程序计数器
        无内存溢出异常 OOM(out of memory)
        当前字节码行号指示器
        控制分支,跳转,循环
        线程私有
    
    虚拟机栈
        方法被执行的时候都会创建一个栈帧(栈中的一个元素)
        栈帧存储 局部变量表, 操作数栈, 动态链接, 方法返回地址等
        栈帧需要多少内存, 不受RunTime影响
        
        局部变量表
            是一个变量存储空间
            编译器可知的: 基本数据类型, 对象引用, 返回地址类型
        操作数栈
            加操作、赋值元算等
        动态链接
            运行期间转化为直接引用，这部分称为动态连接
        方法返回地址
            方法执行完2种退出方式:
                方法返回到调用处
                    调用者的程序计数器的值,保存在此
                异常
                    异常处理器

    本地方法栈
        与 虚拟机栈类似, 执行native方法

    java堆
        对象实例
        数组
        垃圾回收区域
    
    方法区
        永久代
        HotSpot没有永久代的概念
        常量池
        虚拟机加载的类, 常量, 静态变量, 编译后的代码
        
    内存溢出
        Java堆
            无限循环new对象,放入list,以不被垃圾回收
        方法区
            生成动态类, 或者调用String类型的intern()方法产生不同的String对象, 并存入list
            前者测试常量池, 后者测试方法区中非常量池的部分
            
        虚拟机栈 & 本地方法栈
            StackOverFlowError:     递归调用一个简单的方法,没有退出条件或条件不满足
            OutOfMemoryException:   无线循环创建线程

    内存泄漏
        内存泄露是指分配出去的内存没有被回收回来，由于失去了对该内存区域的控制，因而造成了资源的浪费
        
        
    http://wiki.jikexueyuan.com/project/java-vm/storage.html
    
        
        
        
        

2. JVM 的内存结构，Eden 和 Survivor 比例
    eden 和 survior 是按8比1分配的 
    
    为什么要分代:
    其实不分代完全可以，分代的唯一理由就是优化GC性能
    很多对象生存时间很短, 新生对象很少引用生存时间长的对象
    
    那我们所有的对象都在一块, GC的时候我们要找到哪些对象没用，这样就会对堆的所有区域进行扫描
    年轻代分3个区: 
        Eden区               比例:8
        Survivor from区      比例:1
        Survivor to区        比例:1

    因为年轻代的对象都是朝生夕死的, 所以年轻代的垃圾回收算法是复制算法. 内存氛围2块,当这一块内存用完, 就将或者的对象复制到另一块上面
    这就是 from区 和 to区
    
    GC开始时, 对象存在于Eden区和from区, to区是空的. 
        个人理解: 初始化的对象在eden,这没问题,对象是如何进入from, to为何是空的
            GC时, 存活对象从eden进入to,存活的从from进入to, 达到一定年龄的去老年代, 每GC一次,年龄就增加1
            GC后, eden和from被清空, 此时, from和to互换角色, 不论怎么样,都保证survivor的to区是空的
            当to区满时, 将所有对象移动到老年代
        
    https://blog.csdn.net/lojze_ly/article/details/49456255

3. jvm 中一次完整的 GC 流程是怎样的，对象如何晋升到老年代，说说你知道的几种主要的jvm 参数。
    GC分为minor GC, full GC
        minorGC
            1. 原因: eden空间不足
            2. 目的: 清空eden+from所有no ref的对象占用的内存,
            3. 做法: copy到to区, 一些对象晋升到old区(to放不下的且存活次数超过turning threshold)
        full GC
            1. 原因: old空间不足,perm空间不足, 显示调用了System.GC()
            2. 目的: 清空整个heap中no ref对象, 和permgen永久代中已经被卸载的classloader中记载的class信息
            3. 做法: 同2
    重要参数:
        -XX:newSize         指定初始新生代大小
        -XX:maxNewSize      指定最大新生代大小       -XX:MaxNewSize 最大可以设置为-Xmx/2
        -XX:newRatio        设置新生代和老年代的相对大小  =3 指定老年代/新生代为3/1
        -XX:survivorRatio   =10 表示伊甸园区(Eden)是 幸存区To 大小的10倍
        
        
    
?4. 你知道哪几种垃圾收集器，各自的优缺点，重点讲下 cms，包括原理，流程，优缺点
    Serial、parNew、ParallelScavenge、SerialOld、ParallelOld、CMS、G1 
    
    serial收集器
        新生代, 复制算法, 单线程, 暂停其他所有线程(stop the world)
    parNew收集器
        serial的多线程版本
        两者都能与CMS（concurrent mark sweep）收集器配合使用；三者都关注尽可能缩短垃圾收集时用户线程的停顿时间。
    Parallel Scavenges收集器
        新生代, 复制算法, 多线程, 吞吐量
    Serial Old收集器
        老年代
        单线程
        标记-整理算法
    Parallel Old收集器
        老年代
        多线程
        标记-整理算法
    CMS(concurrent mark sweep)
        最短停顿时间为目标的收集器
        标记-清除
        无法处理浮动垃圾
        会有大量空间碎片产生
    G1
        基于复制算法
        不产生空间碎片
        
    CMS收集器（Mark Sweep :标记-清除 算法）：一种以获取最短回收停顿时间为目标的收集器。目前很大一部分的Java应用集中在互联网站或者B/S系统的服务端上.
    
    https://wangkang007.gitbooks.io/jvm/content/chapter1.html

?5. 你知道哪几种垃圾收集器，各自的优缺点，重点讲下 cms 和 G1，包括原理，流程，优缺点。
    https://wangkang007.gitbooks.io/jvm/content/chapter1.html

?6. 垃圾回收算法的实现原理。
    http://www.importnew.com/13493.html

?7. 当出现了内存溢出，你怎么排错。
    首先分析是什么类型的内存溢出，对应的调整参数或者优化代码。 
    https://wangkang007.gitbooks.io/jvm/content/4jvmdiao_you.html

?8. JVM 内存模型的相关知识了解多少，比如重排序，内存屏障，happen-before，主内存，工作内存
    内存屏障：为了保障执行顺序和可见性的一条cpu指令
    重排序：为了提高性能，编译器和处理器会对执行进行重拍 
    happen-before：操作间执行的顺序关系。有些操作先发生。 
    主内存：共享变量存储的区域即是主内存 
    工作内存：每个线程copy的本地内存，存储了该线程以读/写共享变量的副本 
    http://ifeve.com/java-memory-model-1/ 
    http://www.jianshu.com/p/d3fda02d4cae 
    http://blog.csdn.net/kenzyq/article/details/50918457

9. 简单说说你了解的类加载器。
    类加载器的分类（bootstrap,ext,app,curstom），类加载的流程(load-link-init)
    
    加载
        加载字节码数据到内存
    验证
        加载类的正确性
    准备
        为静态变量分配内存. 赋0值
    解析
        符号引用 转为 直接引用
    初始化
        为类的静态变量赋予正确的值
        
    初始化触发条件
        new一个对象
        访问某个类或接口的静态变量
        调用类的静态方法
        发射 Class.forName("com.xxx");
        初始化一个类的子类, 父类也会被初始化
        JVM启动时标明的启动类

    https://blog.csdn.net/gjanyanlig/article/details/6818655/
    

10. 讲讲 JAVA 的反射机制。
    Java程序在运行状态可以动态的获取类的所有属性和方法，并实例化该类，调用方法的功能
    
?11. 你们线上应用的 JVM 参数有哪些。


12. g1 和 cms 区别,吞吐量优先和响应优先的垃圾收集器选择。

    Cms是以获取最短回收停顿时间为目标的收集器。基于标记-清除算法实现。比较占用cpu资源，切易造成碎片。 
    G1是面向服务端的垃圾收集器，是jdk9默认的收集器，基于标记-整理算法实现。可利用多核、多cpu，保留分代，实现可预测停顿，可控。 
    http://blog.csdn.net/linhu007/article/details/48897597 

?13. 怎么打出线程栈信
    1, 多线程打印? https://blog.csdn.net/hello_worldee/article/details/77824025
    2, jstack      http://www.cnblogs.com/zhuqq/p/5938187.html 

14. 请解释如下 jvm 参数的含义
    -server                                     服务器模式
    -Xms512m                                    初始堆空间
    -Xmx512m                                    最大堆空间
    -Xss1024K                                   栈空间
    -XX:PermSize=256m                           初始永久带空间
    -XX:MaxPermSize=512m                        最大永久带空间
    -XX:MaxTenuringThreshold=20                 对象的生命周期
    -XX:CMSInitiatingOccupancyFraction=80       老年代的内存在使用到70%的时候，就开始启用CMS
    -XX:+UseCMSInitiatingOccupancyOnly          按照你设置的比率来启用CMS GC
    -XX:NewSize                                 用于设置年轻带的大小，建议设为整个堆大小的1/3或1/4，两个值(和下面)设为一样大
    -XX:MaxNewSize                              最大年轻代的大小
    -XX:+SurvivorRatio                          用于设置Eden和其中一个Survivor的比值。这个值也比较重要
    -XX:++PrintTenuringDistribution             用于显示每次Minor Gc是Survivor区中个年龄段的对象的大小
    -XX:InitialTenuringThreshold                用于设置晋升到老年代的对象年龄的最小值和最大值，每个对象在坚持过一次Minor Gc之后，年龄就加1
    -XX:MaxTenuringThreshold                    最大
    


### 开源框架知识

    
### 操作系统

### 多线程

1. 多线程的几种实现方式,什么是线程安全。
    不算线程池的话, 3种
    1. 实现 Runnalbe接口
    2. 继承 Thread类
    3. 实现 Callable接口

    进程 & 线程区别
        进程: 独立的运行环境, 被看做是一个程序和应用
        线程: 是进程中的一个任务
    存在意义
        提高程序执行效率
        共享堆内存

    线程安全
        线程安全是: 线程安全的代码,在多个线程同时执行也能工作的代码, 且保证多线程时, 正确的操作共享数据.


2. volatile 的原理,作用,能代替锁么。
    volatile利用内存的栅栏机制来保持变量的一致性. 不能代替锁, 其只具备数据可见性一致性, 不具备原子性

3. 画一个线程的生命周期状态图。

    状态
        1.初始 new: 新创建了一个线程对象, 但是还没有调用start()方法
        2.运行 runnable: java线程中将就绪(ready)和运行中(running)两种状态笼统称为"运行"
                       线程对象创建后, 其他线程()调用了该对象的start()方法.
                        该状态的线程位于可运行的线程池中, 等待线程调度的选中, 获取CPU的使用权,此时处于ready状态
        3.阻塞 block: 表示线程阻塞于锁
        4.等待 waiting: 进入该状态的线程需要等待其他线程做出特定的动作(通知或中断)
        5.超时等待 timed_waiting: 该状态不同于waiting, 它可以在指定的时间后自行返回
        6.终止 terminated: 表示该线程已经执行完毕

    状态变更
        1. 初始状态
            实现Runnable接口/继承Thread类/实现Callable接口(基于线程池) new一个实例出来, 线程就进入了初始状态
        2.1. 就绪状态
            1. (重要)就绪状态只是说你资格运行, 调度程序没有挑选到你, 你就永远是就绪状态
            2. (重要)调用线程的start()方法, 次线程进入[就绪状态]
            3. 当线程sleep()方法结束, 其他线程join()结束, 等待用户输入完毕, 某个线程拿到锁对象, 线程将进入[就绪状态]
            4. 当前线程时间片用完了, 调用当前线程的yield()方法, 当前线程进入就绪状态
            5. 锁池里的线程拿到对象锁后, 就进入[就绪状态]

        2.2 运行状态
            线程调度程序从可运行池中选择一个线程作为当前线程所处的状态. 这是线程进入运行状态的唯一方式

        3. 阻塞状态
            线程在进入synchronized方法/代码块, 获取锁的状态
        4. 等待
            不会被分配CPU资源, 除非显示地唤醒, 否则永远处于无限期等待状态
        5. 超时等待
            不会被分配CPU资源, 达到一定时间后, 自动唤醒
        6. 终止状态
            1. 当线程run()方法执行完后, 或者主线程main()方法完成时, 我们认为它就终止了.
            2. 在终止的线程上调用start()方法

4. sleep 和 wait 的区别。
    sleep: 线程进入timed_waiting状态, 到达执行时间后, 会恢复成ready状态, 等待调度选中从而进入running状态
    wait:  线程进入waiting状态, 在没有被显示调用 该线程.notify() 或者 notifyAll()方法前, 将一直处于waiting状态, 不会执行

    sleep:  休眠线程    静态方法    依旧持有锁   指定时间自动唤醒
    wait:   等待     object方法    释放锁      不会自动唤醒

5. sleep 和 sleep(0)的区别。
    sleep(0) 并非真的要线程挂起0毫秒, 意义在于让线程放弃cpu资源, 释放一些未用的时间片给其他线程或进程使用. 相当于让位操作


6. Lock 与 Synchronized 的区别。
    相同点: 都保证了在高并发下的原子性和可见性

    synchronized 释放锁交给自身控制, 且某些互斥场景不符合逻辑, 无法进行干预, 不可人为中断
    lock有ReentrantLock和readwritelock两者, 添加了类似锁投票, 定时锁等候,和可中断锁等候的一些特性. 此外在激烈静态下的更佳性能

?7. synchronized 的原理是什么,一般用在什么地方(比如加在静态方法和非静态方法的区别,
        静态方法和非静态方法同时执行的时候会有影响吗)解释以下名词:重排序,自旋锁,偏向锁,轻量级锁,可重入锁,公平锁,非公平锁,乐观锁,悲观锁。

    synchronized 的原理

        反编译后
        3: monitorenter (重点)
        4: getstatic
        5: ldc
        6: monitorexit (重点)

        monitorenter:
        每个对象有一个监视器锁. 当monitor被占用时就会处于锁定状态, 线程执行monitorenter指令时会尝试获取monitor的所有权, 过程如下:
        1. 如果monitor的进入数为0, 则该线程进入monitor, 然后将进入设置数设置为1. 该线程为monitor的所有者
        2. 如果线程已经占有该monitor, 只是重新进入, 则进入monitor的进入数加1.
        3. 如果其他线程已经占有该monitor,则该线程进入阻塞状态, 直到monitor的进入数为0, 才能再次获取monitor的所有权

        monitorexit:
        执行monitorexit的线程必须是monitor的所有者
        执行指令时, monitor的进入数减1, 如果减1后进入数为0, 那线程退出monitor, 不再是这个monitor的所有者

        所以 Synchronized关键字的原理是: 通过一个monitor的对象来完成, wait/notify等方法也是依赖于monitor对象,
            这就是为什么只有在synchronized方法或代码块中才能调用wait/notify方法, 否则抛出IllegalMonitorStateException异常

    自旋锁
        当一个线程在获取锁时, 如果锁被其他线程持有, 那么该线程就会循环判断是否成功获取锁, 直到成功获取锁后, 退出循环
        https://blog.csdn.net/qq_34337272/article/details/81252853



    synchronized修饰不加static的方法，锁是加在单个对象上，不同的对象没有竞争关系；
    修饰加了static的方法，锁是加载类上，这个类所有的对象竞争一把锁。
    (https://www.cnblogs.com/guiqulai/articles/7342006.html)

    https://blog.csdn.net/kirito_j/article/details/79201213#t3
    https://blog.csdn.net/a314773862/article/details/54095819



8. 用过哪些原子类,他们的原理是什么。
    AtomicInteger, AtomicLong, AtomicReference, AtomicBoolean
    基于CAS原语实现, 比较并交换, 最坏情况下是旋转锁()

?9. JUC 下研究过哪些并发工具,讲讲原理。

10. 用过线程池吗,如果用过,请说明原理,并说说 newCache 和 newFixed 有什么区别,构造函数的各个参数的含义是什么,比如 coreSize,maxsize 等。

        newSingleThreadExecutor
            返回一个包含单线程的Executor, 将多个任务交给此Executor时,
            这个线程处理完一个任务后接着处理下一个任务
            若该线程出现异常, 将会有一个新的线程来替代
        newFixThreadPool
            返回一个包含指定数目线程的线程池, 如果任务数量多于线程数目,
            那么没有执行的线程必须等待, 直到有任务执行完为止
        newCachedThreadPool
            根据用户的任务数创建相应的线程来处理, 该线程池不会对线程数目加以限制, 完全依赖于JVM能创建线程数的数量, 可能引起内存不足



        coreSize 核心线程数
        maxSize  最大线程数








