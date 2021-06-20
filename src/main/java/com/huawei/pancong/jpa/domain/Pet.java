package com.huawei.pancong.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name = "t_pet")
@Data
@NoArgsConstructor
@ToString
public class Pet {

    public Pet(String name, String color){
        this.name = name;
        this.color = color;
    }
    //    定义主键id
    @Id
    //    声明一个策略通用生成器，name为”system-uuid”,策略strategy为”uuid”。
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    //    用generator属性指定要使用的策略生成器。
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @Column(name = "name")
    public String name;

    @Column
    public String color;



}
