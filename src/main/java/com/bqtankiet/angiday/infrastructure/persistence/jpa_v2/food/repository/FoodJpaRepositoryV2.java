package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.repository;

import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity.FoodJpaEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author bqtankiet
 */
public interface FoodJpaRepositoryV2 extends JpaRepository<FoodJpaEntityV2, Long> {

    //    @Query("""
//        SELECT f FROM FoodJpaEntityV2 f
//        WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
//           OR LOWER(f.brand.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
//           OR LOWER(f.category.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
//        """)
//    @Query("select f from FoodJpaEntityV2 f where f.name like %:keyword% or f.brand.name like %:keyword% or f.category.name like %:keyword%")
    @Query("""
            SELECT f FROM FoodJpaEntityV2 f
            WHERE LOWER(f.nameNoAccent) LIKE LOWER(CONCAT('%', :keyword, '%'))
             OR LOWER(f.brand.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
             OR LOWER(f.category.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)

    List<FoodJpaEntityV2> search(@Param("keyword") String keyword);


}
