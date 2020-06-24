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

el表达式只能从域对象中获取值。

- 获取POJO对象数据

  ${user.属性名}

- 获取List数据

  ${userList[0].属性名}

- 获取Map数据

  ${map\[key值]}
  
- 隐式对象

  	* el表达式中有11个隐式对象
  	* pageContext：
  		* 获取jsp其他八个内置对象
  		* ${pageContext.request.contextPath}：动态获取虚拟目录

# JSTL

1. 概念：JavaServer Pages Tag Library  JSP标准标签库
	
* 是由Apache组织提供的开源的免费的jsp标签		<标签>
	
2. 作用：用于简化和替换jsp页面上的java代码		

3. 使用步骤：
	1. 导入jstl相关jar包
	2. 引入标签库：taglib指令：  <%@ taglib %>
	3. 使用标签

4. 常用的JSTL标签
	1. if:相当于java代码的if语句
		1. 属性：
            * test 必须属性，接受boolean表达式
                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
                * 一般情况下，test属性值会结合el表达式一起使用
   		
      	 2. 注意：
	   
	    		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
   2. choose:相当于java代码的switch语句
   	1. 使用choose标签声明         			相当于switch声明
     2. 使用when标签做判断         			相当于case
	     3. 使用otherwise标签做其他情况的声明    	相当于default
	
	3. foreach:相当于java代码的for语句