package com.hakaton.controller;

import com.hakaton.dto.RestaurantDTO;
import com.hakaton.entity.Restaurant;
import com.hakaton.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/{id}")
    public Restaurant getOrderByIdController(@PathVariable("id") Long id) {
        log.info("call method get from Order by Id...");
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/all")
    public List<Restaurant> getAllOrdersController() {
        log.info("call method get all Orders...");
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public Restaurant addOrderController(@RequestBody Restaurant rest) {
        log.info(" call method add order...");
//        products.forEach(product -> log.info("Add product: " + product.getName() + " " + product.getCost()));
        return restaurantService.addRestaurant(rest);
    }
//    @PutMapping("/update")
//    public Restaurant updateOrderController(@RequestBody Restaurant restaurant) {
//        logger.info("OrderController - call method update order...");
//        return restaurantService.updateRestaurantRating(restaurant);
//    }
    @DeleteMapping("/delete/{id}")
    public void deleteOrderController(@PathVariable("id") final Long id) {
        log.info("call method delete from Order by Id...");
        restaurantService.deleteRestaurantById(id);
    }

}
