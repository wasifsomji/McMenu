package com.mcgill.mcgillmenuprices.service;

import com.mcgill.mcgillmenuprices.repository.CategoryRepository;
import com.mcgill.mcgillmenuprices.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
      private CategoryRepository categoryRepository;
      private ModelMapper modelMapper;
}
