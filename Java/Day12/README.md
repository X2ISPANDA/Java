# API中常用的类

## API(Application Programming Interface)

> 应用程序编程接口，又叫类库

## Java中常用的包

- java.lang
- java.lang.reflect
- java.util
- java.sql
- java.net
- java.io

## API中常用类

- Object类

- String类

  - 不同构造方法

  - subString截取字符串
  - startwith
  - endswith
  - indexOf()判断是否包含指定字符串，包含则返回第一次出现该字符串的索引，不包含则返回-1
  - contains()判断是否包含指定字符串，包含返回true，不包含返回false
  - toCharArray()将字符串转成一个字符数组
  - getBytes()将字符串转成一个字节数组
  - equals()判断两个字符串是否相同
  - toString()获取该字符串对象中的内容
  - trim()去除字符串两端空格
  - format()将字符串转换成时间格式
  - valueOf()把一个基本类型数值变成一个字符串
  - 涉及正则表达式的正确用法
    - \代表转义字符，输出\用\\\
    - []代表中括号里的任意一个字符匹配
    - [^abc]代表的是除了 a、b 或 c以外的任何字符
    - [a-zA-Z]代表的是a 到 z 或 A 到 Z，两头的字母包括在内
    - [0-9]代表的是 0到9数字，两头的数字包括在内
    - <span style="font-size:25px;color:red">.</span>所有字符
    - \d代表的是 0到9数字，两头的数字包括在内，相当于[0-9]
    - \w代表的字母或者数字或者下划线(即单词字符)，相当于[a-zA-Z_0-9]
    - ^代表的是行的开头
    - $代表的是行的结尾
    - \b代表的是单词边界,匹配规则为"\b[abc]\b" ，那么代表的是字母a或b或c的左右两边需要的是非单词字符([a-zA-Z_0-9])
    - X?代表的是X出现一次或一次也没有
    - X*代表的是X出现零次或多次
    - X+代表的是X出现一次或多次
    - X{n}代表的是X出现恰好 n 次
    - X{n,}代表的是X出现至少 n 次
    - X{n,m}代表的是X出现至少 n 次，但是不超过 m 次

- StringBuffer类

  > 线程安全的可变字符串，一般用于多线程时

- StringBuilder类

  > 线程非安全的可变字符串，一般用于单线程时

- System类

  > System 类中的属性和方法都是静态属性，所以在调用属性和方法的时候直接通过类名调用就可以.
  
  1. 常用属性
     - System.err
     - System.out
     - System.in
  2. 方法
     - currentTimeMillis()	获取当前系统时间

- Math类

- Date类

- Canlendar

  > ```
  > Calendar是抽象类,需要通过创建它的子类对象创建对象,还可以通过它的getInstance方法获取实例
  > ```

- DateFormat

  > 和Calendar相同,需要通过它的子类对象SimpleDateFormat创建对象,还可以通过它的getDateInstance()方法获取实例

- SimpleDateFormat

- BigInteger类超大整数

- BigDecimal类高精度运算

- 包装类

  - 自动装箱

    将基本数据类型转换成包装类型

    ```
    
    Integer i1 = new Integer(8);
    
    Integer i2 = Integer.valueOf(8);
    
    // 自动装箱
    Integer i3 = 8;
    ```

  - 自动拆箱

    自动将包装类型转换成基本数据类型

    ```
    // 自动拆箱
    int i4 = i3;
    
    int i5 = i3.intValue();
    ```

    

  ![1563870936736](C:\Users\XMY\AppData\Roaming\Typora\typora-user-images\1563870936736.png)