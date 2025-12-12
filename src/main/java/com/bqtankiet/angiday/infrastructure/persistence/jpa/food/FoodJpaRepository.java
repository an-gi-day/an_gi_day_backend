package com.bqtankiet.angiday.infrastructure.persistence.jpa.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author bqtankiet
 */
public interface FoodJpaRepository extends JpaRepository<FoodJpaEntity, Long> {

    //    @Query("""
//        SELECT f FROM FoodJpaEntity f
//        WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
//           OR LOWER(f.brand.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
//           OR LOWER(f.category.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
//        """)
//    @Query("select f from FoodJpaEntity f where f.name like %:keyword% or f.brand.name like %:keyword% or f.category.name like %:keyword%")
    @Query("""
            SELECT f FROM FoodJpaEntity f
            WHERE LOWER(f.nameNoAccent) LIKE LOWER(CONCAT('%', :keyword, '%'))
             OR LOWER(f.brand.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
             OR LOWER(f.category.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
            """)

    List<FoodJpaEntity> search(@Param("keyword") String keyword);


}
