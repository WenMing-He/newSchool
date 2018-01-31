package cc.whe.school.service;

import cc.whe.school.mapper.StudentMapper;
import cc.whe.school.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> findByCondition(Student student) {
        return studentMapper.findByCondition(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void addList(List<Student> students) {
        for (Student student:students) {
            studentMapper.insert(student);
        }
    }

    @Override
    public Student get(Integer id) {
        return studentMapper.get(id);
    }
}
