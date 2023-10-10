package com.hakaton.service;

import com.hakaton.dto.RestaurantDTO;
import com.hakaton.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    Integer addRestaurant(RestaurantDTO restaurantDTO);

    Restaurant updateRestaurantRating(Integer id, String averageRating, int votes);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getRestaurantsByCity(String city);

    Restaurant getRestaurantById(Integer id);

    void deleteRestaurantById(Integer id);

    List<Restaurant> getSortedRestaurantsByRating();
}