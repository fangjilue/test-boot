package me.robbie.boot.test.dao;


import me.robbie.boot.test.model.TeacherDO;
import org.springframework.stereotype.Repository;

public interface TeacherDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Dec 04 23:14:59 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Dec 04 23:14:59 CST 2017
     */
    int insert(TeacherDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Dec 04 23:14:59 CST 2017
     */
    int insertSelective(TeacherDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Dec 04 23:14:59 CST 2017
     */
    TeacherDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Dec 04 23:14:59 CST 2017
     */
    int updateByPrimaryKeySelective(TeacherDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_teacher
     *
     * @mbggenerated Mon Dec 04 23:14:59 CST 2017
     */
    int updateByPrimaryKey(TeacherDO record);
}