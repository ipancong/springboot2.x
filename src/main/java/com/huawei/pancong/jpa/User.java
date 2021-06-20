package com.huawei.pancong.jpa;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//表明这是个需要生成数据表的类
@Entity
@Data
public class User {
    //    定义主键id
    @Id
    //    声明一个策略通用生成器，name为”system-uuid”,策略strategy为”uuid”。
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    //    用generator属性指定要使用的策略生成器。
    @GeneratedValue(generator = "system-uuid")
    private String id;
    private String name;

}
