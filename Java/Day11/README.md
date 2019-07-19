# 课堂测验

> - 下面那几个函数是 public void method(){...}的重载函数（多选）（    AD   ）
>
> A. public void method(int m){...} 
>
> B. public int method(){...}
>
> C. public void method2(){...} 
>
> D. public int method(int m,float f){...}
>
> - 下述代码的执行结果是 （单选）   （     ）
>
> class Super{ 
>
> public int getLength(){ return 4;}
>
> }
>
> public class Sub extends Super{
>
> public long getLength(){ return 5;}
>
> public static void main(String[] args){
>
> Super sooper = new Super();
>
> Super sub = new Sub();
>
> System.out.println(sooper.getLength() +“,”+ sub.getLength()); 
>
> }
>
> }
>
>   A. 4,4    B. 4,5   C. 5,4   D. 5,5    E. 代码不能被编译

**重载规则：**必须具有不同的参数列表； <span style="color:red">可以有不同的返回类型</span>；可以有不同的访问修饰符；可以抛出不同的异常。

**重写规则：**<span style="color:red">参数列表必须完全与被重写的方法相同</span>，否则不能称其为重写而是重载；返回类型必须一直与被重写的方法相同，否则不能称其为重写而是重载；

> 4、阅读代码  
>
> class Test{
>
> public static int count = 0;//静态变量
>
> public Test(){
>
> count++;
>
> }
>
> public static void main(String[] args){
>
>  Test o1 = new Test();
>
>  Test o2 = new Test();
>
>  System.out.println(Test.count);
>
> }
>
> }
>
> 请问，输出的结果是？（单选）  （   B    ）
>
> A. 1   B. 2   C. 3   D. 4

> 5、阅读代码   （多选）
>
> String s = new String(“hello”) ;
>
> String t = new String(“hello”);
>
> String c = “hello”;
>
> 下列哪些表达式返true ？    （ ADE  ）
>
> A、s.equals(t);
>
> B、s == t ;
>
> C、s == c ;
>
> D、t.equals(new String(“hello”)) ;
>
> E、c == (“hel” + “lo”)

由于字符串对象的大量使用(它是一个对象，一般而言对象总是在heap分配内存)，Java中为了节省内存空间和运行时间(如比较字符串时，==比equals()快)，在编译阶段就把所有的字符串文字放到一个文字池(pool of literal strings)中，而运行时文字池成为常量池的一部分。文字池的好处，就是该 池中所有相同的字符串常量被合并，只占用一个空间。
--------------------- 

String s = new String(“hello”) ;

String t = new String(“hello”);

String c = “hello”;

这三句话一共创建了三个对象

String hello = "hello";
String hel = "hel";
String lo = "lo";

System.out.println(hello == "hel" + "lo");
System.out.println(hello == "hel" + lo);

 

求输出的结果

 

解答 true false

<span style="color:red">总结一下就是,如果加号两边的是字面值(字面值就是直接在""里写的值,比如上面的"hel"与"lo"),那么将在pool里查找有没对应内容的对象(这里的内容就是"hello"),并返回pool里的对象.这和hello是一样的....如果加号两边不满足上面的条件(比如,两边的值是引用值或者堆里的字符串对象).那么将不会再pool里查找"hello",而是直接在堆里生成一个新的对象...</span>

>  8、请选出下面两个类间关系描述错误的项（单选）  （   A   ）
>
>  A. public interface A{}
>
>  public class B extends A{}
>
>  B. public interface A{}
>
>  public interface B extends A{}
>
>  C. public interface A{}
>
>  public class B implements A{}
>
>  D. public class A{}
>
>  public class B{protected A a;}

类不可以继承接口

```
数组初始化	int a[] =new int[]{1,2,3};
```