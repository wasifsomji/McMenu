package com.mcgill.mcgillmenuprices.repository;

import com.mcgill.mcgillmenuprices.model.Item;
import com.mcgill.mcgillmenuprices.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
      // You can define custom query methods here if needed
      List<Item> findByRestaurant(Restaurant restaurant);

      List<Item> findAllByCategoryIdAndRestaurantId(Long categoryId, Long restaurantId);
}
