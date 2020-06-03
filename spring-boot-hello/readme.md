使用模板快速创建springboot应用



在写controller的时候可以使用组合注解

​	

```java
package com.apple.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
public class HelloController {

    @RequestMapping
    public String hello(){
        return "jjjj";
    }
}
```



首先可以将@ResponseBody从方法上拿到类名上，@ResponseBody为将返回的数据写给浏览器，如果是对象转为json

//@Controller是原本就要加上，标注为controller类

当二者同时存在可以使用@RestController替换。进到@RestController中就能看到二者。