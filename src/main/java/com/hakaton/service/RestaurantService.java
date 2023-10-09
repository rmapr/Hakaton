package com.hakaton.service;

import com.hakaton.dto.RestaurantDTO;
import com.hakaton.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurantDTO);

    Restaurant updateRestaurantRating(Long id, double averageRating, int votes);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getRestaurantsByCity(String city);

    Restaurant getRestaurantById(Long id);

    void deleteRestaurantById(Long id);

    List<Restaurant> getSortedRestaurantsByRating();
}