package com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.repository;

import com.bqtankiet.angiday.domain.food.*;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.entity.FoodJpaEntityV2;
import com.bqtankiet.angiday.infrastructure.persistence.jpa_v2.food.mapper.FoodJpaMapperV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author bqtankiet
 */
@Repository
public class FoodRepositoryImplV2 implements IFoodRepository {

    private final FoodJpaRepositoryV2 foodJpaRepository;
    private final FoodJpaMapperV2 foodJpaMapper;

    @Autowired
    public FoodRepositoryImplV2(FoodJpaRepositoryV2 foodJpaRepository, FoodJpaMapperV2 foodJpaMapper) {
        this.foodJpaRepository = foodJpaRepository;
        this.foodJpaMapper = foodJpaMapper;
    }

    @Override
    public Optional<Food> findById(Long id) {
        FoodJpaEntityV2 entity = foodJpaRepository.findById(id).orElse(null);
        Food food = foodJpaMapper.toDomain(entity);
        return Optional.ofNullable(food);
    }

    @Override
    public List<Food> findAll() {
        var rs = foodJpaRepository.findAll();
        return rs.stream()
                .map(foodJpaMapper::toDomain)
                .toList();
    }

    @Override
    public List<Food> findAllByCategoryId(Long categoryId) {
        return List.of();
    }

    @Override
    public List<Food> searchByKeyword(String keyword) {
        String keywordNoAccent = removeAccent(keyword);
        return foodJpaRepository.search(keywordNoAccent)
                .stream()
                .map(foodJpaMapper::toDomain)
                .collect(Collectors.toList());
    }

    /**
     * ham removeAccent dung de convert chu co dau ve chu khong dau
     */
    public static String removeAccent(String s) {
        String nfdNormalizedString = Normalizer.normalize(s, Normalizer.Form.NFD);
        return nfdNormalizedString.replaceAll("\\p{M}", "");
    }
/**
 * sử dụng để set cột nameNoAccent trong bảng food nếu cần
 *  food.setNameNoAccent(removeAccent(inputName).toLowerCase());
 */


}
