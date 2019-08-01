## 装饰器模式

1. 创建一个接口.
2. 创建实现接口的实体类。
3. 创建实现了接口的装饰类。
4. 使用装饰类

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