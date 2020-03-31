### 1、 Spring 容器的核心内容
1. 控制反转（IOC）Spring 容器使用工厂模式为我们创建了我们所需要的对象，不需要我们自己创建了，直接调用 Spring 提供的对象就可以了
2. 依赖注入（DI）Spring 使用 JavaBean 对象的 set 方法或者带参数的构造方法在创建对象的时候把所需要的值注入，这就是依赖注入的思想
3. 面向切面编程（AOP）AOP 底层就是动态代理，如果是接口采用 JDK 动态代理，如果是类采用 CGLIB 动态代理
### 2、 Spring 中的设计模式
1. 单例模式：在 Spring 的配置文件中设置 bean 默认为单例模式
2. 模板方式模式：用来解决代码重复的问题
3. 前端控制器模式：Spring 提供了前端控制器 DispatcherServlet 来对请求进行分发
4. 视图帮助（view helper）
5. 依赖注入
6. 工厂模式
### 3、 Spring 的常用注解
1. @Required:该注解应用于设值方法
2. @Autowired：该注解应用于有值设值方法、非设值方法、构造方法和变量。
3. @Qualifier：该注解和@Autowired 搭配使用，用于消除特定 bean 自动装配的歧义。
### 4、 Spring bean 的生命周期
1. bean 定义：在配置文件里面用<bean></bean>来进行定义
2. bean 的初始化
    1.在配置文件中通过指定 init-method 属性来完成
    2.实现 org.springframwork.beans.factory.InitializingBean 接口
3. bean 的调用
4. bean 的销毁
    1.使用配置文件指定的 destroy-method 属性
    2.实现 org.springframwork.bean.factory.DisposeableBean 接口
### 5、 Spring 能帮我们做什么？
1. Spring 能帮我们根据配置文件创建及组装对象之间的依赖关系
2. Spring 面向切面编程能帮我们无耦合的实现日志记录，性能统计，安全控制
3. Spring 能非常简单的帮我们管理数据库事务
4. Spring 还能与第三方数据库访问框架无缝集成，而且自己也提供了一套JDBC访问模板，来方便数据库访问
5. Spring 还能与第三方 web 框架无缝集成，而且自己也提供了一套 Spring MVC 框架，来方便 web 层搭建
6. Spring 能方便的与 JavaEE 整合，与更多技术整合
### 6、 Spring 的事务
1. 声明式事务
2. 编程式事务
### 7、 BeanFactory 常用的实现类
1. DefaultListableBeanFactory 
2. XmlBeanFactory （常用）
3. ApplicationContext
### 8、 IOC 的优点
IOC 或依赖注入把应用代码量降到最低。它使应用容易测试，单元测试不再需要单例和 JNDI 查找机制。最小的代价和最小的侵入性使松散耦合得以实现。 IOC
 容器支持加载服务时的饿汉式初始化和懒加载。
### 9、 ApplicationContext 的实现类有哪些
1. FileSystemXmlApplicationContext
2. ClassPathXmlApplicationContext
3. WebXmlApplicationContext
### 10、 不同的 IOC （依赖注入）方式
1. Set 注入
2. 构造器注入
3. 静态工厂的方法注入
4. 实例工厂的方法注入
### 11、 怎么定义类的作用域
通过定义 bean 的 scope 属性来定义
### 12、 Spring 支持几种 bean 的作用域
1. singleton
2. prototype
3. request
4. session
5. global-session
### 13、 Spring 框架中的单例 bean 是线程安全的吗
不是线程安全的
### 14、不同方式的自动装配
1. no：默认的方式不进行自动装配，通过显示设置ref属性来进行装配
2. byName：通过参数名自动装配
3. byType：通过参数类型自动装配
4. constructor：通过构造器自动装配
5. autodetect：首先使用构造器自动装配，如果不行就使用参数类型自动装配