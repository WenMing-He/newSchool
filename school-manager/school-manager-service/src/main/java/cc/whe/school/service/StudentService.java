package cc.whe.school.service;

import cc.whe.school.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 条件查找
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
    void delete(Integer id);

    /**
     * 新橧
     * @param student
     */
    void add(Student student);

    /**
     * 批量新增
     * @param students
     */
    void addList(List<Student> students);

    /**
     * 单个查询
     * @param id
     * @return
     */
    Student get(Integer id);
}
