package com.kursach.repositories;

import com.kursach.models.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepositoryJpa extends CartRepository, JpaRepository<ProductCart, Long> {

    @Override
    void create(ProductCart cart);

    @Override
    List<ProductCart> readProductsByUser(Integer userId);

    @Override
    void delete();

    @Override
    void deleteFromCart(Long productId, Integer userId);

    @Override
    void deleteAllCart(Integer userId);
}
