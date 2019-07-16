# 面向对象编程

## 一丶封装

封装：是指隐藏对象的属性和实现细节，仅对外提供公共访问方式。

好处：

1.  将变化隔离。
2.  便于使用。
3.  提高重用性。
4.  提高安全性。

封装原则：

1. 将不需要对外提供的内容都隐藏起来。
2. 把属性都隐藏，提供公共方法对其访问。如，getXXX，setXXX。

注意事项：

- 私有仅仅是封装的一种体现而已。
- private关键字：是一个权限修饰符，用于修饰成员(成员变量和成员函数)，被私有化的成员只在本类中有效。
- 常用场景之一：将成员变量私有化，对外提供对应的set、get方法对其进行访问，提高对数据访问的安全性。

## 二丶this关键字

> this代表其所在函数所属对象的引用。换言之，this代本类对象的引用。
>
> 当成员变量和局部变量重名，可以用关键字this来区分，this就是所在函数所属对象的引用。
>
> 简单说，哪个对象调用了this所在的函数，this就代表哪个对象。一般方法调用默认加this。（方法被哪个对象调用，this就代表那个对象）

<font color=red style="background-color:yellow;"> 可以通过this()调用类中的构造方法，必须放在第一行,普通方法中不能调用。</font>

<p style="color:red;">静态方法里不可以使用this</p>
### 三丶static关键字

1. static可以修饰什么

   1. 属性(静态属性、静态变量、类变量)
   2. 一般方法(静态方法、类方法)
   3. 游离语句块(静态语句代码块)
   4. 内部类

2. static关键字特点

   - 随着类的加载而加载
   
   - 优先于对象存在
   
   - 被类的所有对象共享
   
   - 这也是我们判断是否使用静态关键字的条件
   
   - 可以通过类名调用
   
3. static关键字注意事项

   - 在静态方法中是没有super和this关键字的
   - 静态方法只能访问静态的成员变量和静态的成员方法
   - 在Java中规定不能将方法体内的局部变量声明为static
   
4. 构造方法和成员变量初始化顺序
   
   执行父类静态代码 执行子类静态代码 初始化父类成员变量（我们常说的赋值语句） 初始化父类构造函数 初始化子类成员变量 初始化子类构造函数
   
   <p style="color:red;font-size:20px">所有的变量初始化完，才会执行构造方法</p>

```java
class A2{
    B2 b2 = new B2();
    static{
        System.out.println("A static");
    }
    public A2() {
        System.out.println("A2()");
    }
}
class B2{
    C2 c2 = new C2();
    D2 d2 = new D2();
    static{
        System.out.println("B static");
    }
    public B2() {
        System.out.println("B2()");
    }
}
class C2{
    static{
        System.out.println("C static");
    }
    public C2() {
        System.out.println("C2()");
    }
}
class D2{
    static{
        System.out.println("D static");
    }
    public D2() {
        System.out.println("D2()");
    }
}
public class VarTest {
    public static void main(String[] args) {
        A2 a2 = new A2();
    }
}
```

输出结果为：

```A static
B static
C static
C2()
D static
D2()
B2()
A2()
```

静态成员与普通成员类的加载区别

在类的加载过程中，静态成员类的对象，会优先加载；而普通成员类的对象则是使用的时候才回去加载。

```java
class A3{
    B3 b3 = new B3();
    static C3 c4 = new C3();
    static{
        System.out.println("A3");
    }
}
class B3{
    static{
        System.out.println("B3");
    }
}
class C3{
    static{
        System.out.println("C3");
    }
}
public class StaticTest {
    public static void main(String[] args) {
        A3 a3 = new A3();
    }
}
```

输出:

```
C3
A3
B3
```

*总结*

第一点，所有的类都会优先加载基类
第二点，静态成员的初始化优先
第三点，成员初始化后，才会执行构造方法
第四点，静态成员的初始化与静态块的执行，发生在类加载的时候。
第四点，类对象的创建以及静态块的访问，都会触发类的加载。

*类构造方法的顺序*

```java
class A{
    public A() {
        System.out.println("A");
    }
}
class B extends A{
    public B() {
        System.out.println("B");
    }
}
class C extends B {
    private D d1 = new D("d1");
    private D d2 = new D("d2");
    public C() {
        System.out.println("C");
    }
}
class D {
    public D(String str) {
        System.out.println("D "+str);
    }
}
public class ExtendTest {
    public static void main(String[] args) {
        C c = new C();
    }
}
```

执行结果：

```A
B
D d1
D d2
C
```

因此可以得出结论：

- 首先会调用基类的构造方法
- 其次，调用成员的构造方法
- 最后，调用自己的构造方法

## 二丶继承

> 在Java中，类的继承是指在一个现有类的基础上去构建一个新的类，构建出来的新类被称作子类，现有类被称作父类，子类会自动拥有父类所有可继承的属性和方法。在程序中，如果想声明一个类继承另一个类，需要使用extends关键字。
>
> 通过 extends 关键字让类与类之间产生继承关系。
>
> 多个类中存在相同属性和行为时，将这些内容抽取到单独一个类中，那么多个类无需再定义这些属性和行为，只要继承那个类即可。多个类可以称为子类，单独这个类称为父类或者超类。

注意事项：

- 子类可以直接访问父类中的非私有的属性和行为。
- 子类无法继承父类中私有的内容。
- 父类怎么来的？共性不断向上抽取而来的。
- 父类的构造方法不可以继承

***继承的特点***

1．在Java中，类只支持单继承，不允许多重继承，也就是说一个类只能有一个直接父类，例如下面这种情况是不合法的。

![1500704447701](https://alleniverson.gitbooks.io/java-basic-introduction/content/%E7%AC%AC3%E7%AB%A0%20%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1/img/1500704447701.png)

2．多个类可以继承一个父类，例如下面这种情况是允许的。

![1500704467099](https://alleniverson.gitbooks.io/java-basic-introduction/content/%E7%AC%AC3%E7%AB%A0%20%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1/img/1500704467099.png)

3．在Java中，多层继承是可以的，即一个类的父类可以再去继承另外的父类，例如C类继承自B类，而B类又可以去继承A类，这时，C类也可称作A类的子类。例如下面这种情况是允许的。

![1500704487847](https://alleniverson.gitbooks.io/java-basic-introduction/content/%E7%AC%AC3%E7%AB%A0%20%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1/img/1500704487847.png)

4．在Java中，子类和父类是一种相对概念，也就是说一个类是某个类父类的同时，也可以是另一个类的子类。例如上面的示例中，B类是A类的子类，同时又是C类的父类。

Java只支持单继承，不支持多继承。一个类只能有一个父类，不可以有多个父类。 原因：因为多继承容易出现问题。两个父类中有相同的方法，子类到底要执行哪一个是不确定的。

#### super关键字

子类想调用父类提供的方法或属性用super关键字。

作用：

1. 调用父类中构造方法用super()；必须放在第一行
2. 调用父类中的普通方法super.普通方法()；
3. 调用父类中的属性super.属性；

