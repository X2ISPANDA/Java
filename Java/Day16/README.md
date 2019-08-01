# 异常

> 所谓的异常就是Java代码在编译运行时期发生的问题就是异常。一段导致程序中断执行的一种指令流.

## 异常事件分类

- 错误(Error)

  JVM的错误，程序员没有办法处理

- 异常(Exception)

  指程序在编译、运行期间发生了某种异常(Xxx Exception)，我们可以对异常进行具体的处理。若不处理异常，程序将会结束运行。

## 异常的分类

- 已检查异常<span style="color:red">就是编译器要求你必须处置的异常</span>
  - ClassNotFoundException  类找不到的异常，缺少jar包或路径不对时就找不到类
  - IOException
  - EOFException
  - FileNotFoundException
  - NoSuchMethodException

对检查异常（checked exception）的几种处理方式：
1、继续抛出，消极的方法，一直可以抛到java虚拟机来处理，就是通过throws exception抛出。
2、用try...catch捕获

- 未检查异常<span style="font-weight:bold;color:red">编译器不要求强制处置的异常</span>
  - ArithmeticException
  - NullPointerException
  - NegativeArraySizeException
  - ArrayOutOfBoundsException
  - ClassCastException
  - SQLException
  - NumberFormatException
- 运行时异常

  - IndexOutOfBoundsException,数组越界异常
  - NumberFormatException,数字格式异常,输入字母
  - ArithmeticException,数学运算异常,除零

> RuntimeException异常是程序运行过程中产生的异常。Java类库中的每个包中都定义了异常类，所有这些类都是Throwable类的子类。未检查异常属于运行时异常。



## 如何处理异常

- try...catch捕获异常

```
try{
		有可能发生异常的代码
	}catch(异常类 对象){
			e.printStackTrace();			//输出异常的信息
		当发生该异常的时候执行的代码
	}[catch(异常类 对象){
		当发生该异常的时候执行的代码
	}
……]
finally{
//程序块
}

```

catch 可能会有多个，也就是说可以捕获多个异常，如果这些异常中有父子关系，子类所在 catch 一定要放到父类 catch 的后面。

- throws声明异常

## 自定义异常

- 继承Exception
- 继承RuntimeException

## Throws和Throw的区别

throws：用来声明一个方法可能产生的所有异常，不做任何处理而是将异常往上传，谁调用我我就抛给谁。自己不处理.
  用在方法声明后面，跟的是异常类名
  可以跟多个异常类名，用逗号隔开
  表示抛出异常，由该方法的调用者来处理
  throws表示出现异常的一种可能性，并不一定会发生这些异常
throw：则是用来抛出一个具体的异常类型。自己自行处理
  用在方法体内，跟的是异常对象名
  只能抛出一个异常对象名
  表示抛出异常，由方法体内的语句处理
  throw则是抛出了异常，执行throw则一定抛出了某种异常