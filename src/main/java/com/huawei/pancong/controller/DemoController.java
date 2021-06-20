package com.huawei.pancong.controller;

import com.huawei.pancong.config.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    Person person;

    /**
     * Rest风格支持（使用HTTP请求方式动词来表示对资源的操作）
     *  /user    GET-获取用户    DELETE-删除用户     PUT-修改用户      POST-保存用户
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }


    @RequestMapping("/person")
    public Person persons() {
        return person;
    }
}
