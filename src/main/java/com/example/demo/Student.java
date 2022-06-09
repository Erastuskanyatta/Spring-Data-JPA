package com.example.demo;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import javax.persistence.*;
import javax.sound.midi.Sequence;
import java.time.Period;

@Entity( name = "Student")
//to update email column constraint 👇️
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "student_email_unique(updated",
                        columnNames = "email"
                )
        }
)
public class Student {

    @Id
    @SequenceGenerator(
            name =  "student_sequence",
            sequenceName = "student_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private  Long id;

   @Column(
           name = "Fname",
           nullable = false,
           columnDefinition = "TEXT"
   )
    private String firstname;

    @Column(
            name = "Lname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String  lastname;

    @Column(
            name =  "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "age",
            nullable = false
    )
    @Transient
    private Integer age;

    public Student(
            String firstname,
            String lastname,
            String email
            ) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;

    }

    public Student() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
