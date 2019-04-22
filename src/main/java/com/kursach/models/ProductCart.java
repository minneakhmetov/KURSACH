package com.kursach.models;


import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@Builder
@Data
@EqualsAndHashCode

public class ProductCart {
    Long id;
    String name;
    String price;
    String avatar;
    String activity;
    Integer userId;
    Long productId;
}

