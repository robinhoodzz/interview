### 可以从这里着手, 鼓泡IOC的代码和注释
https://www.jianshu.com/p/f57db8b29be9

### 其他JAVA相关面试
http://www.iocoder.cn/Fight/Interview-poorly-asked-Spring-IOC-process-1/

### 经典面试题
1. 什么是Spring框架? Spring框架有哪些主要模块?
2. 使用Spring框架能带来什么好处?
3. 什么是控制反转IOC, 什么是依赖注入DI?
4. BeanFactory和ApplicationContext有什么区别
5. 请解释Spring Bean的生命周期
6. SpringBean的各种作用域
7. Spring框架中的单例Beans是线程安全的么?


### 答案:


7. 假设不成立, 是不是线程安全取决于bean本身. IOC容器只负责对bean进行实例化和存储. 没有对bean做任何的修改, 不能说他线程安全或者不安全.
    取决于bean本身的属性, 与容器没有任何关系.
