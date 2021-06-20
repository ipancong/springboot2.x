package com.huawei.pancong.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PetGo {
    private String name;
    private Double weight;
}
