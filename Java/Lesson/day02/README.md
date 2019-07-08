# Java基础语法

## 一、关键字、保留字、标识符

1. 关键字、保留字

> Java中有特殊含义的字符

- 51个关键字：abstract、assert、boolean、break、byte、case、catch、char、class、continue、default、do、double、else、enum、extends、final、finally、float、for、if、implements、import、int、interface、instanceof、long、native、new、package、private、protected、public、return、short、static、strictfp、super、switch、synchronized、this、throw、throws、transient、try、void、volatile、while、ture、false、null

- 2个保留字：goto、const

2. 标识符

- 标识符由字母、数字、下划线“_”、美元符号“$”组成，可以是中文。
- 不能以数字开头
- 严格区分大小写
- 关键字不能做标识符

## 二丶Java的编码规范

1. 包名：全部都要小写
2. 类名、接口
   - 首字母大写、驼峰原则
   - 接口名以I开头
3. 变量名/属性/方法名：第一个单词小写，驼峰原则
4. 常量：全部大写
5. 运算符、关键字左右两侧加空格
6. 缩进4个空格

## 三丶变量和常量

1. 变量的含义

   > 内存中存放数据的空间

2. 变量的声明及初始化

   - 先声明后赋值
   - 声明同时赋值

3. 变量的分类

   - 局部变量：方法内部定义
   - 全局变量（成员变量）：类的内部定义，如果不进行初始化Java会用默认值进行自动初始化

4. 注意事项

   - 局部变量不初始化不能使用
   - 变量使用时有作用域的限制
   - 不可以重复定义

5. 常量的声明以及使用

   > 在程序运行中始终保持不变的值

   ​    final   double  PI  = 3.14159;

## 四丶数据类型

1. 数据类型的分类

   - 基本数据类型

     > String不属于基本数据类型

     - 整数型
       1. byte[-128,127]一字节
       2. short[-32768,32767]两字节
       3. int[-2^31,2^31-1]四字节
       4. long[-2^63,2^63-1]八字节
     - 浮点型
       1. float单精度浮点类型，四字节
       2. double双精度浮点类型，八字节
     - 字符型char
     - 布尔型boolean

   - 复合数据类型

     - 数组
     - 类
     - 接口

2. 简单数据类型的转换

   - 强制转换：高级类型转换到低级类型
   - 自动转换：低级类型转换为高级类型