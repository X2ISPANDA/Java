# IO流

## File类

1. 构造方法
   public File(String pathname)
   public File(String parent,String child)
   public File(File parent,String child)

2. 相对路径与绝对路径

   1. 存在盘符:绝对路径

   2. 不存在盘符:相对路径,相对于当前目录
   

**java路径两种写法"/"和"\\\\"**
> 正斜杠的话，一般在配置文件路径时，指向下一个路径只要使用一个
> 而反斜杠的话，在配置文件路径时，由于它本身在java中有特殊意义，作为转义符而存在，所以具体意义上的反斜杠要两个
> 例如："c\\a\\1.txt";这里的第一个反斜杠是作为转义符存在的，第二个才是真正意义上的反斜杠
> 一般可以认为是"/"的作用等同于"\\"
> 在java中路径一般用"/"
> windows中的路径一般用"\"
> linux、unix中的路径一般用"/"
> 最好用“/”  因为java是跨平台的。“\”（在java代码里应该是\\）是windows环境下的路径分隔符，Linux和Unix下都是用“/”。而在windows下也能识别“/”。所以最好用“/”

3. 常用API

   - 创建文件createNewFile():不存在才创建

     操作系统的设备名不能正确创建:con,com3

   - 删除文件:delete()

   - 获取名称或路径

     - getPath()获取路径

       构建的是什么路径就返回什么路径

     - getAbsolutePath()获取绝对路径

     - getParent()获取父路径

     - getName():获取名字

   - 文件状态

     - exists():是否存在
     - isFile():是否是文件
     - isDirectory():是否是文件夹
     - length():文件长度

   - 文件夹创建和遍历

     - mkdir() :创建目录,必须确保上级目录存在,不存在创建失败
     - mkdirs():创建目录,如果父目录链不存在一同创建
     - list():列出下级名称
     - listFiles():列出下级File对象
     
   - FileFilter接口:用于过滤文件(File对象)
   
     - boolean accept(File pathname):测试指定抽象路径名是否应该包含在某个路径名列表中
   
   - FilenameFilter接口:用于过滤文件名称
   
     - boolean accept(File dir,String name)：测试指定文件是否应该包含在某一文件列表中
   
       注意:两个过滤器接口是没有实现类的,需要我们自己写实现类,重写过滤的方法accept,在方法中自己定义过滤的规则

## 文件编码

- 常用字符集

  | 字符集 | 说明 |
  | :-: | :-: |
  | US-ASCII| 即英文的ASCII|
| ISO-8859-1 | Latin-1拉丁字符,包含中文日文等 |
  | UTF-8 | 变长Unicode字符(1-3个字节),国际通用 |
| UTF-16BE | 定长Unicode字符(2个字节),大端Big-endian表示,高字节低地址 |
  | UTF-16LE | 定长Unicode字符(2个字节),小端little-endian表示,低字节低地址 |
  | UTF-16 | 文件中开头指定大端还是小端表示方式,即BOM |
  
- 乱码原因
  1. 字节数不够
  2. 字符集不统一

## 什么是IO流

可简单地理解为输入(Input)/输出(Output),流既是一种数据的流动

## IO的分类

**根据数据的流向分为：输入流和输出流。**

- 输入流 ：把数据从其他设备上读取到内存中的流。
- 输出流 ：把数据从内存 中写出到其他设备上的流。

输入输出以程序为中心.

**根据数据的类型分为：字节流和字符流。**

- 字节流 ：以字节为单位，读写数据的流。
- 字符流 ：以字符为单位，读写数据的流。

能使用字符流的地方,全部都可以使用字节流.

能使用字节流,不一定能使用字符流.

## 四大抽象类

|        | 输入流      | 输出流       |
| ------ | ----------- | ------------ |
| 字节流 | InputStream | OutputStream |
| 字符流 | Reader      | Writer       |

## InputStream字节输入流

- `public void close()` ：关闭此输入流并释放与此流相关联的任何系统资源。  
- `public abstract int read()`： 从输入流读取数据的下一个字节。 
- `public int read(byte[] b)`： 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

## OutputStream字节输出流

- `public void close()` ：关闭此输出流并释放与此流相关联的任何系统资源。  
- `public void flush() ` ：刷新此输出流并强制任何缓冲的输出字节被写出。  
- `public void write(byte[] b)`：将 b.length字节从指定的字节数组写入此输出流。  
- `public void write(byte[] b, int off, int len)` ：从指定的字节数组写入 len字节，从偏移量 off开始输出到此输出流。  
- `public abstract void write(int b)` ：将指定的字节输出流。

## Reader字符输入流

- `public void close()` ：关闭此流并释放与此流相关联的任何系统资源。    
- `public int read()`： 从输入流读取一个字符。 
- `public int read(char[] cbuf)`： 从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。

## Writer字符输出流

- `void write(int c)` 写入单个字符。
- `void write(char[] cbuf) `写入字符数组。 
- `abstract  void write(char[] cbuf, int off, int len) `写入字符数组的某一部分,off数组的开始索引,len写的字符个数。 
- `void write(String str) `写入字符串。 
- `void write(String str, int off, int len)` 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
- `void flush() `刷新该流的缓冲。  
- `void close()` 关闭此流，但要先刷新它。 

## 理解操作步骤

1. 创建源
2. 选择流
3. 操作
4. 释放资源

## FileInputStream&FileOutPutStream

### FileInputStream

`java.io.FileInputStream `类是文件输入流，从文件中读取字节。

### 构造方法

- `FileInputStream(File file)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。 
- `FileInputStream(String name)`： 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。  

### FileOutPutStream

### 构造方法

- `public FileOutputStream(File file)`：创建文件输出流以写入由指定的 File对象表示的文件。 
- `public FileOutputStream(String name)`： 创建文件输出流以指定的名称写入文件。  

当你创建一个流对象时，必须传入一个文件路径。该路径下，如果没有这个文件，会创建该文件。如果有这个文件，会清空这个文件的数据。

**任务:利用递归,文件夹的拷贝**

## FileReader&FileWriter

`仅适合字符文件`

## ByteArrayInputSteam&ByteArrayOutputStream

**不用关闭**

**一切对象都可以转成字节数组**

**字节数组不要太大**

## 字节缓冲流BufferedInputStream&BufferedOutputStream

直接套上即可

## Serializable序列化接口

当一个对象要能被序列化，这个对象所属的类必须实现Serializable接口。否则会发生异常NotSerializableException异常。

## ObjectInputStream＆ObjectInputStream 对象输入输出流

用于向流中写入对象的操作流 ObjectOutputStream称为 序列化流。
ObjectOutputStream 将 Java 对象的基本数据类型和图形写入 OutputStream。
通过在流中使用文件可以实现对象的持久存储。

注意：只能将支持实现了 java.io.Serializable 接口的对象写入流中。

用于从流中读取对象的操作流 ObjectInputStream称反序列化流。
可以使用 ObjectInputStream 读取（重构）对象。

## 瞬态关键字transient

只要被transient修饰了，序列化时这个属性就不会被序列化了。
同时静态修饰也不会被序列化，因为序列化是把对象数据进行持久化存储，而静态的属于类加载时的数据，不会被序列化。

## Properties类

1 Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串

2 特点

- Hashtable的子类，Map集合中的方法都可以用
- 该集合没有泛型，键值都是字符串
- 它是一个可以持久化的属性集
- 方法

```
load(InputStream) 把指定流所对应的文件中的数据读取出来，保存到Properties集合中
load(Reader)  
store(OutputStream,comments)把集合中的数据，保存到指定的流所对应的文件中，
参数comments代表对描述信息
store(Writer,comments);
```

3 Properties集合，它是唯一一个能与IO流交互的集合

- 添加和获取元素的方法

```
put(key,value)
public Object setProperty(String key, String value)调用 Hashtable的方法put
public Set<String> stringPropertyNames()返回此属性列表中的键集
public String getProperty(String key)用指定的键在此属性列表中搜索属性
```

4 将Properties属性集合中内容存储到文件

- 创建Properties集合
- 添加元素到集合
- 创建流
- 把集合中的数据存储到流所对应的文件中
- 关闭流

5 读取属性文件中的数据，并保存到Properties集合中

- 创建集合
- 创建流对象
- 把流所对应文件中的数据读取到集合中
- 关闭流
- 显示集合中的数据