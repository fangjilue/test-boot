package me.robbie.boot.test.action;

import me.robbie.boot.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:闻西
 * @see: [相关类/方法]
 * @since [产品/模块版本]
 */
@RestController
public class SimpleAction {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/")
    String index() {
        return "Hello World!";
    }

    @RequestMapping("/do")
    String doAction(){
        teacherService.save();

        return "ok";
    }

    @RequestMapping("/exception")
    String doException(){

        try {
            teacherService.saveException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error";
    }

    @RequestMapping("/private")
    String doprivate(){

        try {
            teacherService.saveprivate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error";
    }

}
