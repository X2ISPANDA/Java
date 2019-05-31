# JavaScript

​		HTML定义了网页的内容，CSS描述了网页的布局,那么JavaScript就是在定义网页的行为。JavaScript 是一种脚本语言，原名叫 LiveScript，为了更好的推广脚本语言，所以起名为 JavaScript，和 Java 并没有什么关系。JavaScript 本身可以跨平台的。当用户在客户端显示该网页时，浏览器就会执行JavaScript程序，用户通过交互的操作来改变网页的内容，来实现HTML语言无法实现的效果。 JavaScript的作用主要分为两类:动态操纵HTML的动作和改变HTML元素的样式,例如,对表单的各项校验、修改元素的外观、内容。

## JavaScript基本用法

1. 引用方式
   - HTML文档中:\<script>JS代码\</script>
   - 调用JS文件:\<script src="文件地址" type="text/javascript">\</script>
2. 几个基本函数
   - 弹出提示框:alert();
   - 编写页面内容document.write();
   - 调试程序,输出到浏览器控制台:console.log("");
3. JavaScript的执行顺序
   - &lt;head>部分js代码将在页面加载完之前被载入。
   - &lt;body>部分js代码将在页面载入的时候被执行。
   - &lt;html>标签后的代码将在页面载入完成之后被执行。

## JavaScript基础语法

### 注释

- 单行注释://注释内容
- 多行注释:/\*注释内容*/

### 变量

#### 变量的定义方式

- 隐式定义
- 显式定义  var

**驼峰原则**

**JavaScript中的变量是弱类型的**

#### JavaScript中的数据类型

1. 数值类型

   - 整数
   - 浮点数

2. 布尔类型

   - ture
   - false

3. 字符串类型

4. 特殊类型

   - undefined
   - null

5. 复合数据类型

   - 数组

     - 数组的三种声明方式
       1. var i=new Array();i[0]=1; i[1]=2;
       2. var j=new Array("a","b","c");
       3. var a = [3,5,1]

   - 函数

     函数的声明方式

     ​	function  functionname(){}

   - 对象

     - 声明方式1:var 变量名={属性名:值,属性名:值,....}
     - 声明方式2:var 变量名=new Object();变量名.属性名=值;变量名.属性名=值
     - 获取对象属性的两种方式
       - object.属性名
       - object["属性名"]

6. 数据类型转换

   - typeof标识符:用于获取变量的数据类型

     ​	判断结果: 

     - undefined	: undefined

- null : object
      - 布尔类型：boolean

- 数字类型：number
      - 字符串：string

- 对象：object
      - 函数：function

  - 显式数据类型转换

    ##### 数值类型

    - Number()函数
      - 如果转换的内容本身就是一个数值类型的字符串，那么将来在转换的时候会返回自己。
      - 如果转换的内容本身不是一个数值类型的字符串，那么在转换的时候结果是NaN.
    - 如果要转换的内容是空的字符串，那以转换的结果是0.
      - 如果是布尔值,true转换为1,false转换为0
    - parseInt()函数:将要转换的变量转换为数值类型且是整数
      - 忽略字符串前面的空格，直至找到第一个非空字符,还会将数字后面的非数字的字符串去掉。
      - 如果第一个字符不是数字符号或者负号，返回NaN
    - 会将小数取整。（向下取整）
      - 布尔值转换结果是NaN
    - parseFloat()函数:将要转换的变量转换为数值类型且是浮点类型
      - 使用toFixed()函数定义小数点位数
    - 其他规则同parseInt()函数

    ##### 字符串类型

    - 使用String转换
    - 使用toString()函数

    ##### 布尔型

    - Boolean()函数

      在进行boolean转换的时候所有的内容在转换以后结果都是true，除了：false、""（空字符串）、0、NaN、undefined

  - 隐式数据类型转换

    ##### 数值类型

    ​	加减乘除以及最余都可以让字符串隐式转换成number.

    ##### 字符串类型

    ​	加号运算符：数字和字符串相加，字符串支持加法操作，所以将数字转为字符串做链接功能

    ##### 布尔型

    ​	两个布尔类型的值相加减的时候将true转换为1，false转换为0

#### 表达式和运算符

##### 表达式

​	由运算元和可选运算符构成,并能产生运算结果的语法结构叫做表达式。例如var x=y+z;true;a

##### 运算符

- 赋值运算符

  =

- 算数运算符

  \+ 加法运算

  \- 减法运算

  \* 乘法运算

  / 除法运算

  % 取余运算

  ++ 累加运算

  -- 累减运算

- 比较运算符

  \> 大于

  \>= 大于等于

  \< 小于

  \<= 小于等于

  != 值不等于

  == 值相等判断

  !== 值或数据类型不相等

  === 值和数据类型相等

- 逻辑运算符

  &&与

  ||或

  !非

  优先级 非>与>或

- 三目运算符

  条件?条件成立分支:条件不成立分支

##### 语句和流程控制语句

- 选择结构

  if(条件){}

  if(条件){}else{}

  if(条件){}else if(条件){}

  switch(表达式){case 值:……;break;}

- 循环结构

  for(;;){}

  while(条件){}

  do{}while(条件)

#### 数组

> 数组对象的作用是：使用单独的变量名来存储一系列的值。

- JS数组与Java数组的区别
  - 数组定义时无需指定数据类型
  - 数组定义时无需指定数组长度
  - 数组可以存储任意数据类型的元素(即在JS的数组中存储的元素之间数据类型可以不相同)。

##### 创建数组

- var a = [3,5,1]
- var i=new Array();i[0]=1; i[1]=2;
- var b=new Array(1,"a");

##### 数组的读写

- a[index]=x;

##### 数组的遍历

- for(  index  in object){}
- for(var i=0;i<object.length;i++){}

#### 函数

> 函数在任何一门语言里都是核心的概念，通过函数可以封装任意多条程序语句,而且在任意地方、任意时候调用执行,在JavaScript中,一个函数可以嵌套在另一个函数中进行定义,这样他们就可以访问他们被定义时所处的作用域中的任意变量,这个特性给JavaScript带来了非常强劲的编程能力。

##### 函数的创建

- function  functionname(){}



#### 全局变量和局部变量

##### 全局变量 

- 定义方式

  1. 在函数体外通过var关键字声明的变量
  2. 在函数内不通过关键字var关键字声明的变量
  3. 使用window全局对象来声明的变量

- 调用

  可以在JS任意地方调用全局变量

##### 局部变量

- 定义方式

  1. 在函数体内通过var关键字声明的变量
  2. 函数的参数

- 调用

  只能在当前函数体内调用

##### 函数中的this关键字

​	函数内部的this指针指向的是函数的调用者

##### 优先级

​	局部变量>参数变量>全局变量

##### 局部函数

> 一个函数可以嵌套在另一个函数中进行定义,这就是局部函数

- 局部函数只能在定义他的全局函数内被调用
- 局部函数可以使用定义他的全部函数所定义的局部变量
- 但是定义他的全局函数不能使用局部函数定义的局部变量

#### 对象

##### 构造函数的定义

```构造函数的定义
	var MyObject=function(name,age){
		this.name=name;
		this.age=age;
		this.run=function(){
		document.write(name+"run方法被执行了");
		}
	}
	
	var a=new MyObject("张三",20);
```

- 构造函数名首字母大写
- 在构造函数内可以定义基于该模板创建的对象所拥有的属性
- 在构造函数内可以定义基于该模板创建的对象可以执行的方法
- 构造函数内的this关键字指向基于该模板所创建的对象
- 基于构造函数创建对象时,采用new关键字



##### 对象的创建

- new关键字
- Object对象式
- JSON式

##### 遍历对象中的属性

- object.属性名
- object["属性名"]

##### 内置对象

- String
  - substring():提取字符串中两个指定索引下标之间的字符串
  - replace():替换字符串中的部分字符
  - split:将字符串依据某一个字符串分割为字符串数组
- Date
  - Date():获取当前时间
  - getFullYear():获取当前年份
  - getMonth():返回的是0-11月份
  - getDay():返回以周为计量单位的0~6时间
  - getDate():返回以月为计量单位的1~31
- Math
  - ceil():向上取整
  - floor():向下取整
  - round():四舍五入
  - random():取一个0-1的随机数[0,1)

#### 事件

> 当HTML文档或者浏览器窗口发生的一些特定交互瞬间，例如按钮的被点击,用户打开页面,下拉选的被选中,input文本框获得焦点的瞬间等,我们通过监听器监听到以上事件的发生,并指定在发生特定事件时所要执行的代码。

##### 常用事件

- onload()事件:页面的载入时触发该事件。
- onfocus()事:当H5元素获得焦点时触发该事件。
- onblur()事件:当H5元素失去焦点时触发该事件。
- onclick()事件:当H5元素被点击时触发该事件。
- onchange()事件:当H5元素的值被改变时触发该事件。



## DOM模型

 1. DOM模型概述

    > JavaScript是代码,而HTML中的元素是标记,这是完全不同的东西,如何让他们产生交互,我们虽然提到过了事件,但是那是必须当用户的操作触发某一个元素的事件条件事才可以被动的产生HTML和JS的交互,我们如何做到随时随地的进行JS和HTML的交互?依据W3C DOM规范,当一个HTML网页被加载时,浏览器会构建页面的文档对象模型(Document Object Model),也就是我们说的DOM模型,通过DOM模型。

	2. DOM模型的HTML的关系

    > DOM是将HTML按照层次结构/所属关系来进行解析，形成了一个树状结构，DOM树，而树中的标签，
    >
    > 文本甚至属性都称之为节点，这些节点也称之为对象。
    >
    > DOM解析的好处：是可以对树中的节点进行任意的操作，比如增删改查。
    >
    > 缺点:是将整个标记型文档加载进入内存，意味着如果文档体积很大，就会比较浪费内存空间。
    >
    > 通过DOM模型,我们可以在JS中访问所有的HTML元素,连同他们所包含的文本和属性,并可以动态的修改HTML元素的属性、样式;创建、删除HTML文档中的元素,并能够对页面中所有元素的所有事件做出反应

	3. 访问HTML元素

    - 按照ID访问元素

      > document.getElementByID("IDname")

    - 按照class标签访问元素

      > document.getElementsByClassName()

    - 按照name属性访问元素

      > document.getElementsByName()

    - 按照标签名访问元素

      > document.getElementsByTagName("tagName")

    - 按照CSS选择器访问元素

      > querySelectorAll()
      >
      > querySelector()

    - 利用节点关系访问元素

      > 节点元素的父节点
      > 	document.parentNode
      > 节点元素的子节点
      > 	document.childNodes
      > 返回节点元素的前一个兄弟节点
      > 	document.previousSibling
      > 返回节点元素的后一个兄弟节点
      > 	document.nextSibling
      > 返回节点的第一个子节点
      > 	document.firstChild
      > 返回节点的最后一个子节点
      > 	document.lastChild

    - 访问HTML内容

      > ocument.getElementById(id).innerHTML=新文本

    - 访问或修改HTML的属性

      > document.getElementById(id).attribute=new value

    - 脚本化CSS

      >document.getElementById(id).style.property=new style

    - 脚本化事件

      > document.getElementById("myBtn").event=function(){};

    - 编辑HTML节点

      - 创建HTML节点

        > 文本节点
        > 	document.createTextNode("")
        > 元素节点
        > 	document.createElement("p")

      - 插入HTML节点

        > appendChild()
        > insertBefore(插入的节点，插入的位置)

      - 删除HTML节点

        > removeChild(child)

      - 替换HTML节点

        > replaceChild(para,child);

	4. 正则表达式

    > 正则表达式的主要作用是对字符串的格式执行模糊匹配

## BOM模型

> 浏览器对象模型 ( Browser Object Model) 使 JavaScript 有能力与浏览器“对话”。例如：获取浏览器窗口的尺寸、获取浏览器访问过的历史记录



- window:表示浏览器窗口
- screen:表示屏幕信息
- history:浏览历史
  - history.back():返回上一个网页
  - history.go():加载某个具体网页
- 浏览器对话框
  - alert
  - comfirm:确认框
  - prompt *adj.迅速的 n.提示符*():显示可提示用户进行输入的对话框
- 浏览器定位:Location
  - Location.href=URL:返回当前显示的文档的完整 URL
  - location.assign(URL):加载一个新文档
- 浏览器定时器
  - setInterval(code,millisec)
  - clearInterval(id_of_setinterval):取消由 setInterval() 设置的 timeout



*任务*

1. 设计一个简单的可验证的登录界面

2. 可更新的时间