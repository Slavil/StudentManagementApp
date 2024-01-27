package net.javaguides.sms.service;

import net.javaguides.sms.entity.StudentsClass;
import net.javaguides.sms.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<StudentsClass> getAllClasses() {
        return classRepository.findAll();
    }

    public StudentsClass saveClass(StudentsClass studentsClass) {
        return classRepository.save(studentsClass);
    }

    public void deleteClassById(Long id) {
        classRepository.deleteById(id);
    }
}
