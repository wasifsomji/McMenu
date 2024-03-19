package com.mcgill.mcgillmenuprices.repository;

import com.mcgill.mcgillmenuprices.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
      // You can define custom query methods here if needed
}
