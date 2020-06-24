# Lambda表达式

Lambda是一个**匿名函数**，可以理解为一段可以传递的代码（将代码像数据一样传递）；可以写出更简洁、更灵活的代码；作为一种更紧凑的代码风格，是Java语言表达能力得到提升。

## 匿名内部类

```java
@Test
public void test01(){
    //匿名内部类
    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1,o2);
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    };
    //调用
    TreeSet<Integer> set = new TreeSet<>(comparator);
}

```

## Lambda

```java
@Test
public void test02(){
    // Lambda 表达式
    Comparator<Integer> comparator = (a, b) -> Integer.compare(a, b);

    TreeSet<Integer> set = new TreeSet<>(comparator);
}
```

## 函数式接口

Java内置四大核心函数式接口：

| 函数式接口                | 参数类型 | 返回类型 | 用途                                                         |
| ------------------------- | -------- | -------- | ------------------------------------------------------------ |
| Consumer 消费型接口       | T        | void     | 对类型为T的对象应用操作：void accept(T t)                    |
| Supplier 提供型接口       | 无       | T        | 返回类型为T的对象：T get()                                   |
| Function<T, R> 函数型接口 | T        | R        | 对类型为T的对象应用操作，并返回结果为R类型的对象：R apply(T t) |
| Predicate 断言型接口      | T        | boolean  | 确定类型为T的对象是否满足某约束，并返回boolean值：boolean test(T t) |

1. 消费型接口

   ```java
   @Test
   public void test01(){
       //Consumer
       Consumer<Integer> consumer = (x) -> System.out.println("消费型接口" + x);
       //test
       consumer.accept(100);
   }
   
   ```

   

2. 提供型接口

   ```java
   @Test
   public void test02(){
       List<Integer> list = new ArrayList<>();
       List<Integer> integers = Arrays.asList(1,2,3); 
       list.addAll(integers);
       //Supplier<T>
       Supplier<Integer> supplier = () -> (int)(Math.random() * 10);
       list.add(supplier.get());
       System.out.println(supplier);
       for (Integer integer : list) {
           System.out.println(integer);
       }
   }
   
   ```

   

3. 函数型接口

   ```java
   @Test
   public void test03(){
       //Function<T, R>
       String oldStr = "abc123456xyz";
       Function<String, String> function = (s) -> s.substring(1, s.length()-1);
       //test
       System.out.println(function.apply(oldStr));
   }
   
   ```

   

4. 断言型接口

   ```java
   @Test
   public void test04(){
       //Predicate<T>
       Integer age = 35;
       Predicate<Integer> predicate = (i) -> i >= 35;
       if (predicate.test(age)){
           System.out.println("你该退休了");
       } else {
           System.out.println("我觉得还OK啦");
       }
   }
   ```

   

# 方法引用与构造器引用

## 方法引用

**定义：**若 Lambda 表达式体中的内容已有方法实现，则我们可以使用“方法引用”。

语法格式：

- 对象 :: 实例方法

  前提是传入的参数和返回值一致。

- 类 :: 静态方法

- 类 :: 实例方法

  **条件：**Lambda 参数列表中的第一个参数是方法的调用者，第二个参数是方法的参数时，才能使用 ClassName :: M

## 构造器引用

格式：

- ClassName :: new

  **注意：**需要调用的构造器的参数列表要与函数时接口中抽象方法的参数列表保持一致

# Stream

Stream（流）是一个来自数据源的元素队列并支持聚合操作。

**注意：**

1. Stream自己不会存储元素
2. Stream不会改变源对象。相反，他们会返回一个持有结果的新的Stream
3. Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才会执行。

**Stream操作的三个步骤：**

- **创建数据流**
- **衔接操作**
- **终止操作**

## 创建流

1.  可以通过Collection系列集合中的stream()或者parallelStream()方法获取串行流或者并行流。

   ```java
   List<String> list = new ArrayList<>();
   Stream<String> stream = list.stream();
   ```

2. 通过Arrays中的静态方法stream()方法获取数组流。

   ```java
   Arrays.asList("a1", "a2", "a3").stream();
   ```

3. 通过Stream类中的静态方法of()方法获取流，可以从一系列对象引用中创建数据流。

   ```java
   Stream<String> stream = Stream.of(“aa”,”bb”,”cc”);
   ```

4. 创建无限流

   ```java
   //迭代
   Stream<Integer> stream = Stream.iterate(0,(x) -> x+ 2);
   Stream.limit(10).forEach(System.out::println)
   //生成
   Stream.generate(()->Math.random()).forEach(System.out::println);
   ```

5. java8提供了一些特殊种类的流，用于处理基本数据类型int，long，double。分别为IntStream，LongStream，DoubleStream。

## 中间操作

中间操作只有在终止操作调用时才会被执行。

### 筛选与切片

> filter—接收Lambda，从六中排除某些元素
> limit—截断流，使其元素不超过给定数量
> skip(n)—跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit互补
> distinct—筛选，通过流所生成元素的hashCode()和equals()去除重复元素
>
> 内部迭代：迭代操作有Stream API完成
> 外部迭代：自己编写迭代操作

### 映射

> **map**—接收Lambda，将元素转换成其他形式或提取信息。接收一个函数操作参数，该函数会应用到每个元素上，并将其映射成一个新的元素。 flatMap—接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流链接成一个流

### 排序

> **sorted**()—自然排序 **sorted**(Comparator com)—定制排序

## 终止操作

- 查找与匹配

  > allMatch—检查是否匹配所有元素
  > anyMatch—检查是否至少匹配一个元素
  > noneMatch—检查是否没有匹配所有元素
  > findFirst—返回当前流中的第一个元素
  > findAny—返回流中元素的任意元素
  > count—返回流中元素的总个数
  > max—返回流中的最大值
  > min—返回流中的最小值

- 归约

  ```java
  ruduce(T identity,BinaryOperator) / ruduce(BinaryOperator) –可以将流中元素反复结合起来，组合为单一结果。
  ```

- 收集

  ```java
  collect—将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法，将流中的元素存放在不同类型的结果中。Java8通过内置的 Collectors 类支持多种内置的收集器。
  
  List<Person> filtered = persons.stream()
                                  .filter(p -> p.name.startsWith("P"))
                                  .collect(Collectors.toList());
  System.out.println(filtered); // [Peter, Pamela]
  ```

## 并行流和串行流

**串行流：**在一个线程上执行一个内容。

```java
Arrays.asList("a1", "a2", "a3")
        .stream()
        .findFirst()
        .ifPresent(System.out::println);
```

**并行流：**就是把一个内容分成多个数据快，并用不同的线程分别处理每个数据块的流。并行流能够在多个线程上执行操作。主要是为了解决处理大量元素时的性能问题。

```java
Arrays.asList("a1", "a2", "a3")
        .stream()
        .findFirst()
        .parallel()
        .ifPresent(System.out::println);
--------------------------------------------------------------------
Arrays.asList("a1", "a2", "a3")
        .parallelStream()
        .findFirst()
        .ifPresent(System.out::println);
```

**“工作窃取”算法**：是指某个线程从其他队列里窃取任务来执行。

# Optional类

Optional类是一个容器类，代表一个值存在或不存在，可以避免空指针异常。Optional不是一个函数式接口，而是一个精巧的工具接口，用来方式NullPointException异常。Optional是一个简单的值容器，这个值可以是null，也可以是non-null，为了不直接返回null，我们在Java 8中就返回一个Optional类，使用Optional类可以避免使用if进行null检查，这种检查的过程交由底层自动处理。主要有如下一些方法：

> of(T t) : 创建一个Optional实例
> empty() : 创建一个空的Optional实例
> ofNullable(T t) :  若t不为null，创建Optional实例，否则创建空的Optional实例
> isPresent() : 判断是否包含值
> orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
> orElseGet(Suppplier s) : 如果调用对象包含值，返回该值，否则返回s获取的值
> map(Function f) : 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
> flatMap(Function mapper) : 与map类似，要求返回值必须是Optional

# 新时间和日期API

解决了传统时间API的线程安全问题。

- LocalDateTime、LocalDate、LocalTime

  ```java
   LocalDateTime localDateTime = LocalDateTime.now();
          System.out.println(localDateTime);
          LocalDateTime localDateTime1 = LocalDateTime.of(2020, 9, 29, 10, 50, 32, 22);
          System.out.println(localDateTime1);
  
          localDateTime.plusYears(5);
          localDateTime.minusHours(3);
          localDateTime.getDayOfMonth();
  ```

- Instant时间戳

  Unix元年1970/01/01 00:00:00到某个时间的毫秒值。

  ```java
  Instant now = Instant.now();//默认获取UTC时区
          OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
          System.out.println(now + "北京:" + offsetDateTime);
          System.out.println(now.toEpochMilli());
          System.out.println(Instant.ofEpochMilli(60));
  ```

- 时间计算

  Duration：计算两个时间之间的间隔。

  Period：计算两个日期之间的间隔。

  ```java
  Instant instant = Instant.now();
  Thread.sleep(1000);
  Instant instant1 = Instant.now();
  System.out.println(Duration.between(instant, instant1).toMillis());
  LocalDate localDate = LocalDate.now();
  LocalDate localDate1 = LocalDate.of(1998, 3, 29);
  System.out.println(Period.between(localDate, localDate1));
  ```

  

- 时间操纵

  TemporalAdjusters

  ```java
  LocalDateTime localDateTime = LocalDateTime.now();
  
          System.out.println(localDateTime);
  
          LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);//指定几号
          System.out.println(localDateTime1);
  
          LocalDateTime with = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
          System.out.println(with);
  
          localDateTime.with((l)->{
              LocalDateTime localDateTime2 = (LocalDateTime) l;
              DayOfWeek dayOfWeek = localDateTime2.getDayOfWeek();
              if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                  return localDateTime2.plusDays(3);
              } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)){
                  return localDateTime2.plusDays(2);
              }else {
                  return localDateTime2.plusDays(1);
              }
          });
  ```

- 时间格式化

  ```java
   DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
          DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
          LocalDateTime localDateTime = LocalDateTime.now();
          String strDate = localDateTime.format(dateTimeFormatter);
          String strDate2 = dateTimeFormatter1.format(localDateTime);
          System.out.println(strDate);
          System.out.println(strDate2);
  ```

- 时区

  ```java
          LocalDateTime turkey = LocalDateTime.now(ZoneId.of("Turkey"));
          ZonedDateTime zdt = turkey.atZone(ZoneId.of("Turkey"));
          System.out.println(turkey);
          System.out.println(zdt);
  ```

  

# 重复注解和类型注解



