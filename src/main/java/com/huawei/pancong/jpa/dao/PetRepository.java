package com.huawei.pancong.jpa.dao;

import com.huawei.pancong.jpa.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface PetRepository extends JpaRepository<Pet, String> {

    /**
     * 自定义查询
     * findByName
     */
    List<Pet> findByName(String name);

    List<Pet> findByColor(String color);

    List<Pet> findByColorAndName(String color, String name);


//    /**
//     * jpql查询
//     */
//    @Modifying
//    @Query(value = "update Pet pet set pet.color = :color where pet.name = :name")
//    @Transactional
//    int updatePetColor(@Param("name") String name, @Param("color") String color);
}
