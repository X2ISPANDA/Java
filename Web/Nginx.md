# Nginx

![img](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/94cad1c8a786c917f04d4592c33d70cf3ac757ca)

## 1. 基本概念

Nginx（“engine X”）是一款轻量级的Web 服务器/反向代理服务器及电子邮件（IMAP/POP3）代理服务器，在BSD-like 协议下发行。其特点是占有内存少，并发能力强，事实上nginx的并发能力在同类型的网页服务器中表现较好，中国大陆使用nginx网站用户有：百度、京东、新浪、网易、腾讯、淘宝等。

- 反向代理

  反向代理服务器位于用户与目标服务器之间，但是对于用户而言，反向代理服务器就相当于目标服务器，即用户直接访问反向代理服务器就可以获得目标服务器的资源。同时，用户不需要知道目标服务器的地址，也无须在用户端作任何设定。反向代理服务器通常可用来作为Web加速，即使用反向代理作为Web服务器的前置机来降低网络和服务器的负载，提高访问效率。

- 负载均衡

  负载均衡（Load Balance）其意思就是分摊到多个操作单元上进行执行，例如Web服务器、FTP服务器、企业关键应用服务器和其它关键任务服务器等，从而共同完成工作任务。

- 动静分离

  动态资源(jsp、ftl、thymeleaf)与静态资源(js、css、img)分开部署。

## 2. Nginx安装

1. 安装编译工具及库文件

   ```shell
   yum -y install gcc pcre-devel zlib-devel openssl openssl-devel
   ```
   
2. 官网下载Nginx压缩包

3. 移动到/usr/local/下

4. 解压

   ```shell
   tar -zxvf nginx-1.9.9.tar.gz
   ```

5. 进入nginx目录

   ```shell
   cd nginx-1.9.9
   ```

6. 配置

   ```shell
   ./configure --prefix=/usr/local/nginx
   ```

7. 编译

   ```shell
   make
   make install
   ```

8. 测试

   ```shell
   cd ..
   cd nginx
   ./sbin/nginx -t
   ```

## 3. Nginx配置文件

1. 配置文件位置

   /usr/local/nginx/conf/nginx.conf

2. nginx配置文件组成

   - 全局块

     从配置文件开始到events块的内容，主要会设置一些影响nginx服务器整体运行的配置指令。

     比如worker_processes        1；值越大，支持并发处理量越多。

   - Events块

     影响Nginx服务器与用户网络的连接。

     比如worker_connections    1024；支持的最大连接数

   - http块

     Nginx配置最频繁的部分

     - http全局块
     - server块

## 4. Nginx配置实例

### 4.1 反向代理

**实现效果1：打开浏览器，在浏览器地址栏输入地址www.123.com跳转到linux系统tomcat主界面。**

1. 安装tomcat

   > 1. 下载Tomcat安装包，解压
   > 2. 进入bin目录，输入./startup.sh启动

2. 开放端口

   ```shell
   firewall-cmd --add-port=8080/tcp --permanent
   firewall-cmd -reload//重启防火墙
   
   ```

   或者学习阶段直接关闭防火墙

   ```shell
   systemctl stop firewalld
   ```

3. 修改hosts

4. 在nginx进行请求转发的配置

   ![image-20200621221514079](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200621221514079.png)

5. 重启nginx

   ```shell
   ./nginx -s reload
   ```


**实现效果2：使用nginx反向代理，根据访问的路径跳转到不同端口的服务中，nginx监听端口为9001**

1. 启动两个Tomcat

   其中一个在conf/server.xml中修改启动端口为8081

2. 创建文件夹和测试页面

3. 修改配置文件

   ![image-20200622043218321](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622043218321.png)

4. 测试结果

   ![image-20200622042923980](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622042923980.png)

![image-20200622042935596](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622042935596.png)

### 4.2 负载均衡

#### 4.2.1 实现步骤

**实现效果：在浏览器输入地址192.168.75.128/edu/a.html，平均分配到8080和8081端口中去。**

1. 启动两个Tomcat

2. 在两台tomcat的webapps目录中，都创建一个名称是edu的文件夹，在edu文件夹中创建页面a.html用于测试

3. 在Nginx的配置文件夹中进行负载均衡的配置

   ![image-20200622162821884](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622162821884.png)

![image-20200622162833968](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622162833968.png)

#### 4.2.2 主要策略

- 轮询（默认）

  平均分配客户端。

- weight

  根据权重分配，权重越高被分配的客户端越多。用于性能不均的情况。

  ![image-20200622163616825](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622163616825.png)

- ip_hash

  每个请求根据ip的hash值进行分配，每个访客固定访问一个服务器，解决了session的问题。

  ![image-20200622163938040](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622163938040.png)

- fair（第三方）

  根据后端服务器的响应时间来分配，响应时间短的优先分配。

  ![image-20200622164022165](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622164022165.png)

### 4.3 动静分离

1. 准备静态资源

2. 配置nginx

   ![image-20200622170009939](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622170009939.png)

3. 效果

   ![image-20200622170601031](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622170601031.png)



![image-20200622170714467](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/image-20200622170714467.png)

### 4.4 高可用集群

> 高可用HA（High Availability）是分布式系统架构设计中必须考虑的因素之一，它通常是指，通过设计减少系统不能提供服务的时间。
>
> 如何保障系统的高可用？
>
> 我们都知道，单点是系统高可用的大敌，单点往往是系统高可用最大的风险和敌人，应该尽量在系统设计的过程中避免单点。方法论上，高可用保证的原则是“集群化”，或者叫“冗余”：只有一个单点，挂了服务会受影响；如果有冗余备份，挂了还有其他backup能够顶上。
>
> [参考](https://www.cnblogs.com/shizhiyi/p/7750530.html)

1. 在两台服务器中安装nginx

2. 在两台服务器中安装keepalived

   ```shell
   yum install keepalived -y
   ```

3. 修改keepalived配置文件

   ```shell
   cd /etc/keepalived/
   vi keepalived.conf 
   ```

   ```conf
   #全局配置
   global_defs {
   
   notification_email {
   
   acassen@firewall.loc
   
   failover@firewall.loc
   
   sysadmin@firewall.loc
   
   }
   
   notification_email_from Alexandre.Cassen@firewall.loc
   
   smtp_server 192.168.17.129
   
   smtp_connect_timeout 30
   
   router_id LVS_DEVEL ##访问到主机
   
   }
   
   vrrp_script chk_http_port {
   script "/usr/local/src/nginx_check.sh"
   
   interval 2	#（检测脚本执行的间隔）
   
   weight 2 #权重
   
   }
   
   vrrp_instance VI_1 {
   
   state BACKUP	# 备份服务器上将 MASTER 改为 BACKUP
   
   interface ens33	//网卡
   
   virtual_router_id 51	# 主、备机的 virtual_router_id 必须相同
   
   priority 100	# 主、备机取不同的优先级，主机值较大，备份机值较小
   
   advert_int 1
   
   authentication {
   
   auth_type PASS
   
   
   auth_pass 1111
   
   }
   
   virtual_ipaddress {
   
   192.168.17.50 // VRRP H 虚拟地址
   
   }
   
   }
   ```

4. 在`/usr/local/src`添加检测脚本

   ```sh
   #!/bin/bash
   A=`ps -C nginx –no-header |wc -l`
   if [ $A -eq 0 ];
       then /usr/local/nginx/sbin/nginx
       sleep 2
       if [ `ps -C nginx --no-header |wc -l` -eq 0 ];
       	then killall keepalived
       fi
    fi
   ```

5. 把两台服务器上nginx和keepalived启动

   ```shell
   systemctl start nginx
   systemctl start keepalived.service
   ```




## 5. 原理解析

Nginx中同时含有两个进程，master和worker。master收到客户端请求，将任务分配给worker，worker通过争抢机制得到任务进行反向代理。

![img](https://x2-wrx.oss-cn-beijing.aliyuncs.com/img/1455597-20191029103717881-58535625.png)

### 5.1 一个master和多个worker的好处

1. 可以使用 nginx –s reload 热部署，利用 nginx 进行热部署操作。

2. 每个 woker 是独立的进程，不需要加锁，减少了开销。如果有其中的一个 woker 出现问题，其他 woker 可以继续进行争抢，实现请求过程，不会造成服务中断。

### 5.2 worker数量的设置

Nginx采用了io多路复用机制。（**I/O多路复用，I/O就是指的我们网络I/O,多路指多个TCP连接(或多个Channel)，复用指复用一个或少量线程。串起来理解就是很多个网络I/O复用一个或少量的线程来处理这些连接。**）每个worker的线程都可以把一个cpu的性能发挥到机制，所以**worker 数和服务器的 cpu 数相等是最为适宜的**。

### 5.3 连接数

- 发送请求，占用了woker 的几个连接数？

  2个或者4个。

- Nginx有一个master，有四个woker，每个woker支持最大的连接数1024，支持的最大并发数是多少？

  worker支持的最大连接数：4*1024/2。

  普通的静态访问最大并发数是： worker_connections * worker_processes /2，

  而如果是HTTP作为反向代理来说，最大并发数量应该是worker_connections * worker_processes/4。