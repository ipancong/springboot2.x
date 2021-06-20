package com.huawei.pancong.jpa.controller;

import com.huawei.pancong.jpa.dao.ClazzRepository;
import com.huawei.pancong.jpa.dao.PetRepository;
import com.huawei.pancong.jpa.dao.StudentRepository;
import com.huawei.pancong.jpa.domain.Clazz;
import com.huawei.pancong.jpa.domain.Pet;
import com.huawei.pancong.jpa.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class JpaController {

    @Autowired
    PetRepository petRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClazzRepository clazzRepository;


    @GetMapping("/clazzes")
    public List<Clazz> clazzes() {
        return clazzRepository.findAll();
    }

    @GetMapping("/init-data")
    public List<Pet> initData() {
        Pet dog = new Pet("dog", "red");
        Pet cat = new Pet("cat", "white");
        Pet elephant = new Pet("elephant", "blue");
        Pet panda = new Pet("panda", "black");
        Pet tiger = new Pet("tiger", "yellow");
        List<Pet> pets = new ArrayList<>();
        pets.add(dog);
        pets.add(cat);
        pets.add(elephant);
        pets.add(panda);
        pets.add(tiger);
        petRepository.saveAll(pets);
        Clazz clazzOne = new Clazz("One");
        Clazz clazzTwo = new Clazz("Two");
        List<Student> students_one = Arrays.asList(new Student[]{
                new Student("zhangsan", "22"),
                new Student("lisi", "23")
        });
        for(Student stu:students_one){
            stu.setClazz(clazzOne);
        }


        List<Student> students_two = Arrays.asList(new Student[]{
                new Student("wanger", "25"),
                new Student("zhaowu", "26"),
                new Student("qianliu", "27"),
                new Student("youda", "28")
        });

        for(Student stu:students_two){
            stu.setClazz(clazzTwo);
        }


        clazzOne.setStudents(students_one);


        clazzTwo.setStudents(students_two);
        List<Clazz> clazzes = new ArrayList<>();
        clazzes.add(clazzOne);
        clazzes.add(clazzTwo);
        clazzRepository.saveAll(clazzes);
        return pets;
    }
}
