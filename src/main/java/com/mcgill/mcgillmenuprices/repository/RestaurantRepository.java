package com.mcgill.mcgillmenuprices.repository;

import com.mcgill.mcgillmenuprices.model.Location;
import com.mcgill.mcgillmenuprices.model.Restaurant;
import jakarta.persistence.Column;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
      // You can define custom query methods here if needed
      Restaurant findByName(String name);
}
