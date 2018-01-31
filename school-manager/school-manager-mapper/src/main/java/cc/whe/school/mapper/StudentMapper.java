package cc.whe.school.mapper;

import cc.whe.school.pojo.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * 条件查询
     * @param student
     * @return
     */
    List<Student> findByCondition(Student student);
    /**
     * 修改
     * @param student
     */
    void update(Student student);

    /**
     * 删除
     * @param id
     */
    void deleteByPrimaryKey(Integer id);

    /**
     * 新橧
     * @param student
     */
    void insert(Student student);

    /**
     * 获取单个实例
     * @param id 标识
     * @return
     */
    Student get(Integer id);
}
