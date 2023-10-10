package com.hakaton.repository;


import com.hakaton.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findAllByCity(String city);
    List<Restaurant> findAllByOrderByRating();
}
