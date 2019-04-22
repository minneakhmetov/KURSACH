package com.kursach.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {
    Long vkId;
    String name;
    String photoURL;
    Integer price;
    String activity;
}
