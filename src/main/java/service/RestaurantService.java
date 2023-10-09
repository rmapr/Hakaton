package service;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant updateRestaurantRating(Long id, double averageRating, int votes);

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getRestaurantsByCity(String city);

    Restaurant getRestaurantById(Long id);

    void deleteRestaurantById(Long id);

    List<Restaurant> getSortedRestaurantsByRating();
}