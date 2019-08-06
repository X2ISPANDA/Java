# 类加载

> 当程序要使用某个类时，如果该类还未被加载到内存中，则系统会通过加载，连接，初始化三步来实现对这个类进行初始化。
> 1、加载 
> 就是指将class文件读入内存，并为之创建一个Class对象。
> 任何类被使用时系统都会建立一个Class对象
> 2、连接
> 验证是否有正确的内部结构，并和其他类协调一致
> 准备负责为类的静态成员分配内存，并设置默认初始化值
> 解析将类的二进制数据中的符号引用替换为直接引用
> 3、初始化 
> 就是我们以前讲过的初始化步骤

类加载器的作用：
负责将.class文件加载到内存中，并为之生成对应的Class对象。

## 反射

Java反射机制：在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为Java语言的反射机制。


反射机制主要是用来破解类文件的。 一 类加载

1 加载步骤

- 加载：就是指将class文件读入内存，并为之创建一个Class对象，任何类被使用时系统都会建立一个Class对象
- 连接：验证是否有正确的内部结构，并和其他类协调一致，准备负责为类的静态成员分配内存，并设置默认初始化值，解析将类的二进制数据中的符号引用替换为直接引用
- 初始化

2 类初始化的时机

- 创建类的实例
- 访问类的静态变量，或者为静态变量赋值
- 调用类的静态方法
- 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象
- 初始化某个类的子类
- 直接使用java.exe命令来运行某个主类

3 类加载器的作用

- 负责将.class文件加载到内存中，并为之生成对应的Class对象。

4 类加载器的组成

- Bootstrap ClassLoader 根类加载器：也被称为引导类加载器，负责Java核心类的加载
- Extension ClassLoader 扩展类加载器：负责JRE的扩展目录中jar包的加载。
- System ClassLoader 系统类加载器：负责外部引入的和自己打的jar包的加载

5 获取Class对象的方式

- 方式一: 通过Object类中的getClass()方法 ： 对象名.getClass()
- 方式二：通过 类名.class 获取到字节码文件对象： 类名.class
- 方式三：通过Class类中的方法（将类名作为字符串传递给Class类中的静态方法forName即可），Class.forName("完整包名.类名")
- 第三种和前两种的区别：前两种你必须明确Person类型；后面是指定这种类型的字符串就行，这种扩展性更强，灵活性比较强，使用Class.forName()的方式比较多，我不需要知道你的类只提供字符串按照配置文件加载就可以了

6 通过反射获取构造方法

- 在反射机制中，把类中的成员（构造方法、成员方法、成员变量）都封装成了对应的类进行表示。其中，构造方法使用类Constructor表示
- public Constructor getConstructor(Class<?>... parameterTypes) 获取public修饰, 指定参数类型所对应的构造方法
- public Constructor<?>[] getConstructors() 获取所有的public 修饰的构造方法
- public Constructor getDeclaredConstructor(Class<?>... parameterTypes) 获取指定参数类型所对应的构造方法(包含私有的)
- public Constructor<?>[] getDeclaredConstructors() 获取所有的构造方法(包含私有的)

7 利用反射获得的构造方法创建对象

- 获取到Class对象
- 获取指定的构造方法
- 通过构造方法类Constructor中的方法，创建对象；public T newInstance(Object... initargs)

8 利用反射获得的私有构造方法创建对象

- AccessibleObject 类是 Field、Method 和 Constructor 对象的父类。它提供了将反射的对象标记为在使用时取消默认 Java 语言访问控制检查的能力
- 获取到Class对象
- 获取指定的构造方法
- 暴力访问, 通过setAccessible(boolean flag)方法
- 通过构造方法类Constructor中的方法，创建对象；public T newInstance(Object... initargs)

9 通过反射获取属性（成员变量）

- public Field getField(String name) 获取指定的 public修饰的变量
- public Field[] getFields() 获取所有public 修饰的变量(属性)
- public Field getDeclaredField(String name) 获取指定的任意变量
- public Field[] getDeclaredFields() 获取所有的 变量 (包含私有)

10 通过反射获取属性后进行赋值和获取值的操作

- 获取Class对象
- 获取构造方法
- 通过构造方法创建对象
- 获取指定的成员变量(私有成员变量，通过setAccessible(boolean flag)方法暴力访问)
- 通过方法，给指定对象的指定成员变量赋值或者获取值

```
  public void set(Object obj, Object value)
  在指定对象obj中，将此 Field 对象表示的成员变量设置为指定的新值
  public Object get(Object obj)
  返回指定对象obj中，此 Field 对象表示的成员变量的值
```

11 通过反射获取成员方法

- public Method getMethod(String name, Class<?>... parameterTypes) 获取public 修饰的方法
- public Method[] getMethods() 获取本类与父类中所有public 修饰的方法
- public Method getDeclaredMethod(String name, Class<?>... parameterTypes) 获取任意的方法，包含私有的,默认的，protected修饰
- public Method[] getDeclaredMethods() 获取本类中所有的方法(包含私有的)
- Method的常用方法

```
  getName();//获取方法的名称
  getReturnType();//获取方法的返回类型
```

12 通过反射获取成员方法后调用指定的方法

- 获取Class对象
- 获取构造方法
- 通过构造方法创建对象
- 获取指定的方法(私有的,通过setAccessible(boolean flag)方法暴力访问)
- 执行找到的方法：public Object invoke(Object obj, Object... args)

13 反射的使用场景

- 需要获取Class对象，使用其方法
- 开发代码生成工具时
- 在框架中

14 反射的应用

- 泛型的擦除：其实程序编译后产生的.class文件中是没有泛型约束的，这种现象我们称为泛型的擦除
- 利用反射读取配置文件：通过反射配置文件，运行配置文件中指定类的对应方法

15 动态代理

- 代理：本来应该自己做的事情，却请了别人来做，被请的人就是代理对象

- 动态代理：在程序运行过程中产生的这个对象

- > 具体步骤:
  >
  > 1. 创建实体类
  > 2. 创建实体类的DAO接口
  > 3. 创建DAO接口的实现类
  > 4. 实现InvocationHandler接口重写invoke方法
  > 5. 创建代理对象Proxy.newProxyInstance();`/第一个参数,代理类的加载器//第二个参数,代理类的所有接口//第三个参数,代理对象需要绑定的处理器`

