DUBBO
=============================================
#### 一个分布式、高性能、透明化的RPC服务框架，提供服务自动注册、自动发现等高效服务治理方案.
#### ![官方网站](http://dubbo.io): http://dubbo.io
#### ![源码地址](https://github.com/alibaba/dubbo): https://github.com/alibaba/dubbo
#### 注：支持需要 git、jdk、maven。

|名称|模块|说明
|---|---|---
|通用实体|common-module-entity|各个模块依赖的java bean实体类
|通用接口|common-module-interface|RPC服务提供者和消费者通用接口
|通用工具|common-module-util|通用数据处理单元和工具类
|DUBBO服务消费者|member-api|基于spring boot实现的dubbo消费者api
|Maven父管理|parent|Maven的顶级父统一管理maven模板和版本
|DUBBO服务提供者|service-module-member|基于spring实现的MySQL、Druid、MyBatis等，服务提供者
### 服务使用说明
#### 1.安装推荐注册中心Zookeeper: ![安装文档](https://github.com/loveshareme/docs/blob/master/Zookeeper-3.4.8.md)
```
https://github.com/loveshareme/docs/blob/master/Zookeeper-3.4.8.md
```
#### 2.启动服务提供者
```
2.1:本地直接Run: service-module-member\src\main\java\me\loveshare\member\StartMemberService.java
2.2:服务器:
  2.2.1:将“service-module-member-1.0.0-assembly.tar.gz”上传服务器目录下,
  2.2.2:source /etc/profile
  2.2.3:tar zxvf service-module-member-1.0.0-assembly.tar.gz 
  2.2.4:apt-get install dos2unix
        dos2unix service-module-member-1.0.0/bin/start.sh 
        	dos2unix: converting file service-module-member-1.0.0/bin/start.sh to Unix format ...
  2.2.5:service-module-member-1.0.0/bin/start.sh 
          Starting the service-module-member .............OK!
          PID: 1599
          STDOUT: log/stdout.log
```
#### 3.启动服务消费者
```
nohup java -jar member-api-1.0.0.jar &
```
#### 4.测试数据接口（附录:图片）
```
http://192.168.1.151:6201/userinfo/list.json
```
#### 5.监控部署:(![Dubbokeeper](https://github.com/dubboclub/dubbokeeper): https://github.com/dubboclub/dubbokeeper)
```
5.1: git clone git@github.com:dubboclub/dubbokeeper.git
5.2: install-mysql.bat
5.3: 在target目录下:
     dubbokeeper-ui-1.0.1.war
     mysql-dubbokeeper-server.tar.gz
5.4: 将二者上传服务器
5.5: 此监控支持mysql、mongodb、lucene，此处使用mysql:
     创建数据库:
        CREATE DATABASE IF NOT EXISTS `dubbo-monitor` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
     执行sql: 
        doc\storage\mysql\sql\application.sql
5.6: 启动监控服务
     mkdir dubbo-monitor
     tar zxvf mysql-dubbokeeper-server.tar.gz -C dubbo-monitor
     cd dubbo-monitor/
     vim conf/dubbo-mysql.properties (修改以下参数：自定义)
          dubbo.registry.address=zookeeper://192.168.1.151:2181
          dubbo.monitor.mysql.url=jdbc:mysql://192.168.1.151:3306/dubbo-monitor
          dubbo.monitor.mysql.username=dba
          dubbo.monitor.mysql.password=123456
     cd bin/
     chmod u+x start-mysql.sh 
     dos2unix start-mysql.sh 
     nohup ./start-mysql.sh &
5.7: 启动监控web（需要安装tomcat）（附录:图片）
      cp -R dubbokeeper-ui-1.0.1.war apache-tomcat-8.5.5/webapps/
      apt-get install unzip
      unzip dubbokeeper-ui-1.0.1.war -d dubbokeeper-ui-1.0.1
      vim dubbokeeper-ui-1.0.1/WEB-INF/classes/dubbo.properties (修改以下参数：自定义)
          dubbo.registry.address=zookeeper://192.168.1.151:2181
          peeper.zookeepers=192.168.1.151:2181
      cd ..
      bin/startup.sh
      tail -f logs/catalina.out
 5.8：web监控页面
      http://192.168.1.151:8080/dubbokeeper-ui-1.0.1
```
### 附录.
![数据请求截图](http://loveshare.oss-cn-shanghai.aliyuncs.com/universal/image/github/dubbo/1.jpg)
![监控截图1](http://loveshare.oss-cn-shanghai.aliyuncs.com/universal/image/github/dubbo/2.jpg)
![监控截图2](http://loveshare.oss-cn-shanghai.aliyuncs.com/universal/image/github/dubbo/3.jpg)
![监控截图3](http://loveshare.oss-cn-shanghai.aliyuncs.com/universal/image/github/dubbo/4.jpg)
![监控截图4](http://loveshare.oss-cn-shanghai.aliyuncs.com/universal/image/github/dubbo/5.jpg)
![监控截图5](http://loveshare.oss-cn-shanghai.aliyuncs.com/universal/image/github/dubbo/6.jpg)
![监控截图6](http://loveshare.oss-cn-shanghai.aliyuncs.com/universal/image/github/dubbo/7.jpg)

