package com.hakaton.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantDTO {
        private String city;
        private String name;
        private int estimatedCost;
        private String averageRating;
        private int votes;
}
