package com.bqtankiet.angiday.infrastructure.persistence.jpa.food.repository;

import com.bqtankiet.angiday.domain.food.*;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.mapper.FoodJpaMapper;
import com.bqtankiet.angiday.infrastructure.persistence.jpa.food.entity.FoodJpaEntity;
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
public class FoodRepositoryImpl implements IFoodRepository {

    private final FoodJpaRepository foodJpaRepository;
    private final FoodJpaMapper foodJpaMapper;

    @Autowired
    public FoodRepositoryImpl(FoodJpaRepository foodJpaRepository, FoodJpaMapper foodJpaMapper) {
        this.foodJpaRepository = foodJpaRepository;
        this.foodJpaMapper = foodJpaMapper;
    }

    @Override
    public Optional<Food> findById(String id) {
        FoodJpaEntity entity = foodJpaRepository.findById(Long.parseLong(id)).orElse(null);
        Food food = foodJpaMapper.dtoToModel(entity);
        return Optional.of(food);
    }

    @Override
    public List<Food> findAll() {
        var rs = foodJpaRepository.findAll();
        return rs.stream()
                .map(foodJpaMapper::dtoToModel)
                .toList();
    }

    @Override
    public List<Food> findAllByCategoryId(String categoryId) {
        return List.of();
    }

    @Override
    public List<Food> searchByKeyword(String keyword) {
        String keywordNoAccent = removeAccent(keyword);
        return foodJpaRepository.search(keywordNoAccent)
                .stream()
                .map(foodJpaMapper::dtoToModel)
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
