#demo项目

##一、概述

 本项目利用springboot 构建一个项目框架，作为项目构建基础，方便快速搭建一个项目，集成了项目基本的插件，如springBoot，myBatis，logback，lombok，feign，swagger，apache-DBCP等。

##二、项目结构

|—common     包含提供给外部调用的领域类

        |—domain   跟entity对应，专门提供外部调用使用

|—client         包含封装好的api和client

        |—api   api请求接口对应到controller的RequestMapper

        |—client  对api的封装

|—server      主要程序包，里面可以自由扩展

        |—controller    控制器

        |—service    主要业务逻辑

        |—dao   数据访问
        
            |—entity   数据库表一一对应的实体类
        
            |—mapper  数据访问接口，包含sql

        |—common  公共代码，包含工具类和常量

        |—config  所有的配置类

        |—ServerApplication  启动类

##三、项目使用

####1、项目启动

  默认8080端口，直接用启动类run。如需修改端口，在idea springboot的启动类Enviroment展开下面的VM options中配置-Dserver.port=8090，这样端口就修改城类8090

####2、数据库配置

  默认所有的配置都在application.properties中：

  spring.datasource.url=jdbc:mysql://xxx.xxx.xxx.xxx:3306/xxx?useUnicode=true&characterEncoding=utf8&useSSL=false

  spring.datasource.username=xxxxx

  spring.datasource.password=xxxxx

  spring.datasource.driver-class-name=com.mysql.jdbc.Driver

####3、远程调用

  远程调用使用feign ，按照demo样例，调用着引入client 和 common 两个jar ，初始化client就可以直接访问。初始化client如下：

  @Beanpublic UserClient userClient(){   return new UserClient(propertiesConfiguration.getUserClientUrl());}

####4、swagger调用

  启动项目后，访问地址http://localhost:8080/swagger-ui.html即可。注意，如果需要swagger显示类型及参数的详细值，需要在实体类添加注解，如下：

  ``` 
    @Data@ApiModel("用户实体类")

    public class User {    
   
           @ApiModelProperty("主键")    
   
           private Integer id;    
   
           @ApiModelProperty("用户名称")    
   
           private String name;
   
   }
   