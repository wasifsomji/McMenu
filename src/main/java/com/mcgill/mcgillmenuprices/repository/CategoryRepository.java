package com.mcgill.mcgillmenuprices.repository;

import com.mcgill.mcgillmenuprices.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
      // You can define custom query methods here if needed
}
