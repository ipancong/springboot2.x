package com.huawei.pancong.jpa.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 每个学生只属于一个班级
 *
 * 子表
 */
@Entity(name = "t_student")
@Data
@NoArgsConstructor
@ToString(exclude = {"clazz"})
public class Student {

    public Student(String name, String age){
        this.name = name;
        this.age = age;
    }
    //    定义主键id
    @Id
    //    声明一个策略通用生成器，name为”system-uuid”,策略strategy为”uuid”。
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    //    用generator属性指定要使用的策略生成器。
    @GeneratedValue(generator = "system-uuid")
    private String studentId;

    @Column
    private String name;

    @Column
    private String age;

    @ManyToOne
    @JoinColumn(name="clazzId") // 指定外键,加入一个外键列
    private Clazz clazz;
}
