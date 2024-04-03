
# 项目说明

### Maven中央仓库地址
https://central.sonatype.com/

### 个人项目包含项
* 前后端加密传输
* xxs 过滤
  分别含有全局和局部，全局拦截xxs攻击和使用注解@Xxs进行单个字段属性进行拦截
  全局路径：src/main/java/com/pzen/demo/common/xxsAndSqlFilterAllRequest
  局部路径：src/main/java/com/pzen/demo/common/xssAnnotation/annotation
* sql 注入拦截
  全局拦截sql注入，拦截全部传输字符串及对象，将所有sql关键词进行匹配拦截
  路径：src/main/java/com/pzen/demo/common/xxsAndSqlFilterAllRequest
* 密码字符传弱口令校验
  可以说是很强的规则验证方式了，就是有点慢，先能用就行，后续再优化
  路径：src/main/java/com/pzen/demo/checkpassword
* Redis 缓存
* 接口访问限流
    使用注解@RateLimiter(value = 1, time = 1)
* @download 文件下载 去除../ ./ ..
* @upload 文件上传 去除../ ./ ..
* 时间类使用java.time
* Ebean ORM 需要安装idea插件，直接搜索Ebean enhancement 选择第一个即可，根据插件提示进行配置idea
  https://github.com/ebean-orm/examples
  路径：com/pzen/demo/ebeandemo/config
  配置文件路径：src/main/resources/application-dev.yml  application-test.yml



# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.0-SNAPSHOT/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.0-SNAPSHOT/maven-plugin/reference/html/#build-image)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.3.0-SNAPSHOT/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.3.0-SNAPSHOT/reference/htmlsingle/index.html#data.sql.jdbc)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.0-SNAPSHOT/reference/htmlsingle/index.html#using.devtools)
* [JDBC API](https://docs.spring.io/spring-boot/docs/3.3.0-SNAPSHOT/reference/htmlsingle/index.html#data.sql)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.3.0-SNAPSHOT/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.0-SNAPSHOT/reference/htmlsingle/index.html#web)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/3.3.0-SNAPSHOT/reference/htmlsingle/index.html#io.webservices)

### Guides

The following guides illustrate how to use some features concretely:

* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)

