package com.mcgill.mcgillmenuprices.repository;

import com.mcgill.mcgillmenuprices.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
      // You can define custom query methods here if needed
}
