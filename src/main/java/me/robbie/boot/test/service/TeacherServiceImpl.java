package me.robbie.boot.test.service;

import groovy.lang.GroovyClassLoader;
import me.robbie.boot.test.dao.CourseDOMapper;
import me.robbie.boot.test.dao.TeacherDOMapper;
import me.robbie.boot.test.model.CourseDO;
import me.robbie.boot.test.model.TeacherDO;
import me.robbie.boot.test.script.RuleEngine;
import me.robbie.boot.test.script.RuleParam;
import me.robbie.boot.test.script.RuleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:闻西
 * @see: [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDOMapper teacherDOMapper;

    @Autowired
    private CourseDOMapper courseDOMapper;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void init(){
        System.out.println("thread:--------" +Thread.currentThread().getName());
    }

    @Override
    @Transactional
    public boolean save() {
        TeacherDO teacherDO = new TeacherDO();
        teacherDO.setName(System.currentTimeMillis() + "");
        teacherDO.setSex(2);
        teacherDO.setBirth(new Date());

        int i = teacherDOMapper.insertSelective(teacherDO);

        System.out.println("id=" + teacherDO.getId() + ",i=" + i);

        CourseDO courseDO = new CourseDO();

        courseDO.setName(System.currentTimeMillis() + "a");
        courseDO.setScore(4);
        int j = courseDOMapper.insertSelective(courseDO);

        System.out.println("id=" + courseDO.getId() + ",j=" + j);

        return true;
    }


    @Override
    @Transactional
    public boolean saveException() {
        TeacherDO teacherDO = new TeacherDO();
        teacherDO.setName(System.currentTimeMillis() + "");
        teacherDO.setSex(1);
        teacherDO.setBirth(new Date());

        int i = teacherDOMapper.insertSelective(teacherDO);

        System.out.println("id=" + teacherDO.getId() + ",i=" + i);

        CourseDO courseDO = new CourseDO();

        courseDO.setName(System.currentTimeMillis() + "a");
        courseDO.setScore(3);
        int j = courseDOMapper.insertSelective(courseDO);

        System.out.println("id=" + courseDO.getId() + ",j=" + j);

        throw new RuntimeException("null");
    }

    @Override
    public boolean saveprivate() {

        return studentService.saveException();
    }

    @Async
    @Override
    public void test() {
        try {
            Thread.sleep(1000);

            System.out.println("thread:" +Thread.currentThread().getName()+","+System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Override
    public String groovy() {
        try {
            //File file = new File("/Users/fangjilue/IdeaProjects/test/test-boot/src/main/resources/script/spring.groovy");
            //File file = ResourceUtils.getFile("classpath:script/spring.groovy");
            //System.out.println(file.getAbsolutePath());

            //Resource fileRource = new ClassPathResource("script/spring.groovy");
            //System.out.println(fileRource.getURL());

            GroovyClassLoader gcl = new GroovyClassLoader(this.getClass().getClassLoader());
            //System.out.println(gcl.getResource("script/spring.groovy"));

            String script = FileCopyUtils.copyToString(new InputStreamReader(gcl.getResourceAsStream("script/spring.groovy")));

            Class clazz = gcl.parseClass(script);

            RuleEngine engine = (RuleEngine) clazz.newInstance();

            RuleParam param = new RuleParam("java",18);

            RuleResult result = engine.exe(param);

            return result.toString();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return "error";

    }
}
