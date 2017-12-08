package me.robbie.boot.test.service;

import me.robbie.boot.test.dao.CourseDOMapper;
import me.robbie.boot.test.dao.TeacherDOMapper;
import me.robbie.boot.test.model.CourseDO;
import me.robbie.boot.test.model.TeacherDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class StudentService {


    @Autowired
    private TeacherDOMapper teacherDOMapper;

    @Autowired
    private CourseDOMapper courseDOMapper;


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
}
