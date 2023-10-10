package com.hakaton.controller;

import com.hakaton.dto.RestaurantDTO;
import com.hakaton.entity.Restaurant;
import com.hakaton.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/{id}")
    public Restaurant getRestaurantByIdController(@PathVariable("id") Integer id) {
        log.info("call method get from Restaurant by Id...");
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/all")
    public List<Restaurant> getAllRestaurantController() {
        log.info("call method get all Restaurants...");
        return restaurantService.getAllRestaurants();
    }
    @GetMapping("/city")
    public List<Restaurant> getRestaurantByCityController(@RequestParam String city) {
        log.info("call method get Restaurants for city {}...", city);
        return restaurantService.getRestaurantsByCity(city);
    }
    @GetMapping("/sort")
    public List<Restaurant> getRestaurantsSortByRatingController() {
        log.info("call method get Restaurants sorted by rating ...");
        return restaurantService.getSortedRestaurantsByRating();
    }

    @PostMapping("")
    public Integer addRestaurantController(@RequestBody RestaurantDTO restaurantDTO) {
        log.info(" call method add Restaurants...");
        return restaurantService.addRestaurant(restaurantDTO);
    }
    @PutMapping("/update/{id}")
    public Restaurant updateOrderController(
            @PathVariable("id") final Integer id,
            @RequestParam("averageRating") String rating,
            @RequestParam("votes") int votes) {
        log.info("call method update Restaurants...");

        return restaurantService.updateRestaurantRating(id, rating, votes);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRestaurantController(@PathVariable("id") final Integer id) {
        log.info("call method delete from Restaurants by Id...");
        restaurantService.deleteRestaurantById(id);
    }

}
