### 1. 创建maven项目
### 2. 在pom中导入包 

首先导入

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.0.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

再导入web模块    

```xml
<dependencies>
    <dependency>
<!--        springboot的web模块的依赖-->
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

为了能直接打包成为一个可执行的jar包，通过java -jar 命令执行，需要导入一个插件

```xml
<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

### 3. 创建启动应用主程序


​      
```java
    package com.apple;
    
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;

		@SpringBootApplication
    public class HelloWorldMainApplication {
        public static void main(String[] args) {
    //        启动应用
            SpringApplication.run(HelloWorldMainApplication.class, args);
        }
    }
        //加上注解 @SpringBootApplication标注一个主程序 说明这是一个spring boot应用
    //psvm 是main方法的快捷键
    
    //第一步写 HelloWorldMainApplication ，启动应用
    //第二步写 crontroller类
```


​        
​        



### 4. 写controller文件
新建controller包，以及controller类 


```java
    package com.apple.controller;
    
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.ResponseBody;
    
    @Controller
    public class HelloWorldController {
    
        @ResponseBody
        @RequestMapping("/hello")
        public String hello(){
            return "hello chen";
        }
    
    }
        //@Controller是标注这是@Controller类
    //@ResponseBody是将return的内容给浏览器 写出去
    //@RequestMapping("/hello")是将路由hello映射到这个方法上
```


​        




### 5 项目探究
#### pom文件 
##### 父项目导入
```xml
  这是所有的启动器的父项目，starter是启动器， 是spring-boot-starter的父项目
       <parent>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-parent</artifactId>
           <version>2.3.0.RELEASE</version>
           <relativePath/> <!-- lookup parent from repository -->
       </parent>
  
  spring-boot-starter-parent的父项目是spring-boot-dependencies 再进到spring-boot-dependencies内， 就是springboot所有的依赖版本
```


​       
​       
​       
##### 启动器导入

```xml
       <dependencies>
           <dependency>
       <!--        springboot的web模块的依赖-->
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
           </dependency>
       </dependencies>
      
      spring-boot-starter-web 依赖 spring-boot-starter  
      spring-boot-starter是sringboot的场景启动器，帮助导入了常用的web模块运行的依赖组件， 通过进到下一层能看到
```

springboot将所有的功能场景抽取出来，做成一个个的启动器 starter，只需要在项目中引入启动器   ，相关的依赖都是引入。



##### 主入口类 主程序类

```java
package com.apple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
//        启动应用
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}



//加上注解 @SpringBootApplication标注一个主程序 说明这是一个spring boot应用
//psvm 是main方法的快捷键

//第一步写 HelloWorldMainApplication ，启动应用
//第二步写 crontroller类
```

@SpringBootApplication标注意味着这是主启动类



```
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
```

@SpringBootConfiguration：标注意味着是 springboot的配置类；再下一层是是@Configuration，配置类底层读取的是配置文件。配置类也是容器中的组件



@Configuration是spring定义的注解，@SpringBootConfiguration：是springboot定义的注解



@EnableAutoConfiguration：开启自动配置

在自动配置的时候，是将@SpringBootApplication标注的主配置类所在的包下面所有的扫描到容器中

 