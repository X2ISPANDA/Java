# EL(Expression Language)

`作用：用来替代<%=...%>`

- 减少JSP中 Java 代码。
- 方便JSP中代码的修改，降低维护成本。
- 方便非Java工作者（美工修改外观）对页面的修改。

<span style="font-size:25px;font-weight:bold;color:red">格式：${el表达式}</span>

<b>注意: </b>

<b>1.在EL表达式中，习惯使用单引号’’来表示一个字符串，虽然使用双引号””也是没有问题的。如果输出的内容为一个表达式，我们可以直接编写表达式。</b>

<b>2.如果希望整个JSP忽略EL表达式，需要在page指令中指定isELIgnored=”true”。</b>

<b>3.EL不显示null，当EL表达式的值为null对象时，会在页面上显示空白，即什么都不显示。</b>

## EL数据访问

- 获取POJO对象数据

  ${user.属性名}

- 获取List数据

  ${userList[0].属性名}

- 获取Map数据

  ${map\[key值]}

