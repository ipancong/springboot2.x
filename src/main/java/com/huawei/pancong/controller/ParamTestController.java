package com.huawei.pancong.controller;

import com.huawei.pancong.config.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PathVariable、
 * @RequestHeader、
 * @ModelAttribute、
 * @RequestParam、
 * @MatrixVariable、
 * @CookieValue、
 * @RequestBody
 */
@Controller
@Slf4j
public class ParamTestController {


    @PostMapping("/person")
    @ResponseBody
    public Person saveUser(@RequestBody Person person){
        return person;
    }
    //http://localhost:8080/car/123/owner/pancong?age=28&inters=football&inters=foot
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                         @PathVariable("username") String name,
                         @PathVariable Map<String, String> pv,
                         @RequestHeader("User-Agent") String userAgent,
                         @RequestHeader Map<String, String> header,
                         @RequestParam("age") Integer age,
                         @RequestParam("inters") List<String> inters,
                         @RequestParam Map<String, String> params
                         ) {
        Map<String, Object> response = new HashMap<>();
        response.put("@PathVariable(\"id\") Integer id", id);
        response.put("@PathVariable(\"username\") String name", name);
        response.put("@PathVariable Map<String, String> pv ", pv);
        response.put("@RequestHeader(\"User-Agent\") String ", userAgent);
        response.put("@RequestHeader Map<String, String> ", header);
        response.put("@RequestParam(\"age\") Integer age ", age);
        response.put("@RequestParam(\"inters\") List<String> inters", inters);
        response.put("@RequestParam Map<String, String> ", params);
        return response;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("Hello", "World");
        model.addAttribute("Show", "Case");
        request.setAttribute("Request", "hello");
        Cookie cookie = new Cookie("hello", "world");
        response.addCookie(cookie);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg", required = false) String msg,
                       @RequestAttribute(value="code", required = false) String code,
                       HttpServletRequest request){

        Object hello = request.getAttribute("Hello");
        Object show = request.getAttribute("Show");
        Object request_text = request.getAttribute("Request");
        Map map = new HashMap<>();
        map.put("hello", hello);
        map.put("show", show);
        map.put("request_text", request_text);
        return map;

    }


}
