package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    Category getCategory(String categoryId);

    List<Category> getCategoryList();

    void insertCategory(Category category);

    void updateCategory(Category category);

    void delCategoryByCategoryId(String categoryId);
}
