package pers.well.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.well.dao.StudentMapper;
import pers.well.model.Student;
import pers.well.service.StudentService;

/**
 * Created by wenlong on 2016/9/8.
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper studentMapper;

    public Student getSudent(int id) {
        return studentMapper.selectByPrimaryKey(Integer.valueOf(id));
    }
}
