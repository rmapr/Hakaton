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
    public Integer addRestaurant(RestaurantDTO restaurantDto) {
        Restaurant restaurant = new Restaurant()
                .setCity(restaurantDto.getCity())
                .setVotes(restaurantDto.getVotes())
                .setName(restaurantDto.getName())
                .setRating(restaurantDto.getAverageRating())
                .setCost(restaurantDto.getEstimatedCost());
        return restaurantRepository.save(restaurant).getId();
    }

    @Override
    public Restaurant updateRestaurantRating(Integer id, String averageRating, int votes) {
        log.info("Визов методу оновити рейтинг ресторану ...: ");
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> {
                            log.error("Ресторан з індексом {} відсутній", id);
                            return new RestaurantNotFoundException("Restaurant_Not_Found");
                        }
                );
        restaurant.setRating(averageRating);
        restaurant.setVotes(votes);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        log.info("Визов методу показати всі ресторани ...: ");
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantsByCity(String city) {
        log.info("Визов методу показати ресторани в місті {}... ", city);
        return restaurantRepository.findAllByCity(city);
    }

    @Override
    public Restaurant getRestaurantById(Integer id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> {
                            log.error("Ресторан з індексом {} відсутній", id);
                            return new RestaurantNotFoundException("Restaurant_Not_Found");
                        }
                );
    }

    @Override
    public void deleteRestaurantById(Integer id) {
        if (!restaurantRepository.existsById(id)) {
            log.error("Видалити неможливо. Замовлення з індексом {} відсутнє", id);
            throw new RestaurantNotFoundException("RESTAURANT_NOT_FOUND");
        }
        restaurantRepository.deleteById(id);

    }

    @Override
    public List<Restaurant> getSortedRestaurantsByRating() {
        log.info("Визов методу відсортовані ресторани по рейтингу ...: ");
        return restaurantRepository.findAllByOrderByRating();
    }
}
