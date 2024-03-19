package com.mcgill.mcgillmenuprices.repository;

import com.mcgill.mcgillmenuprices.model.Category;
import com.mcgill.mcgillmenuprices.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
      // You can define custom query methods here if needed
      List<Category> findByRestaurant(Restaurant restaurant);
}
