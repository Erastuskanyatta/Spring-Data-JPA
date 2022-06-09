package com.example.demo;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.security.cert.PKIXRevocationChecker;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {
    private  final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return  studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());

        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
////        System.out.println(student);
//    }
    }

    public void deleteStudent(Long id) {
        boolean exist = studentRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException(
                    "student with id " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional // this makes us avoid using querry
    public void updateStudent(Long id,
                              String name,
                              String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        "student with id " + id  + "does not exist"
                ));
        if (name != null && name.length() > 0 &&
             !Objects.equals(student.getFirstname(), name)){
            student.setFirstname(name);
        }
        if (email != null &&
             email.length() > 0 &&
        !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

    }
}
