package com.mcgill.mcgillmenuprices.model;

import jakarta.persistence.*;
import com.mcgill.mcgillmenuprices.model.Item;

import java.util.List;


@Entity
@Table(name = "restaurants")
public class Restaurant {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(nullable = false)
      private String name;

      @Column(nullable = false)
      private String location;

      @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<Item> menu;
}
