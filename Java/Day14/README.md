# 集合

![img](https://i.loli.net/2020/06/24/yFetxOmnIGWjVP4.png)

##### 集合和数组的区别：

- 数组的长度是固定的，集合的长度是可变的。
- 集合中存储的元素是引用数据类型，集合也叫做“对象容器”，可以是基本数据类型的包装类，也可以是其他复合数据类型。
- Java API 中定义好的一系列关于集合的类和接口放在 java .util 包中。

## Collection

Collection：单列集合类的根接口，用于存储一系列符合某种规则的元素，它有两个重要的子接口，分别是List和Set。其中，List的特点是元素有序、元素可重复。Set的特点是元素无序，而且不可重复。List接口的主要实现类有ArrayList和LinkedList，Set接口的主要实现类有HashSet和TreeSet。

![img](https://i.loli.net/2020/06/24/Vqsel1xGbLjhYBF.jpg)

ArrayList遍历:
 	1. 普通for循环
 	2. 增强for循环
 	3. 迭代器

- Collection和Collections的区别

  > java.util.Collection 是一个集合接口。它提供了对集合对象进行基本操作的通用接口方法。Collection接口在Java 类库中有很多具体的实现。Collection接口的意义是为各种具体的集合提供了最大化的统一操作方式。
  > 而java.util.Collections 是一个包装类。它包含有各种有关集合操作的静态方法。此类不能实例化，就像一个工具类，服务于Java的Collection框架。

- Collections常用方法

  - public static <T> void sort(List<T> list)

  使用sort方法可以根据元素的自然顺序 对指定列表按升序进行排序。列表中的所有元素都必须实现 Comparable 接口。此列表内的所有元素都必须是使用指定比较器可相互比较的

  - public static <T> int binarySearch(List<?> list,T key)

  使用二分搜索法搜索指定列表，以获得指定对象。

  - public static <T> T max(Collection<?> coll)

  根据元素的自然顺序，返回给定 collection 的最大元素。

  - public static void reverse(List<?> list)

  反转指定列表中元素的顺序。

  - public static void shuffle(List<?> list)

  混排算法所做的正好与 sort 相反: 它打乱在一个 List 中可能有的任何排列的踪迹。也就是说，基于随机源的输入重排该 List, 这样的排列具有相同的可能性（假设随机源是公正的）。这个算法在实现一个碰运气的游戏中是非常有用的。例如，它可被用来混排代表一副牌的 Card 对象的一个 List 。另外，在生成测试案例时，它也是十分有用的。

  - fill(List<? super T> list, T obj)

  使用指定元素替换指定列表中的所有元素。

  - copy(List<? super T> dest, List<? extends T> src)

  将所有元素从一个列表复制到另一个列表。用两个参数，一个目标 List 和一个源 List, 将源的元素拷贝到目标，并覆盖它的内容。目标 List 至少与源一样长。如果它更长，则在目标 List 中的剩余元素不受影响。

  - 集合线程安全化

  List<T> synchronizedList(List<T> list);//返回支持的同步（线程安全的）List集合

  Map<K,V> synchronizedMap(Map<K,V> m)：返回支持的同步（线程安全的）Map集合

- Arrays工具类

- LinkedList

  > LinkedList集合数据存储的结构是链表结构。方便元素添加、删除的集合。实际开发中对一个集合元素的添加与删除经常涉及到首尾操作，而LinkedList提供了大量首尾操作的方法。

  - LinkedList<-->ArrayList 通过构造方法和addAll方法转换

## Set

<span style="color:red;font-size:25px">set是无序(存取顺序不同)且不能重复的</span>

***set遍历不能用普通for循环,需要用增强for循环和迭代器***

- HashSet
  1. 元素唯一，无序，不能重复
  2. 底层结构是哈希表结构
  3. 元素的存与取的顺序不能保证一致
- LinkedHashSet
  1. 元素唯一，有序，不能重复
  2. 底层结构是 哈希表结构 + 链表结构， 由链表保证元素有序，由哈希表保证元素唯一
  3. 元素的存与取的顺序一致
  
- TreeSet

  底层数据结构是红黑树.

## Map

![QQ图片20200623025012](https://i.loli.net/2020/06/24/8Ero5Q4sdRbx1kw.png)

### HashMap集合

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

### TreeMap集合

TreeMap类；可排序；两个构造器； a)无参构造器；元素所在类必须实现Comparable接口； b)带有临时比较器的构造器；临时实现Comparator接口；

### HashTable集合

HashMap:无序存放,新的操作类,key不允许重复,采用异步处理方式，性能更高，属于非线程安全的操作类。 Hashtable:无序存放,旧的操作类,key不允许重复，采用同步处理方式，性能更低，属于线程安全的操作类。

**Map接口和Collection接口的不同** 1、Map是双列的,Collection是单列的 2、Map的键唯一,Collection的子类Set集合的值是不重复的，每个值是唯一的 3、Map集合的数据结构值针对键有效，跟值无关 4、Collection集合的数据结构是针对元素有效

### Comparable接口和Comparator接口的区别--比较器

Comparable接口位于 java.lang包下，Comparator接口位于java.util包下。

Comparable: 内部比较器,一个类如果想要使用	Collections.sort(list) 方法进行排序，则需要实现该接口.

Comparator: 外部比较器,用于对那些没有实现Comparable接口或者对已经实现的Comparable中的排序规则不满意进行排序.无需改变类的结构，更加灵活。（策略模式）