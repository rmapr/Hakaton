package com.hakaton.service.impl;

import com.hakaton.dto.RestaurantDTO;
import com.hakaton.entity.Restaurant;
import com.hakaton.exception.RestaurantNotFoundException;
import com.hakaton.repository.RestaurantRepository;
import com.hakaton.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    @Override
    public Restaurant addRestaurant(Restaurant restaurantDto) {
//        Restaurant restaurant = new Restaurant();
//        restaurant.setCity(restaurantDto.getCity());
//        restaurant.setName(restaurantDto.getName());
//        restaurant.setVates(restaurantDto.getVotes());
//        restaurant.setAverageRating(restaurantDto.getAverageRating());
//        restaurant.setEstimatedCost(restaurantDto.getEstimatedCost());

        return restaurantRepository.save(restaurantDto);
    }

    @Override
    public Restaurant updateRestaurantRating(Long id, double averageRating, int votes) {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        log.info("Визов методу показати всі ресторани ...: ");
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
        return null;
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> {
                            log.error("Ресторан з індексом {} відсутній", id);
                            return new RestaurantNotFoundException("Restaurant_Not_Found");
                        }
                );
        return restaurant;
    }

    @Override
    public void deleteRestaurantById(Long id) {

    }

    @Override
    public List<Restaurant> getSortedRestaurantsByRating() {
        return null;
    }
}
