package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Created by: zhangbingbing
 * @date 2018/6/28
 **/
@Controller
@RequestMapping("freemarker")
public class DemoController {

    @RequestMapping("/hello")
    public String hello(Map<String,Object> map){

        map.put("msg", "Hello Thymeleaf");
        return "hello";
    }

    @RequestMapping("/word")
    public String word(){
        return "word";
    }

}
