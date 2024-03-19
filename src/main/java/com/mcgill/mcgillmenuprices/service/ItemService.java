package com.mcgill.mcgillmenuprices.service;

import com.mcgill.mcgillmenuprices.dto.ItemDTO;
import com.mcgill.mcgillmenuprices.model.Item;
import com.mcgill.mcgillmenuprices.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;


@Service
public class ItemService {

      private final ItemRepository itemRepository;
      private final ModelMapper modelMapper;

      @Autowired
      public ItemService(ItemRepository itemRepository, ModelMapper modelMapper) {
            this.itemRepository = itemRepository;
            this.modelMapper = modelMapper;
      }

      public List<ItemDTO> getItemsByCategoryAndRestaurant(Long categoryId, Long restaurantId) {
            List<Item> items = itemRepository.findAllByCategoryIdAndRestaurantId(categoryId, restaurantId);
            return items.stream()
                    .map(item -> modelMapper.map(item, ItemDTO.class))
                    .collect(Collectors.toList());
      }
}
