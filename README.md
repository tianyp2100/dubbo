DUBBO
=============================================
#### 一个分布式、高性能、透明化的RPC服务框架，提供服务自动注册、自动发现等高效服务治理方案.
#### ![官方网站](http://dubbo.io): http://dubbo.io
#### ![源码地址](https://github.com/alibaba/dubbo): https://github.com/alibaba/dubbo

|名称|模块|说明
|---|---|---
|通用实体|common-module-entity|各个模块依赖的java bean实体类
|通用接口|common-module-interface|RPC服务提供者和消费者通用接口
|通用工具|common-module-util|通用数据处理单元和工具类
|DUBBO服务消费者|member-api|基于spring boot实现的dubbo消费者api
|Maven父管理|parent|Maven的顶级父统一管理maven模板和版本
|DUBBO服务提供者|service-module-member|基于spring实现的MySQL、Druid、MyBatis等，服务提供者
### 服务使用说明
#### 1.安装推荐注册中心Zookeeper
```
https://github.com/typa1/docs/blob/master/Installer-Manual-ubuntu-14.04.5-zookeeper-3.4.8.md
```
#### 2.启动服务提供者
```
2.1:本地直接Run: service-module-member\src\main\java\me\loveshare\member\StartMemberService.java
2.2:服务器:
  2.2.1:将“service-module-member-1.0.0-assembly.tar.gz”上传服务器目录下,
  2.2.2:source /etc/profile
  2.2.3:tar zxvf service-module-member-1.0.0-assembly.tar.gz 
  2.2.4:dos2unix service-module-member-1.0.0/bin/start.sh 
        	dos2unix: converting file service-module-member-1.0.0/bin/start.sh to Unix format ...
  2.2.5:service-module-member-1.0.0/bin/start.sh 
          Starting the service-module-member .............OK!
          PID: 1599
          STDOUT: log/stdout.log
```
#### 1.
#### 1.
#### 1.
#### 1.
