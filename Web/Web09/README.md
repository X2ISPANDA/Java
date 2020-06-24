

# AJAX

> AJAX(Asynchronous JavaScript and XML，异步的 JavaScript 和 XML) 不是新的编程语言，而是一种使用现有标准的新方法。AJAX 是与服务器交换数据并更新部分网页的艺术，在不重新加载整个页面的情况下。

**XMLHttpRequest 是 AJAX 的基础。**

**异步和同步：**

​	同步：客户端必须等待服务器端的响应。在等待的期间客户端不能做其他操作。
​	异步：客户端不需要等待服务器端的响应。在服务器处理请求的过程中，客户端可以进行其他的操作。

## 实现方式

1. 原生JS实现

   ```javascript
    //1.创建核心对象
   	            var xmlhttp;
   	            if (window.XMLHttpRequest)
   	            {// code for IE7+, Firefox, Chrome, Opera, Safari
   	                xmlhttp=new XMLHttpRequest();
   	            }
   	            else
   	            {// code for IE6, IE5
   	                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
   	            }
   	
   	            //2. 建立连接
   	            /*
   	                参数：
   	                    1. 请求方式：GET、POST
   	                        * get方式，请求参数在URL后边拼接。send方法为空参
   	                        * post方式，请求参数在send方法中定义
   	                    2. 请求的URL：
   	                    3. 同步或异步请求：true（异步）或 false（同步）
   	
   	             */
   	            xmlhttp.open("GET","ajaxServlet?username=tom",true);
   	
   	            //3.发送请求
   	            xmlhttp.send();
   	
   	            //4.接受并处理来自服务器的响应结果
   	            //获取方式 ：xmlhttp.responseText
   	            //什么时候获取？当服务器响应成功后再获取
   	
   	            //当xmlhttp对象的就绪状态改变时，触发事件onreadystatechange。
   	            xmlhttp.onreadystatechange=function()
   	            {
   	                //判断readyState就绪状态是否为4，判断status响应状态码是否为200
   	                if (xmlhttp.readyState==4 && xmlhttp.status==200)
   	                {
   	                   //获取服务器的响应结果
   	                    var responseText = xmlhttp.responseText;
   	                    alert(responseText);
   	                }
   	            }
   ```

2. jquery实现方式

   - $.ajax

       ```javascript
                    $.ajax({
                        url:"ajaxServlet1111" , // 请求路径
                        type:"POST" , //请求方式
                        //data: "username=jack&age=23",//请求参数
                        data:{"username":"jack","age":23},
                        success:function (data) {
                            alert(data);
                        },//响应成功后的回调函数
                        error:function () {
                            alert("出错啦...")
                        },//表示如果请求响应出现错误，会执行的回调函数

                        dataType:"text"//设置接受到的响应数据的格式
                    });
       ```
       
   - $.get

       >    * 语法：$.get(url, [data], [callback], [type])
       >         * 参数：
       >
       >           url：请求路径
       >
       >           data：请求参数
       >
       >           callback：回调函数
       >
       >           type：响应结果的类

   - $.post

       >    * 语法：$.post(url, [data], [callback], [type])
       >         * 参数：
       >
       >           url：请求路径
       >
       >           data：请求参数
       >
       >           callback：回调函数
       >
       >           type：响应结果的类型

   - 主要参数

   | 名称                         | 值/描述                                                      |
   | :--------------------------- | :----------------------------------------------------------- |
   | async                        | 布尔值，表示请求是否异步处理。默认是 true。                  |
   | beforeSend(*xhr*)            | 发送请求前运行的函数。                                       |
   | cache                        | 布尔值，表示浏览器是否缓存被请求页面。默认是 true。          |
   | complete(*xhr,status*)       | 请求完成时运行的函数（在请求成功或失败之后均调用，即在 success 和 error 函数之后）。 |
   | contentType                  | 发送数据到服务器时所使用的内容类型。默认是："application/x-www-form-urlencoded"。 |
   | context                      | 为所有 AJAX 相关的回调函数规定 "this" 值。                   |
   | data                         | 规定要发送到服务器的数据。                                   |
   | dataFilter(*data*,*type*)    | 用于处理 XMLHttpRequest 原始响应数据的函数。                 |
   | dataType                     | 预期的服务器响应的数据类型。                                 |
   | error(*xhr,status,error*)    | 如果请求失败要运行的函数。                                   |
   | global                       | 布尔值，规定是否为请求触发全局 AJAX 事件处理程序。默认是 true。 |
   | ifModified                   | 布尔值，规定是否仅在最后一次请求以来响应发生改变时才请求成功。默认是 false。 |
   | jsonp                        | 在一个 jsonp 中重写回调函数的字符串。                        |
   | jsonpCallback                | 在一个 jsonp 中规定回调函数的名称。                          |
   | password                     | 规定在 HTTP 访问认证请求中使用的密码。                       |
   | processData                  | 布尔值，规定通过请求发送的数据是否转换为查询字符串。默认是 true。 |
   | scriptCharset                | 规定请求的字符集。                                           |
   | success(*result,status,xhr*) | 当请求成功时运行的函数。                                     |
   | timeout                      | 设置本地的请求超时时间（以毫秒计）。                         |
   | traditional                  | 布尔值，规定是否使用参数序列化的传统样式。                   |
   | type                         | 规定请求的类型（GET 或 POST）。                              |
   | url                          | 规定发送请求的 URL。默认是当前页面。                         |
   | username                     | 规定在 HTTP 访问认证请求中使用的用户名。                     |
   | xhr                          | 用于创建 XMLHttpRequest 对象的函数。                         |

# JSON

## 基本概念

**JSON：JavaScript 对象表示法（JavaScript Object Notation）。**

**JSON 是存储和交换文本信息的语法。类似 XML。**

**JSON 比 XML 更小、更快，更易解析。**

## 语法

 1. 基本规则

    - 数据在名称/值对中：json数据是由键值对构成的、
    - 键用引号(单双都行)引起来，也可以不使用引号
    - 值的取值类型：
      1. 数字（整数或浮点数）
      2. 字符串（在双引号中）
      3. 逻辑值（true 或 false）
      4. 数组（在方括号中）	{"persons":[{},{}]}
      5. 对象（在花括号中） {"address":{"province"："陕西"....}}
      6. null

    - 数据由逗号分隔：多个键值对由逗号分隔
    - 花括号保存对象：使用{}定义json 格式
    - 方括号保存数组：[]

	2. 获取数据

    - json对象.键名

    - json对象["键名"]

    - 数组对象[索引]

    - 遍历

      ```javascript
       				//1.定义基本格式
      		        var person = {"name": "张三", age: 23, 'gender': true};
      		
      		        var ps = [{"name": "张三", "age": 23, "gender": true},
      		            {"name": "李四", "age": 24, "gender": true},
      		            {"name": "王五", "age": 25, "gender": false}];
      		        //获取person对象中所有的键和值
      		        //for in 循环
      		       /* for(var key in person){
      		            //这样的方式获取不行。因为相当于  person."name"
      		            //alert(key + ":" + person.key);
      		            alert(key+":"+person[key]);
      		        }*/
      		
      		       //获取ps中的所有值
      		        for (var i = 0; i < ps.length; i++) {
      		            var p = ps[i];
      		            for(var key in p){
      		                alert(key+":"+p[key]);
      		            }
      		        }
      ```

	3. JSON数据和Java对象的互换

    常见JSON解析器：Jsonlib，Gson，fastjson，jackson

    - JSON转换为Java对象

      		1. 导入jackson的相关jar包
      		2. 创建Jackson核心对象 ObjectMapper
      		3. 调用ObjectMapper的相关方法进行转换
      			1. readValue(json字符串数据,Class)

    - Java对象转换为JSON

      **使用步骤：**

      1. 导入jackson的相关jar包

      2. 创建Jackson核心对象 ObjectMapper

      3. 调用ObjectMapper的相关方法进行转换

          - 转换方法：
            - writeValue(参数1，obj):
                  参数1：
                      File：将obj对象转换为JSON字符串，并保存到指定的文件中
                      Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                      OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
            - writeValueAsString(obj):将对象转为json字符串

          - 注解：

          1. @JsonIgnore：排除属性。
          2. @JsonFormat：属性值得格式化
          	* @JsonFormat(pattern = "yyyy-MM-dd")

          - 复杂java对象转换

          1. List：数组
          2. Map：对象格式一致

    