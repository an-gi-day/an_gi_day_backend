package com.bqtankiet.angiday.domain.category;

import java.util.List;

/**
 * @author bqtankiet
 */
public interface ICategoryRepository {

    List<Category> findAll();

}
