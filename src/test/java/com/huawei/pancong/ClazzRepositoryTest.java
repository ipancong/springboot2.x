package com.huawei.pancong;

import com.huawei.pancong.jpa.dao.ClazzRepository;
import com.huawei.pancong.jpa.domain.Clazz;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootTest
@Slf4j
@ActiveProfiles(value = "test")
public class ClazzRepositoryTest {

    @Autowired
    ClazzRepository clazzRepository;

    @Autowired
    private ConfigurableEnvironment springEnv;


    @Test
    void testQuerySpringEnv() {
        MutablePropertySources propSrcs = springEnv.getPropertySources();
        // 获取所有配置
        Map<String, String> props = StreamSupport.stream(propSrcs.spliterator(), false)
                .filter(ps -> ps instanceof EnumerablePropertySource)
                .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toMap(Function.identity(), springEnv::getProperty));
        // 打印
        props.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }

    @Test
    void testFindAll() {
        List<Clazz> clazzes = clazzRepository.findAll();
        clazzes.forEach(clazz -> System.out.println(clazz));

    }
}
