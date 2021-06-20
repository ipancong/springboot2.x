package com.huawei.pancong.jpa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 主表
 */
@Entity(name = "t_clazz")
@Data
@NoArgsConstructor
public class Clazz {

    public Clazz(String name){
        this.name = name;
    }
    //    定义主键id
    @Id
    //    声明一个策略通用生成器，name为”system-uuid”,策略strategy为”uuid”。
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    //    用generator属性指定要使用的策略生成器。
    @GeneratedValue(generator = "system-uuid")
    String clazzId;

    @Column
    String name;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // 创建一对多映射关系，值是对方的外键对应的属性
    private List<Student> students;
}
