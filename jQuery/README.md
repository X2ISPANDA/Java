# jQuery学习

1. jQuery的引入

   > ```
   > <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
   > ```

2. 选择器

   > \$("div")
   >
   > ​	选取元素
   >
   > $("*")
   > 	选取所有元素
   > $(this)
   > 	选取当前元素
   > $("p.intro")
   > 	选取 class 为 intro 的 <p> 元素
   > $("#test")
   > 	所有 id="test" 的元素
   > $("p:first")
   > 	选取第一个 <p> 元素
   > $("ul li:first")
   > 	选取第一个 <ul> 元素的第一个 <li> 元素
   > $("ul li:first-child")
   > 	选取每个 <ul> 元素的第一个 <li> 元素
   > $("[href]")
   > 	选取带有 href 属性的元素
   > $("a[target='_blank']")
   > 	选取所有 target 属性值等于 "_blank" 的 <a> 元素
   > $("a[target!='_blank']")
   > 	选取所有 target 属性值不等于 "_blank" 的 <a> 元素
   > $(":button")
   > 	选取所有 type="button" 的 <input> 元素 和 <button> 元素
   > $("tr:even")
   > 	选取偶数位置的 <tr> 元素
   > $("tr:odd")
   > 	选取奇数位置的 <tr> 元素

3. 事件

   - blur()添加/触发失去焦点事件
   - change()添加/触发 change 事件
   - click()添加/触发 click 事件
   - focus()添加/触发 focus 事件
   - hover()添加两个事件处理程序到 hover 事件
   - select()添加/触发 select 事件

4. 样式

   - 直接修改样式

     ```
     $(document).ready(function () {
                 $("tr:odd").css("background-color", "red");
                 $("tr:even").css("background-color","green");
                 $("tr:first").css("background-color", "black");
                 $("tr:eq(3)").css("background-color", "pink");
             });
             
             css({"propertyname":"value","propertyname":"value",...});
     ```

   - 修改所属样式类

     - addClass() 向被选元素添加一个或多个类
     - removeClass() 从被选元素删除一个或多个类

5. 操作HTML文档

   - append()  在被选元素的结尾插入内容
   - prepend() 在被选元素的开头插入内容
   - after()  在被选元素之后插入内容
   - before()  在被选元素之前插入内容
   - remove() 删除被选元素（及其子元素）
   - empty() 从被选元素中删除子元素

```
 function f1() {
            $("#outer").append("div内容").append("<span>我可以</span>");
        }
        function f2() {
            $("#outer").after("<p>添加了个p</p>");
        }

        function f3() {
            $("#outer").remove();
        }

        function f4() {
            $("#outer").empty();
        }
```



*任务*

1：当键盘按下enter键的时候执行的事件
2: 图片滑动(轮播图）
3：项目的增删改查页面

