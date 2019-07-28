# Map

![map](https://camo.githubusercontent.com/b1bec94c0070a6b6ab77d8cab1b792789208d21a/687474703a2f2f696d672e626c6f672e6373646e2e6e65742f3230313530383132313534383238373036)

## HashMap集合

键是哈希表结构，可以保证键的唯一性。

往map里放数据,遇到相同Key后面的会把前面的覆盖.


- Map集合遍历
  1. 根据键找值。获取所有键的集合，遍历键的集合，获取到每一个键，根据键找值。
  
  2. 根据键值对对象找键和值。
     - 获取所有键值对对象的集合
     - 遍历键值对对象的集合，获取到每一个键值对对象
     - 根据键值对对象找键和值
  
  3. 直接输出值
  
     ```
     Collection<E> values = map.values();遍历values
     ```
  
- LinkedHashMap 接口的哈希表和链接列表的实现类，具有可预知的迭代顺序。

## TreeMap集合

TreeMap类；可排序；两个构造器；
a)无参构造器；元素所在类必须实现Comparable接口；
b)带有临时比较器的构造器；临时实现Comparator接口；



## HashTable集合

HashMap:无序存放,新的操作类,key不允许重复,采用异步处理方式，性能更高，属于非线程安全的操作类。
Hashtable:无序存放,旧的操作类,key不允许重复，采用同步处理方式，性能更低，属于线程安全的操作类。

**Map接口和Collection接口的不同**
1、Map是双列的,Collection是单列的
2、Map的键唯一,Collection的子类Set集合的值是不重复的，每个值是唯一的
3、Map集合的数据结构值针对键有效，跟值无关
4、Collection集合的数据结构是针对元素有效

## Comparable接口和Comparator接口的区别--比较器

Comparable接口位于 java.lang包下，Comparator接口位于java.util包下。

Comparable: 内部比较器,一个类如果想要使用	Collections.sort(list) 方法进行排序，则需要实现该接口.

Comparator: 外部比较器,用于对那些没有实现Comparable接口或者对已经实现的Comparable中的排序规则不满意进行排序.无需改变类的结构，更加灵活。（策略模式）