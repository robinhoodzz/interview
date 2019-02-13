https://blog.csdn.net/qq_35661171/article/details/80181192
https://hk029.gitbooks.io/leetbook/twopoint.html

https://mp.weixin.qq.com/s/-O_aBOj1E3p1X2jwlB9lHA

### JAVA基础

1. JAVA 中的几种基本数据类型是什么,各自占用多少字节。
    1 bit: 二进制的一个数  位
    1 Byte = 8 bit       字节
    1 KB = 1024 Byte     K
    1 MB = 1024 KB       M

    boolean 1bit
    byte    8bit
    short   16bit
    char    16bit
    int     32bit   4Byte
    float   32bit
    long    64bit
    double  64bit

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
        底层C和汇编 先判断是否多核, 如果多核加锁, 锁的是总线, 使得其他CPU内核无法通过总线访问内存(op::isMulitCore)
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
    
    https://www.cnblogs.com/doit8791/p/7461479.html

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
    当Bean没有实现接口时, Spring使用CGlib代理

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
    如果 两个对象 equals 为true, hashCode必须相等
    对象需要在在集合里操作的时候, 需要重写

27. 在 jdk1.5 中,引入了泛型,泛型的存在是用来解决什么问题。
    泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数，泛型的好处是在编译的时候检查类型安全，并且所有的强制转换都是自动和隐式的，以提高代码的重用率

28. 这样的 a.hashcode() 有什么用,与 a.equals(b)有什么关系。
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
?1. 简单讲讲 tomcat 结构，以及其类加载器流程，线程模型
    Server服务器
        Service服务(1:N|server:service)
            Container(1:1|service:container)
            Connector(1:N|container:connector)

    Service服务
        是对Container和Connector的包装和维护
            其中有setContainer()方法和addConnector()方法, 说明Container和Connector是一对多关系
        控制组件(Container和Connector的生命周期)
        
    Server服务器
        提供接口让程序访问
    
    Connector组件(2大核心组件之一)
        负责接受浏览器的tcp请求, 创建一个Request和Response对象
        产生一个线程, 来处理这个请求, 并把Request和Response对象传给这个请求的线程
        处理请求的线程是Container来做
    
    类加载: 与JVM不同, tomcat有自己一套加载机制,但基本满足双亲委派模型
        Bootstrap加载器
            加载JVM所需的类, 和jre/lib/ext下的类
        System加载器
            Tomcat启动的类, 如bootstrap.jar, 通常在catalina.sh中指定, 在CATALINA_HOME/bin下
        Common通用加载器
            加载Tomcat所需要的类, 在CATALINA_HOME/lib下, 如servlet-api.jar
        Webapp应用加载器
            在WEB-INF/lib 和 WEB-INF/classes下

    https://www.ibm.com/developerworks/cn/java/j-lo-tomcat1/
    http://www.cnblogs.com/xing901022/p/4574961.html
    https://www.jianshu.com/p/62ec977996df

?2. tomcat 如何调优，涉及哪些参数。
    硬件, 操作系统, 版本, jdk, jvm参数, 配置connector的线程数量,开启gzip压缩, trimSpaces, 集群等
    JVM参数如
        export JAVA_OPTS="-server -Xms1400M -Xmx1400M -Xss512k -XX:+AggressiveOpts -XX:+UseBiasedLocking -XX:PermSize=128M -XX:MaxPermSize=256M -XX:+DisableExplicitGC -XX:MaxTenuringThreshold=31 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC  -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m  -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -Djava.awt.headless=true "
        -server     默认Tomcat是用client启动, server意味着是在生产环境下运行
        -Xmx -Xms   堆内存设置, Xmx为最大, 这两个设置为一样的值, 有助于减少JVM动态分配时所消耗的资源, 面对高并发时容易卡
                    通过java -Xmx1610M -version 可以知道JVM最大能接受多少内存的分配
        -Xmn        年轻代为512M, 因为整个堆=年轻代+老年代+持久代, 持久代是64M, 年轻代增大后, 将会减少老年代的大小, 年轻代为整个堆的3/8
        -Xss        每个线程的堆大小, 一般不宜超过1M
        -XX:PermSize    设置非堆内存, 默认是物理内存的1/64
        -XX:MaxPermSize    设置最大非堆内存, 默认是物理内存的1/4
        -XX:UseParNewGc    对年轻代使用并行回收, 效率高
        
        https://blog.csdn.net/lifetragedy/article/details/7708724
        
        
?3. 讲讲 Spring 加载流程。
    核心组件
        Bean
        Context
        Core
    Bean    Bean的定义,Bean的创建, Bean的解析
    Context 标识一个应用的环境
            利用BeanFactory创建Bean对象
            保存对象关系映射
            捕获各种事件
    Core    对资源提供者进行同一封装
    
    IOC容器如何工作
        构建BeanFactory, 以便生产Bean
        注册事件
        创建Bean实例对象

    https://blog.csdn.net/qq_31582127/article/details/85228169

        
4. 讲讲 Spring 事务的传播属性。
    7种
    REQUIRED            如果当前存在事务,则加入该事务,否则创建一个新的事务
    REQUIRES_NEW        创建新的事务,如果当前事务存在,则挂起当前事务
    SUPPORTS            如果当前存在事务,则加入,否则以非事务方式运行
    NOT_SUPPORTS        以非事务方式运行, 如果当前存在事务,则挂起当前事务
    NEVER               以非事务方式运行, 如果当前存在事务, 则抛出异常
    MANDATORY           如果当前存在事务,则加入该事务,否则抛出异常
    NESTED              如果当前存在事务,则创建一个新的事务作为当前事务的嵌套事务来运行, 如果当前没有事务, 创建新的事务
    

            
5. Spring 如何管理事务
    3个接口
    PlatformTransactionManager  事务管理器
        事务管理, commit(), rollback(), getTransaction()
    TransactionDefinition       事务定义信息
        获取隔离级别 getIsolationLevel()
        获取传播机制 getPropagationBehaivor()
        
    TransactionStatus           事务运行状态
        是否有保存点  hasSavePoint()
        是否完成      isComplete()
        
6. Spring 怎么配置事务（具体说出一些关键的 xml 元素
    2种
    1. 基于XML的事务配置
    2. 基于注解的事务配置
        事务通过AOP方式实现
        
7. 说说你对Spring的理解，非单例注入的原理？它的生命周期？循环注入的原理，aop的实现原理，说说aop中的几个术语，它们是怎么相互工作的。
    IOC
    AOP
    
    非单例注入原理
        大部分情况下,bean都是singleton的.
   

    
            
8. Springmvc 中 DispatcherServlet 初始化过程。
    
9. netty 的线程模型 netty 的线程模型 netty 如何基于 reactor 模型上实现的

    http://www.sohu.com/a/272879207_463994
    https://blog.csdn.net/bjweimengshu/article/details/78786315
    https://blog.csdn.net/baiye_xing/article/details/76735113
    https://www.w3cschool.cn/essential_netty_in_action/essential_netty_in_action-2gtp289u.html
    
    ** https://www.jianshu.com/p/a4e03835921a

    epoll
    https://blog.csdn.net/tom555cat/article/details/24870469
    https://www.jianshu.com/p/41dc33b97419
    
    Netty架构组件
        Bootstrap ServerBootstrap
        Channel
        ChannelHandler
        ChannelPipline
        EventLoop
        ChannelFuture
    
        BootStrap       netty的引导类, 提供应用网络层配置的容器
        Channel         底层网络传输API
        ChannelHandler  数据处理的容器, 基于事件模型, 业务常用的是ChannelInboundHandler
        ChannelPipline  
        EventLoop       用于处理Channel的IO操作
        

10. netty 的 hashwheeltimer 的用法，实现原理，是否出现过调用不够准时，怎么解决。
    https://segmentfault.com/a/1190000010987765
    https://www.cnblogs.com/zemliu/p/3928285.html
    https://www.cnblogs.com/eryuan/p/7955677.html

11. netty 的心跳处理在弱网下怎么办。
    思路:
        一旦发生故障/超时, 立即关闭链路, 主动重连
        1. 当网络处于空闲状态, 持续时间达到T(一个周期), 客户端主动发送ping心跳消息给服务端
        2. 如果T+1(下一个周期), 客户端没有收到对方发送的pong心跳应答消息或者其他业务读写, 则心跳失败计数器+1
        3. 每当客户端接收到服务的业务消息或者pong应答消息时, 将心跳计数器清零. 连续N次没有收到pong消息后, 关闭链路, 间隔INTERVAL时间后发起重连
        
        4. 服务端, 空闲状态持续时间达到T后, 服务端心跳失败计数器+1, 只要收到客户端的ping消息或者其他业务消息, 计数器清零
        5. 服务端连续N次没有收到客户端的ping消息或者其他业务消息, 则关闭链路, 释放资源, 等待客户端重连
        通过ping-pong双向心跳机制, 可以保证无论通信那一方出现网络故障, 都能及时的检测出来. 为了防止误判, 只有连续N次心跳检测失败, 才认定链路异常, 需要关闭重连
        读或写心跳消息发生I/O异常时, 说明链路已经中断. 此时需要立即关闭链路, 
            客户端: 需要重新发起链接
            服务端: 需要清空缓冲区的半包信息, 等待客户端重连

    netty实验中出现的问题
        1. 使用websocket基于tcp的长连接通信协议. 在2台电脑上, 一台服务端S,一台客户端C. 在连接建立之后, C端的WIFI断掉(断网), S端是感知不到handlerRemove事件的
        2. 所以需要心跳机制, 来监控, 并在超时后, 断开连接.
            因为没有TCP的四次挥手


12. netty 的通讯协议是什么样的。

13. springmvc 用到的注解，作用是什么，原理。

14. springboot 启动机制
        
            
            

    
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
    ?自旋锁
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
    java.util.concurrent包 简称JUC
    Tools包含了5部分知识(5个工具类)
        Executors
        Semaphore
        Exchanger
        CyclicBarrier
        CountDownLatch
        Executors
            工具类, 提供静态方法, 用于创建对应的线程池
        Semaphore(信号量)
            根据一些阈值做访问控制
        Exchanger
            线程之间传递数据的中间步骤
        CyclicBarrier(关卡模式)
            等所有线程到达后, 再往下走, 个人理解是削峰处理的取反
        CountDownLatch
            计数器




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


11. 线程池的关闭方式有几种,各自的区别是什么。
    Shutdown, shutdownNow, try Terminate, 清空工作队列, 终止线程池中各个线程, 销毁线程池

12. 假如有一个第三方接口,有很多个线程去调用获取数据,现在规定每秒钟最多有 10 个线程同时调用它,如何做到。
    ScheduledThreadPoolExecutor(10) 设置定时, 进行调度, 其中10为线程数

        public ScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
            super(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS, new DelayedWorkQueue(), threadFactory);
        }
    它用的是DelayedWorkQueue, 是一个等待队列



    https://blog.csdn.net/xieyuooo/article/details/8572543

13. spring 的 controller 是单例还是多例，怎么保证并发的安全。
    单例
    通过工厂 DefaultSingletonBeanFactory实现单例
    通过 AsyncTaskExecutor保持安全 ?
    有问题?
        Spring作为容器, 只负责创建对象, 给对象的属性赋值, MVC分发请求, 线程是否安全与容器关系不大
        因为Controller是单例(默认单例除非用@Scope("prototype")指定), 如果不小心类中有成员变量, 那么这个变量是被所有请求共享的
        如果加上@Scope("prototype")可以解决成员变量共享的问题, 因为每次都new, 但是效率降低了
        其他办法: ThreadLocal, 将成员变量保存在线程的变量域中, 让不同请求隔离

14. 用三个线程按顺序循环打印 abc 三个字母,比如 abcabcabc。
    可利用AtomicInteger
    https://mouselearnjava.iteye.com/blog/1949228
    信号量
    https://blog.csdn.net/hanchao5272/article/details/79780045


15. ThreadLocal 用过么,用途是什么,原理是什么,用的时候要注意什么。
    ThreadLocal底层是通过threadLocalMap进行存储键值,
        每个ThreadLocal类创建一个Map, 然后用线程ID作为Map的Key, 实例对象作为Map的value, 以达到线程隔离的效果


16. 如果让你实现一个并发安全的链表，你会怎么做。
    Collections.synchronizedList() ConcurrentLinkedQueue

    多线程环境下, 并发安全的链表实现方式有2种
    1. 锁住整个表(性能差)
    2. 使用交替锁(hand-over-hand locking), 只锁住表的一部分, 链表没有锁住的部分自由访问
        实现原理: 将待插入位置两边节点加锁
        1. 锁住链表的前2个节点
        2. 如果这2个节点不是待插入位置, 解锁第一个节点, 锁住第三个节点
        3. 如果这2个节点仍然不是待插入位置, 解锁第二个, 锁住第四个
        4. 直到找到待插入的位置, 插入后, 解锁两边节点



17. 有哪些无锁数据结构,他们实现的原理是什么。
    LockFree, CAS
    基于JDK提供的原子类原语实现, 例如AtomicReference

18. 讲讲 java 同步机制的 wait 和 notify。
    这2个方法只能在同步代码块中使用, wait会释放掉对象的锁, 等待noitfy唤醒

19. 多线程如果线程挂住了怎么办。
    根据具体情况（sleep,wait,join等），酌情选择notifyAll，notify进行线程唤醒。

20. countdowlatch 和 cyclicbarrier 的内部原理和用法，以及相互之间的差别。
    CountDownLatch是一个辅助类, 在完成一组正在其他线程中执行的操作之前, 他运行一个或者多个线程一直处于等待状态
    CyclicBarrier要做的是, 让一组线程达到一个屏障, 直到最后一个线程达到屏障后, 屏障才会开门, 让所有的线程继续运行
        CycliBarrier初始化的时候, 设置一个屏障数. 线程调用await()方法的时候, 线程就会阻塞, 调用await()线程数==初始设置的数字后
        主线程会取消所有被阻塞的线程的状态

    CountDownLatch是递减, 不可循环
    CyclicBarrier是递增, 可循环用

    https://blog.csdn.net/tolcf/article/details/50925145
    https://www.jianshu.com/p/a101ae9797e3


?21. 对 AbstractQueuedSynchronizer 了解多少,讲讲加锁和解锁的流程,独占锁和公平所加锁有什么不同。


22. 使用 synchronized 修饰静态方法和非静态方法有什么区别。
    对象锁 和 类锁

23. 简述 ConcurrentLinkedQueue 和 LinkedBlockingQueue 的用处和不同之处。
    LinkedBlockingQueue是一个基于单链表的, 任意范围的, FIFO阻塞队列
    ConcurrentLinkedQueue是一个基于连接节点的无界线程安全队列, 它采用FIFO的规则对节点进行排序,
        当我们添加一个元素的时候, 他会添加到队列的尾部, 当我们获取一个元素时, 它会返回队列头部元素
        采用wait-free算法实现

        wait-free & lock-free比较
        https://blog.csdn.net/zhangxinrun/article/details/7103190

24. 导致线程死锁的原因?怎么解除线程死锁。
    线程间相互等待资源, 而又不释放资源, 导致无情无尽的等待.
    死锁出现的条件:
        1. 互斥条件: 一个资源每次只能被一个线程使用
        2. 请求与保持条件: 一个进程因请求资源而阻塞时, 对获得的资源保持不放
        3. 不剥夺条件:
        4. 循环等待条件: 若干个进程之间形成一种头尾相接的循环等待资源关系
        只要破坏4个中的1个, 死锁就能解决


25. 非常多个线程(可能是不同机器),相互之间需要等待协调,才能完成某种工作,问怎么设计这种协调方案。
    队列

?26. 用过读写锁吗,原理是什么,一般在什么场景下用。
    是一种自旋锁, 把访问对象分为读者,写者.

?27. 开启多个线程,如果保证顺序执行,有哪几种实现方式,或者如何保证多个线程都执行完再拿到结果。

?28. 延迟队列的实现方式,delayQueue 和时间轮算法的异同。


### TCP 与 HTTP
1. http1.0 和 http1.1 有什么区别。
    HTTP 1.1加入了很多重要的性能优化：持久连接、分块编码传输、字节范围请求、增强的缓存机制、传输编码及请求管道。

2. TCP 三次握手和四次挥手的流程,为什么断开连接要 4 次,如果握手只有两次,会出现什么。
    第一次握手
        SYN=1, seq=x
        客户端发送一个TCP的SYN标志位置1的包, 指明客户打算连接服务器的端口, 以及初始序号X, 保存在包头序列号中
        发送完毕后, 客户端进入SYN_SEND状态
    第二次握手
        SYN=1, ACK=1, seq=y, ACKnum=x+1
        服务器返回确认包ACK,即SYN标志和ACK标志均为1. 服务器选择自己的ISN序号放到seq域里, 同时确认序号设置客户的ISN加1,即X+1
        发送完毕后, 服务器端进入SYN_RCVD状态
    第三次握手
        ACK=1, ACKnum=y+1
        客户端再次发送ACK包, SYN标志位为0, ACK标志位为1, 并把服务端发来的ACK序号字段+1
        发送完毕后, 客户端进入established状态, 当服务端接收到这个包后, 也进入establish状态, TCP握手结束

    第一次挥手
        FIN=1, seq=x
        客户端发送一个FIN标志位是1的包, 表示自己没有数据可已发送了, 但可以接收数据
        发送完毕后, 客户端进入FIN_WAIT_1状态
    第二次挥手
        ACK=1, ACKnum=x+1
        服务器确认客户端的FIN包, 发送一个包, 表示自己收到了客户端关闭连接的请求. 但还没准备好关闭.
        发送完毕后, 服务器进入CLOSE_WAIT状态
    第三次挥手
        FIN=1, seq=y
        服务器端准备好关闭连接时, 向客户端发送结束请求, FIN为1
        发送完毕后, 客户端进入LAST_ACK状态, 等待服务端最后一个ACK
    第四次挥手
        ACK=1, ACKnum=y+1
        客户端接收到服务端的关闭请求, 发送一个包确认, 并进入TIME_WAIT状态, 等待可能出现的要求重传ACK包
        服务端收到关闭请求后, 关闭连接, 进入CLOSE状态
        客户端等待了固定时间(2个最大生命周期), 没有收到服务端的ACK, 认为服务端已经正常关闭, 自己也进入CLOSE状态


3. TIME_WAIT 和 CLOSE_WAIT 的区别。
    CLOSE_WAIT 被动关闭
    TIME_WAIT  主动关闭

    TIME_WAIT用来重发可能丢失的ACK

4. 说说你知道的几种 HTTP 响应码,比如 200, 302, 404。
    200 ok 成功
    404 page not found
    302 重定向
    500 服务端错误

5. 当你用浏览器打开一个链接的时候，计算机做了哪些工作步骤。
    DNS解析 -> 端口分析 -> tcp请求 -> 服务器处理请求 -> 服务器响应 -> 浏览器解析 -> 连接关闭

?6. TCP/IP 如何保证可靠性,说说 TCP 头的结构。

7. 如何避免浏览器缓存。
    HTTP头信息包含 cache-controll:no-cache 告诉浏览器不用缓存请求

    经过https加密的请求
    post请求

8. 简述 Http 请求 get 和 post 的区别以及数据包格式。

                        GET                 POST
--------------------------------------------------------------------------------------------
    后退刷新            无害                  数据会重新提交(浏览器也会告知用户, 数据会被重新提交)
    书签               可收藏书签             不能被收藏
    缓存               能被缓存               不能缓存
    编码类型            applicaion/x-www-form-urlencoded    application/x-www-form-urlencode 或 mutipart/form-data
    历史               参数保留在浏览器历史中    参数不会保留在浏览器历史中
    对数据长度的限制    最大2048                无限制
    对数据类型的限制    只允许ASCII码           无限制
    安全性             安全性差,参数在URL中    比GET安全, 参数不会被保存在浏览器
    可见性             数据在URL里可见         数据不在URL


    请求方法 空格 URL 空格 协议版本 回车符 换行符
    头部字段名 : 值 回车符 换行符
    头部字段名 : 值 回车符 换行符
    回车符 换行符


9. 简述 HTTP 请求的报文格式。
    上面

10. HTTPS 的加密方式是什么,讲讲整个加密解密流程。
    加密方式是 tls/ssl, 底层通过对称加密算法,
    客户端发起HTTPS请求 -> 服务端配置 -> 传送证书 -> 客户端解析证书 -> 传送加密信息 -> 服务端解密信息 -> 传输加密的数据 -> 客户端解密



### 架构设计与分布式
1. 常见的缓存策略有哪些，如何做到缓存(比如 redis)与 DB 里的数据一致性，你们项目中到了什么缓存系统，如何设计的。
    Cdn缓存，redis缓存
    Cdn 图片资源 js等， redis缓存业数据
    

2. 用 java 自己实现一个 LRU。
    定义2个类
        LRUCached 主类
            HashMap
            capacity
            head
            tail
        LRUNode   节点
            key
            value
            next
            prev
        主类方法
            set
                IF 从HashMap获取的Node不为空
                    removeNode(因为最终执行setHead方法)
                ELSE(为空的情况)
                    IF 超过capacity
                        remote tail
                    HashMap put这个K V
                最终 setHead()
            get
                IF HashMap获取不为空
                    remove 这个node
                    setHead 这个node
                    返回 这个node的值
                返回 NULL(也就是HashMap获取为空)
            setHead
                IF head是空
                    当前node的next 为 head
                    head的prev为 当前node
            remove
                IF 当前node的prev不等于NULL
                    node的prev的next 为 node的prev
                IF 当前node的next 不等于NULL
                    node的next的prev 为node的prev
                删除HashMap中的key
                
            LRUCached(int)构造
                给capacity 赋值

    LRU类定义成员变量 HashMap
    LRU类定义成员变量 长度
    

    https://www.cnblogs.com/nicky-160330/archive/2018/08/18/9498481.html


3. 分布式集群下如何做到唯一序列号。
    Redis生成，mongodb的objectId，zk生成
    redis:
        INCR或者INCRBY, INCR可以针对单点redis, INCRBY可以针对集群(几个节点, BY几, 如5个节点, 1号机 1-6-11... 2号机 2-7-12...类推) 
        
    ZK:
        因为基于CP理论
        zookeeper主要通过其znode数据版本来生成序列号，可以生成32位和64位的数据版本号，客户端可以使用这个版本号来作为唯一的序列号。
        很少会使用zookeeper来生成唯一ID。主要是由于需要依赖zookeeper，并且是多步调用API，如果在竞争较大的情况下，需要考虑使用分布式锁。
        因此，性能在高并发的分布式环境下，也不甚理想。
    MongoDB
        基于AP理论
        ObjectId格式如下
        
        0123    456     78    91011  
        time    机器    pid   inc
        
        前4个字节, 标准纪元的时间戳,单位秒
        后3个字节, 主机唯一标识符,通常是主机名的散列值(Hash)
        后2个字节, 运行MongoDB进程的ID(进程号)
        后3个字节, 自动增加计数器

    CAP理论
        Consistency         一致性
            写之后读, 必须返回该值. (读写一致性)
        Availability        可用性
            只要收到用户请求, 服务器必须给出回应
        Partiton toleronce  分区容错
            子网叫做区(如中国机房,美国机房). 区间通信可能失败
            一般来说分区容错不可避免,所以分布式系统P是必须要有的, 主要C和A无法同时做到
            
        C和A不可调和?
            因为通信可能失败, 所以一致性和可用性矛盾
                如果保证1号机,2号机一致性, 那么在写1号机时, 要锁定2号机的读.
                只有数据同步时, 才能重新开放读写, 锁定期间G2不能读写, 没有可用性A
                
    http://www.cnblogs.com/haoxinyue/p/5208136.html
                

4. 设计一个秒杀系统，30 分钟没付款就自动关闭交易。

    考虑: 分流-限流-异步-公平性(只参加一次如果需要的话)-用户体验(排位,多少分钟,已抢完)
    
    2种情况
    1. 先占坑后付款
    2. 先付款后占坑(或付款和占坑同时, 如P2P)
    
    1. 先坑后付
        0. 预先把库存值放入redis
        1. 校验库存, 通过后decr, 调用decr返回后, 再校验一次, 成功后放入队列(用户显示排位), 在放入一个延时队列(到期未付,取消订单,加库存)
        2. 返回客户端成功/失败
        3. 延迟队列, 可以先计算出失效的具体时间T, 然后json数据放入队列中, 每分钟遍历一次队列, 找出 T < MOW的, 然后进行异步处理
            异步处理: 如果已经支付,则return; 否则关闭订单, 并增加库存, 通知用户
        
    2. 先付后坑(或同时)
        设计为异步的方式, 
            1. 先校验库存:    先从redis获取值A对比库存值B, 再用redis的INCR, 如果A<=B,返回处理中, 并进入队列, 否则返回库存不足(不保证所有用户状态准确,第3步骤保证) 
            2. 同步返回       返回处理中 或 库存不足
            3. 队列异步处理   单线程一个一个处理, 先判断库存(当前购买数量+已经成功数据<=库存?), 通过后, 异步通知用户购买成功, 否则告知失败 
            4. 异步通知客户端 
                
    
5. 如何使用 redis 和 zookeeper 实现分布式锁？有什么区别优缺点，会有什么问题，分别适用什么场景。（延伸：如果知道 redlock，讲讲他的算法实现，争议在哪里）
6. 如果有人恶意创建非法连接，怎么解决。
7. 分布式事务的原理，优缺点，如何使用分布式事务，2pc 3pc 的区别，解决了哪些问题，还有哪些问题没解决，如何解决，你自己项目里涉及到分布式事务是怎么处理的。
8. 什么是一致性 hash。
9. 什么是 restful，讲讲你理解的 restful。
10. 如何设计建立和保持 100w 的长连接。

11. 如何防止缓存击穿和雪崩
    缓存雪崩可能是因为数据未加载到缓存中, 或者缓存同一时间大面积失效, 从而导致所有请求都去数据库查询, 导致数据库CPU和内存负载过高,甚至宕机
    解决思路
        1. 采用加锁计数, 或者使用合理的队列数量来避免缓存失效时数据库造成太大压力. 虽然能缓解数据的压力, 但是降低了吞吐量
        2. 分析用户行为, 尽量让失效时间点均匀分布
        3. 如果是因为宕机, 可以考虑做主备.

12. 解释什么是 MESI 协议(缓存一致性)
    这是4种缓存状态的缩写, 主要是针对多核系统
    
    失效 Invalid      要么已经不在缓存中, 要么内容过时. 缓存被标记为失效, 效果等于从没有加载到缓存过
    共享 shared       缓存段, 和主内存内容保持一致的拷贝, 只能读取,不能写入. 多组缓存可以同时拥有针对同一内存地址共享缓存段
    独占 exclusive    缓存段, 和主内存内容保持一致的拷贝, 如果一个处理器拥有了某个缓存段的E状态, 那么其他处理器不能再拥有它, 如果其他处理器的本地也有数据拷贝, 则马上变成失效
    已修改 modified   属于藏段, 内容已经被所属的处理器修改了, 如果一个段处于已修改状态, 那么其他处理器缓存中的拷贝马上变成失效状态.
    

13. 说说你知道的几种 HASH 算法，简单的也可以。
    MD5, SHA1
    
    SHA1
        0.先把 字符串/文件等数据转成"位", 如"abc" 转成二进制 0100 0001...
        1.补位, 使得其长度在对512取模时余数为448, 先补1,再补0, 直到满足X%512=448这个条件
        2.补长度, 通常用64位数组表示原始数据的长度, 如果超过512位, 补成512的倍数, 把消息分成一个一个512的数据块, 分别处理每一块
        3.使用常量 4个
        4.使用函数 与或非,根据不同区间
        5.计算信息摘要 再与或非, 然后合并成 160长度的字符串
    
    MD5
        原理类似SHA1, 区别
        1234        MD5     SHA1
        长度        128     160
        常数        64      4
        运算步骤数  64      80


14. 什么是 paxos 算法，什么是 zab 协议。

    分布式系统的选举过程中, 让不同的选民 最终做出一致的决定
    
    1.提议和投票过程中, 主要角色是 "提议者"(提议) 和 "接受者"(发表意见)
    2.第一阶段 先明确那个是提议者(一个), 如果很多提议者, 接受不接受会很混乱
    3.第一阶段 "接受者"反馈意见,如果多数"接受者"接受了一个提议, 那么提议就通过了

    总结
    1. 第一阶段贿选(所有候选人出一个数字看谁大),第二阶段明确接受谁的提议,提议内容
    2. 编号贿赂金额很重要,无论哪个阶段,编号(贿赂钱少的)被鄙视(拒绝)
    3. 第一阶段中,"接受者"接受了之前提议者的提议, 他后来成为"提议者",也会提出之前接受的提议
        如果他之前没有接受过任何提议, 那贿选胜出的他, 可以提自己的意见


14. ZAB协议
    ZooKeeper Atomic Broadcast
    zk的原子广播协议
    整个ZAB协议包括: 消息广播 和 崩溃恢复 2个过程, 进一步可以分为3个阶段
    1. 发现 Discovery
    2. 同步 Synchronization
    3. 广播 Broadcast
    
    https://zzzvvvxxxd.github.io/2016/08/09/ZAB/
    


15. 一个在线文档系统，文档可以被编辑，如何防止多人同时对同一份文档进行编辑更新。
    方法1. 利用redis setNX 不让其他人编辑, 排它锁
    方法2. 使用版本号, 交给用户自己去合并内容

16. 线上系统突然变得异常缓慢，你如何查找问题。
    逐级排查
    网络 磁盘 内存 CPU 数据库 日志 中间件

17. 说说你平时用到的设计模式。
    单例, 代理, 装饰

18. Dubbo 的原理，有看过源码么，数据怎么流转的，怎么实现集群，负载均衡，服务注册和发现，重试转发，快速失败的策略是怎样的。

19. 一次 RPC 请求的流程是什么
    1.客户端/消费者 以本地调用方式 调用服务
    2.client stub接受到调用后, 负责将方法,参数,等组装成能够进行网络传输的消息体
    3.client stub找到服务地址, 并将消息发送到服务端
    4.server stub接收到消息后进行解码
    5.server stub根据解码结果调用本地的服务
    6.服务端 本地服务执行并返回结果给 server stub
    7.server stub将返回结果打包成消息发送至消费者
    8.client stub接收到消息, 并进行解码
    9.服务消费方得到最终结果
    
20. 自己实现过 rpc 么，原理可以简单讲讲。Rpc 要解决什么问题。
21. 异步模式的用途和意义。
22. 缓存数据过期后的更新如何设计。
    
23. 编程中自己都怎么考虑一些设计原则的，比如开闭原则，以及在工作中的应用。
    开闭原则(Open Close Principle)
        一个软件实体类,模块和函数应该对扩展开放, 对修改关闭
    里氏替换
        子类必须能够替换掉他们的父类
    依赖反转
        高层模块不应依赖底层模块, 都应该依赖抽象而不是细节, 针对接口编程, 而并不是实现
    接口隔离
        建立单一接口, 不要建立庞大的臃肿接口, 尽量细化接口, 接口中方法尽量少
    组合/聚合复用原则
        尽量用聚合, 而不是继承
    单一职责
        一个类只负责一项职责, 应该有一个引起他变化的原因


24. 设计一个社交网站中的“私信”功能，要求高并发、可扩展等等。 画一下架构图。
25. MVC 模式，即常见的 MVC 框架。
26. 聊下曾经参与设计的服务器架构并画图，谈谈遇到的问题，怎么解决的。
27. 应用服务器怎么监控性能，各种方式的区别。
28. 如何设计一套高并发支付方案，架构如何设计。
29. 如何实现负载均衡，有哪些算法可以实现。
30. Zookeeper 的用途，选举的原理是什么。
    定义: 分布式的协调服务, 集群管理者
    功能: 订阅/发布, 负载均衡, 服务命名, 分布式锁等等
    用途: 注册中心
    
    文件系统: Znode 文件节点可以存储数据,不超过1M, 只有节点可以,文件夹不行
    协议: ZAB协议->Zk原子广播: 崩溃恢复模式(zk崩溃:存活不过半, 恢复后退出这个模式), 消息广播(处理客户端请求)
    4种数据节点: 持久,临时,持久有序,临时有序
    watch机制: 只通知一次
        事件: 
            客户端注册watcher
            服务端处理watcher
            客户端回调watcher
            
            
    
    https://blog.csdn.net/qq_29842085/article/details/79443128
    https://www.cnblogs.com/lanqiu5ge/p/9405601.html
    https://segmentfault.com/a/1190000014479433
    https://segmentfault.com/a/1190000014479433
31. Zookeeper watch 机制原理。


32. Mybatis 的底层实现原理 
    https://blog.csdn.net/qq_38182963/article/details/78824620
    
    2部分
        1. 读取配置文件, 用于创建SqlSessionFactory
        2. SqlSession执行的过程

33. 请思考一个方案，设计一个可以控制缓存总体大小的自动适应的本地缓存。

34. 请思考一个方案，实现分布式环境下的 countDownLatch。

35. 后台系统怎么防止请求重复提交。
    做幂等性处理, 基于拦截器
    幂等性要求交易流水号
36. 如何看待缓存的使用（本地缓存，集中式缓存），简述本地缓存和集中式缓存和优缺点。本地缓存在并发使用时的注意事项。
37. 描述一个服务从发布到被消费的详细过程。
38. 讲讲你理解的服务治理。
39. 如何做到接口的幂等性。
40. 如何做限流策略，令牌桶和漏斗算法的使用场景。
41. 什么叫数据一致性，你怎么理解数据一致性。
42. 分布式服务调用方，不依赖服务提供方的话，怎么处理服务方挂掉后，大量无效资源请求的浪费，如果只是服务提供方吞吐不高的时候该怎么做，如果服务挂了，那么一会重启，该怎么做到最小的资源浪费，流量半开的实现机制是什么。
43. dubbo 的泛化调用怎么实现的，如果是你，你会怎么做。
44. 远程调用会有超时现象，如果做到优雅的控制，JDK 自带的超时机制有哪些，怎么实现的。

### 算法

海量数据处理题目
https://www.jianshu.com/p/ba86194b0b93
https://blog.csdn.net/v_JULY_v/article/details/6279498
https://www.cnblogs.com/linguanh/p/8532641.html

?1. 10 亿个数字里里面找最小的 10 个。
    思路:
        1.海量数据, 分块处理, 再合并
        2.对于每一个块, 必须找出10个最大的数, 因为第一个块中最小的数可能比第二个块最大的还要大
        3.Map Reduce思想

    思路2:
        1. 拆分, 然后选择TOP-10
        2. 堆排序后, 获取每个block的TOP-10
        3. 把这些TOP-10在组成新的数组
        4. 在对数组进行排序(快排或其他排序方式)

    思路3:
        1. 桶排序
            找min和max, 并把min~max分成N个桶
            如 min=1 max=10万, 分100个桶, 第一个桶 1-1000, 第二个 1001-2000.


?2. 有 1 亿个数字,其中有 2 个是重复的,快速找到它,时间和空间要最优。
    HashMap


    实现功能 : 微软面试题：
               有100万个数字（1到9），其中只有1个数字重复2次，如何快速找出该数字
               补充下题目 意思：我这里每个数字 都是个阿拉伯数字,是1位的,是1到9之间的
               但是有1百万个这样的数字 比如 12345678912 是11个这样的数字
    实现思路 : 定义9个数组，记录1-9的出现的数字做标记，出现一次则，对应数组加1，
               超过2次，在下次循环直接结束，这样一共直到记录8个数字后，
               直接打印第9个数字，就是一共只会出现2次的数字了

?3. 2 亿个随机生成的无序整数,找出中间大小的值。

?4. 给一个不知道长度的(可能很大)输入字符串,设计一种方案,将重复的字符排重。

5. 遍历二叉树。
    Node {
        T value;
        Node left;
        Node right
    }

    public void first() {
        System.out.println(this.value);

        if(this.left != null)
            this.left.first()

        if(this.right != null)
            this.right.first()
    }

    public void mid() {
        if(this.left != null)
            this.left.mid()

        System.out.println(this.value);

        if(this.right != null)
            this.right.mid()
    }


?6. 有 3n+1 个数字,其中 3n 个中是重复的,只有 1 个是不重复的,怎么找出来。
    HashMap

7. 写一个字符串反转函数。
    实现方式
        1.用栈
        2.char反向遍历
   https://blog.csdn.net/shanren2/article/details/72510949


?8. 常用的排序算法,快排,归并、冒泡。 快排的最优时间复杂度,最差复杂度。冒泡排序的优化方案。

9. 二分查找的时间复杂度,优势。
    O(logN) 因为是递减的等比数列, (1/2)^n 等式两边取对数, log2N(以2为底,N的对数), 大O表示为 O(logN)
    优势: 很大的数据中, 可以很快的查找到
    劣势: 需要在有序的环境下查找

10. 一个已经构建好的 TreeSet,怎么完成倒排序。
    ?中序遍历, 放入数组, 然后再反向遍历
        问题: 借用更多的空间了


11. 什么是 B+树,B-树,列出实际的使用场景。
    硬盘存储的数据
    与二叉树相比, 减少IO操作, 因为节点数降低, 高度降低

    B树:  文件系统
    B+树: 数据库

    B+树比B树的查询性能高

    https://blog.csdn.net/u011240877/article/details/80490663


12. 一个单向链表,删除倒数第 N 个数据。
    2指针技巧:
        快慢指针, 快=慢+N, 快指针到末端(null之前)时, 得到慢指针在[倒数第N个]位置上
        还需要一个慢指针-1的指针, 用于获取[倒数第N个]之前的一个元素
    如果整体计数, 有size的概念
    可遍历, 获取第N个前一个元素

?13. 200 个有序的数组,每个数组里面 100 个元素,找出 top20 的元素。
    大顶堆解法
    从200个数组中各取出一个数, 并记录每个数的来源数组, 建立一个含20个元素的大根堆
    此时堆顶就是最大的数, 取出堆顶元素, 并从堆顶元素的来源数组中取下一个数加入堆, 再取最大值, 一直这样进行100次
    时间复杂度 100*log(200)
    https://hk029.gitbooks.io/leetbook/%E5%88%86%E6%B2%BB/004.%20Median%20of%20Two%20Sorted%20Arrays[H]/004.%20Median%20of%20Two%20Sorted%20Arrays[H].html


14. 单向链表, 查找中间的那个元素。
    思路: 快慢指针
    慢指针每次移动一个节点
    快指针每次移动两个节点

    长度是偶数, 快指针下一个节点为NULL, 满指针指向节点以及下一个节点都为中间节点
    长度是奇数, 快指针指向NULL, 此时慢指针在中间节点上










### 数据库知识
1. 数据库隔离级别有哪些，各自的含义是什么，MYSQL 默认的隔离级别是是什
    1. 未提交读(Read Uncommited): 允许脏读, 也就是可能读取到其他会话中未提交事务修改的数据
    2. 提交读(Read Commited): 只能读取到已经提交的数据. Oracle等数据库默认是这个级别
    3. 可重复读取(Repeated Read): 可重复读, 在同一个事务内的查询都是事务开始时刻一致的, InnoDB默认级别.
        在SQL标准中, 该隔离级别消除了不可重复读, 但还是存在幻读
    4. 串行读(Serializable): 完全串行化的读, 每次读取都要获得表级别的共享锁, 读写相互阻塞
    MySQL默认是 可重复读Repeated Read
    
    脏读
        事务没有提交, 另一个事务能看到未提交的数据
    不可重读
        同一个事务, 对同一条数据, 前后2次读取的数据(注意事项数据)不一样, 原因,其他事务修改了数据
        重点: 对数据的修改
    幻读
        同样的查询条件, 在同一个事务中多次查询, 返回的条数不一样. 原因其他事务插入/删除了数据
        影响是, 要插入ID=1的数据, 但是其他事务先插入了ID=1的数据, 当前事务查询不到这个数据,因为可重复读,查询是没有这条数据, 但是就是插入不进去,提示ID主键重复 

2. MYSQL 有哪些存储引擎，各自优缺点。
    1. MyISAM: 较高的插入, 查询速度, 不支持事务
    2. Innodb: 支持事务, 支持ACID, 支持行级锁定
    3. Memory: 数据放在内存, 有极高的插入,查询,更新效率. Mysql重启后会丢失
    4. Archive: 适合存储大量独立的, 作为历史数据的数据. 因为不会被经常读取, 高插入新能, 差查询性能
    5. BlackHole: 黑洞引擎, 写入的数据会消失, 用于记录binlog做复制的中继

3. 高并发下，如何做到安全的修改同一行数据。
    个人建议
    1.乐观锁
        因为使用悲观锁在 高并发的场景下, 会导致大量资源消耗(增大CPU开销), 甚至可能会承受不起
    2.异步处理
        给用户返回处理中, 通过队列的形式异步处理, 处理完成后, 告知用户成功/失败
        
    https://blog.csdn.net/zhengzhaoyang122/article/details/82183977

4. 乐观锁和悲观锁是什么，INNODB 的行级锁有哪 2 种，解释其含义。
    乐观锁是设定每次修改都不会冲突, 只在提交的时候去检查
    悲观锁设定每次修改都会冲突, 持有排它锁
    
    行级锁分为 共享锁和排它锁两种, 
        共享锁又称读锁 不同事物对数据可以共享一把锁, 只能读, 不能写 
        排它锁又称写锁 获取锁后才能读和写, 获取不到时, 不能读, 不能写

5. SQL 优化的一般步骤是什么，怎么看执行计划，如何理解其中各个字段的含义。
    查看慢查询日志
        定位慢查询, 查看慢查询执行计划 根据执行计划确认
        Explain sql
        select_type 表示select类型, 常见取值有
                            SIMPLE          简单表, 不适用链接表或者子查询
                            PRIMARY         主查询, 外层的查询
                            UNION           union中第二个或者后面的查询语句
                            SUBQUERY        子查询中的第一个SELECT
        table       输出结果集的表
        type        表示链接的类型, 性能有高到低
                        System  表中仅有一行
                        const   表中最多有一个匹配行
                        eq_ref, ref, red_null, index_merge, unique_subquery, index_subquery, range, index等
        possible_key    查询时, 可能使用的索引
        key             实际使用的索引
        key_len         索引字段长度
        rows            扫描行的数量
        Extra           执行情况的说明和描述
        
        
        
6. 数据库会死锁吗，举一个死锁的例子，mysql 怎么解决死锁。
    死锁的原因
        系统资源不足
        进程运行推进的顺序不合适
        资源分配不当
    如果资源充足, 进程的资源请求都能够得到满足, 死锁出现的可能性就低, 否则就会因为争夺有限的资源而陷入死锁.
    1. 重启数据库(过于暴力直接)
    2. 杀掉抢资源的进程
    
    先查哪些进程在抢资源：SELECT * FROM INFORMATION_SCHEMA.INNODB_TRX;
    杀掉它们：Kill trx_mysql_thread_id;

7. MySQL的索引原理，索引的类型有哪些，如何创建合理的索引，索引如何
    索引是通过复杂的算法, 提高数据查询的手段, 从磁盘io到内存io的转变
    有普通索引, 主键, 唯一, 单列/多列索引
    
    1. 最左前缀匹配原则, mysql会一直向右匹配直到遇到查询范围(>,<,between,like)就停止匹配
        比如a=1 and b=2 and c>3 and d=4
        如果建立(a,b,c,d)顺序的索引, d是用不到索引的, 如果建立(a,b,d,c)则索引都可以用到
        个人理解: 实际开发与生产中, 调整索引的机会不多, 不如调整SQL语句的顺序来的实在
        
    2. =和in可以乱序, 比如a=1 and b=2 and c=3 建立(a,b,c)索引顺序可以任意顺序, mysql查询优化器会帮你优化成索引可识别的形式
    3. 尽量选择区分度高的列作为索引, 
            区分度的公式是  count(distinct col)/count(*), 表示字段比例不重复, 比例越大我们扫描的记录越少, 
            唯一键的区分度是1, 性别字段在大数据面前区分度是0, 一般join要求0.1以上, 即平均1条扫描10条记录
    
    4. 索引列不能参与计算, 比如from_unixtime(create_time)='2019-01-01'就无法使用到索引
        原因B+树中存的都是数据中的字段值, 但进行检索时,就要把所有元素都应用函数(或可理解为调用函数并得到返回值)才能比较, 成本很大
        应该写成 create_time = unix_timstamp('2019-01-01')
        
    5. 尽量扩展索引, 如表中已经有a的索引, 现在要加(a, b)的索引, 那么只需要修改以前的索引即可

8. 聚集索引和非聚集索引的区别。
    聚簇索引    索引和记录紧密在一起(如innodb, 数据库表行中数据的物理顺序与键值的逻辑顺序相同)
    非聚簇索引  索引文件和数据文件分开存放, 索引文件的叶子页只保存了主键值, 要定位记录还要去查找响应的数据块

9. 数据库中B TREE和B+ TREE区别
    B+ TREE是 B TREE的变种, 本质都是B树, 有以下不同点
    1. 每个节点的指针上限为2d, 不是2d+1
    2. 内节点不存储data, 只存储key, 叶子节点不存指针
    
10. Btree 怎么分裂的，什么时候分裂，为什么是平衡的。
    Key超过1024才会分裂
    分裂原因: 因为随着数据的增多, 一个节点的key满了, 为了保持B树的特性, 就会再分裂, 像二叉查找树和红黑树的旋转一样, 保持平衡

11. 数据库的ACID是什么
    A   Atomic      原子性, 要么都提交, 要么都失败, 不能一部分成功, 一部分失败
    C   Consistent  一致性, 事务开始及结束后, 数据的一致性约束没有破坏
    I   Isolation   隔离性, 并发事务之间相互不影响, 互不干扰
    D   Durability  持久性, 已经提交的事务对数据库所做的更新必须永久保存. 即使发生崩溃, 也不能被回滚或数据丢失.

?12. 某个表有近千万数据，CRUD 比较慢，如何优化
    垂直拆分(大表变小表)
        
    水平拆分(分到不同机器上)
    
    http://www.cainiaoxueyuan.com/sjk/5178.html
    https://blog.csdn.net/marvHuang/article/details/84592532
    https://blog.csdn.net/zhengzhaoyang122/article/details/82183977
    
        

13. Mysql 怎么优化 table scan.

    1. 避免在子句中对字段进行is null判断
    2. 应尽量避免在where子句中进行 != 或者 <> 操作符, 否则引擎将放弃使用索引而进行全表扫描
    3. 避免在where子句中使用or来连接条件
    4. in和not in也要慎用
    5. Like查询(非左开头)
    6. 使用 num=@num参数
    7. where子句中对字段进行表达式操作  num/2 = XX
    8. 在where子句中对字段进行函数操作

14. 如何写 sql 能够有效的使用到复合索引。

    由于符合索引的组合索引, 类似多个木板拼接在一起, 如果中间断了就无法使用了, 
        所以要能用到复合索引, 首先开头(第一列)要用上, 比如index(a,b)这种,
        我们可以select name from table where a = XX, 用到第一列索引, 
        然后想用第二列可以and b = XX 或者 and b like '%TTT%'

15. mysql 中 in 和 exists 区别。
    mysql中的in语句是把外表和内表做hash连接, 而exists语句是对外表做loop循环, 每次loop循环再对内表进行查询
    大家认为exists比in效率高, 这是不准确的, 因为要区分环境
    
    如果查询的两个表大小相当, 那么用in和exists差别不大
    如果两个表中一个较小, 一个是大表, 则子查询表大的用exists, 子查询表小的用in

    not in 和 not exists如果查询语句使用了not in,那么内外表都进行全表扫描, 没有用到索引; 而not exists子查询依然能够用到表上的索引
    所以无论那个表大, 用not exists都比not in 快
    
    1. Exists只返回TRUE或FALSE, 不会返回UNKNOWN
    2. in当遇到包含NULL的情况, 那么就会返回UNKNOWN
    
16. 数据库自增主键可能的问题。
    在分库分表时可能会生成重复主键 利用自增比例达到唯一 自增1 2,3 等


17. MVCC 的含义。
    innodb是基于 多版本并发控制协议-MVCC(相对于MVCC而言, 相反的是锁的并发控制, Lock-Based Concurrency Controller). 
    MVCC最大的好处: 读不加锁, 读写不冲突
    
    原理版本号+删除标志位: 
        DATA_TRX_ID:   标记更新这条行记录的transaction_id, 每处理一个事务, +1
        DATA_ROLL_PTR: 指向当前记录的rollback segment的undo log记录, 找之前版本的数据通过这个指针
        DB_ROW_ID:     当由innodb自动产生聚集索引时,索引包含DB_ROW_ID值, 否则不包含
        DELETE_BIT:    用于标记是否删除, 真正删除是在commit时

    执行过程
        begin -> 排它锁锁定该行 -> 记录redo log -> 记录undo log -> 修改当前行的值, 写事务编号, 回滚指针指向undo log中修改的行

    https://www.cnblogs.com/chenpingzhao/p/5065316.html
    https://www.cnblogs.com/Jason-Born/p/7878401.html

    

?18. 你做过的项目里遇到分库分表了吗，怎么做的，有用到中他们的原理知道么。
    https://blog.csdn.net/qiansg123/article/details/80121817

19. MYSQL 的主从延迟怎么解
    原因
        主从复制都是单线程操作, 
            主库DDL,DML都写入binlog, binlog是顺序写, 效率很高
            从库的SQL Thread将主库的DDL和DML操作事件在Slave中重放. DML和DDL的IO操作是随机的, 不是顺序的, 成本高很多.
            另一方面, SQL Thread也是单线程的, 主库并发较高时, 产生的DML超过SQL Thread处理的速度,或者当slave中有大量query语句, 锁等待就产生了
             
    常见原因: master负载过高, slave负载过高, 网络延迟, 机器性能太低, MySQL配置不合理
    排查方法: show slave status输出的second_behind_master参数来判断
        NULL  io thread 或 sql thread有任何一个发生故障
        0     表示主从复制良好
        正数  主从出现延迟, 数越大越严重
            
    解决方案
        1. 优化网络
        2. 升级slave机器的硬件配置
        3. salve参数调整, 关闭binlog, 修改innodb_flush_log_at_trx_commit的值
        4. 升级到mysql5.7, 使用并行复制

    https://www.cnblogs.com/phpper/p/8904169.html
    https://blog.csdn.net/soar_away/article/details/72615012
    









### 消息队列

### Redis, Memcached
1. redis 的 list 结构相关的操作。
    LPUSH(X)    在队列头部插入一个或多个元素, X(Exist)是队列存在时添加,否则不添加
    RPUSH(X)    在队列尾部插入一个或多个元素, X(Exist)是队列存在时添加,否则不添加
    LPOP        移除头部一个元素
    RPOP        移除尾部一个元素
    BLPOP       B(block)阻塞, 移除头部元素, 如果没有元素则阻塞直到有元素可弹出为止
    BRPOP       B(block)阻塞, 移除尾部元素, 如果没有元素则阻塞直到有元素可弹出为止
    LLEN        获取长度
    LRANGE      根据区间获取元素, LRANGE mylist 0 10, 获取0-10的元素
    
2. Redis 的数据结构都有哪些。
    字符串(String)     存储整数(计数器)和字符串(可以是序列化的二进制,也可是json,可以是纯字符串)
    列表(List)         可作为队列,栈使用. 存储有序数据, 可以重复
    哈希表(Hashes)     根据Key, Value存储, 分布式的HashMap
    集合(Sets)         无需, 唯一
    有序集合(Sorted Set) 有序, 有分数, 可根据分数排序

3. Redis 的使用要注意什么，讲讲持久化方式，内存设置，集群的应用和优劣势等。
    持久化方式
        RDB
            时间快照, dump全部数据存储在dump.rdb文件里
            时间间隔相对长, dump花费时间长, 宕机时数据丢失多,但恢复时快
        AOF
            记录服务器执行的命令
            时间间隔相对短, dump花费时间短, 宕机时数据丢失少,恢复慢(因为要一条一条执行)
            
    内存设置
        maxmemory
        used_memory
        虚拟内存: vm-enabled yes
     
    集群
        客户端分区
            Cluster    3.0版本以上
            客户端分区 自己控制逻辑, 自己控制高可用, 故障转移等
            代理方案   客户端维护方便, 服务端复杂

    LRU 
        近期最少使用方法
    TTL
       超时算法 
    
4. redis2 和 redis3 的区别，redis3 内部通讯机制。
    集群方式的区别, 3采用Cluster, 2采用客户端分区和代理方案
    1. 集群中的每个节点都会单独开辟一个TCP通道, 用于节点之间通信, 通信端口号在基础上加10000
    2. 每个节点在固定周期通过特定规则发送ping消息
    3. 接收到ping消息后, 用pong消息作为回应


5. 当前 redis 集群有哪些玩法，各自优缺点，场景。
6. Memcache 的原理，哪些数据适合放在缓存中。
7. redis 和 memcached 的内存管理的区别。
8. Redis 的并发竞争问题如何解决，了解 Redis 事务的 CAS 操作吗。
    redis为单进程单线程模式, 采用队列模式将并发访问变为串行访问
    redis本身没有锁概念.
    事务操作(不具有原子性, 只是批量操作)
        MULTI   事务开启
        EXEC    事务执行(不同于提交, 只是批量执行而已)
        DISCARD 取消事务
        WATCH   监视某个值, 如果值发送变更, 事务会取消

        >MULIT
        ok
        >INCR foo
        QUEUED
        >EXEC
        1) (integer) 1
        
    CAS 不是 Compare and Swap概念, 而是 Check and Set
    1. 不用watch
        ClientA         ClientB
        get sc(10)      
                        get sc(10)
        tmp=sc+1(11)    tmp=sc+1(11)
                        set sc=tmp(11)
        set sc=tmp(11)
        final(11)       final(11)
    2. 使用watch
            ClientA         ClientB
            watch sc
            get sc(10)      
                            get sc(10)
            tmp=sc+1(11)    tmp=sc+1(11)
            标记sc被修改    set sc=tmp(11)
            set sc=tmp(11)失败
            final(11)       final(11)
            get sc(11)
            tmp=sc+1(12)
            set sc=tmp(12)
            final(12)
    
9. Redis 的选举算法和流程是怎样的。
    redis没有使用一致性Hash, 而是引入了哈希槽slot的概念,redis集群总计有16384个槽, 每个key通过CRC16校验后对16384取模, 决定放在哪个槽
    
10. redis 的持久化的机制，aof 和 rdb 的区别。
    上面 *2

11. redis 的集群怎么同步的数据的。
    全同步和部分同步
    
    全同步, 在slave刚启动的时候
        1. Slave向Master发送同步指令SYNC, Master接收到消息后, 调用syncCommand()方法进行同步处理
        2. 方法中, 会启动一个备份进程用于同步, 如果有一个进程在做同步操作, 则不会在开启新的
        3. 备份进程将redis数据保存为rdb文件
        4. redis的Corn, 会对备份后的数据进行处理, 如果备份完毕, 调用hanlder完成后续处理
        5. Handler会更新master状态(成功失败,时间等), 将备份的rdb数据发送给slave
    部分同步
        1. Master接收到客户端的指令后, 更新数据, 并记录到aof文件中
        2. master获取所有slave列表, 并扩散到slave中
        3. 将slave切换为本次操作的数据库, 并

12. 知道哪些 redis 的优化操作。
13. Reids 的主从复制机制原理。
14. Redis 的线程模型是什么

### 搜索







### 统计
序号    技能          总数      未完成   
---------------------------------------------------------
1       基础          32          6
2       JVM知识       14          7
3       开源框架      14          4
4       操作系统      9           9
5       多线程        28          6
6       TCP           11          2
7       架构设计      44          20
8       算法          14          7
9       数据库        19          2
10      消息队列      9           9
11      Redis         14          6
12      搜索          3           3
