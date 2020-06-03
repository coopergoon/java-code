1. 创建maven项目
2. 在pom中导入包 

首先导入

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.0.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

再导入web模块    

    <dependencies>
        <dependency>
    <!--        springboot的web模块的依赖-->
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

为了能直接打包成为一个可执行的jar包，通过java -jar 命令执行，需要导入一个插件

    <build>
    		<plugins>
    			<plugin>
    				<groupId>org.springframework.boot</groupId>
    				<artifactId>spring-boot-maven-plugin</artifactId>
    			</plugin>
    		</plugins>
    	</build>

3. 创建启动应用主程序

    
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
    
4. 写controller文件
新建controller包，以及controller类 

        
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
        //@ResponseBody是将return的内容给浏览器
        //@RequestMapping("/hello")是将路由hello映射到这个方法上