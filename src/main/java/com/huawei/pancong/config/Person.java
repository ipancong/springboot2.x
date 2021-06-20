package com.huawei.pancong.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 配置文件和实体类绑定
 */
@ConfigurationProperties(prefix = "person")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private PetGo petGo;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salary;
    private Map<String, List<PetGo>> allPets;
}
