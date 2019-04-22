/*
 * Developed by Razil Minneakhmetov on 10/25/18 7:33 PM.
 * Last modified 10/25/18 7:33 PM.
 * Copyright © 2018. All rights reserved.
 */

package com.kursach.repositories;

import com.kursach.models.ProductCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CartRepositoryImpl implements CartRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CartRepositoryImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<ProductCart> rowMapperCart = (resultSet, i) -> ProductCart.builder()
            .avatar(resultSet.getString("photo_url"))
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name") + " " + resultSet.getString("surname"))
            .price(resultSet.getString("price"))
            .userId(resultSet.getInt("user_id"))
            .productId(resultSet.getLong("product_id"))
            .build();

    private static final String SQL_INSERT =
            "INSERT INTO cart (user_id, product_id) VALUES (?, ?)";

    private static final String SQL_SELECT =
            "SELECT cart.id as id, price, activity, service.user_id as user_id, name, surname, photo_url, product_id FROM cart join (select id, price, activity, user_id, name, photo_url, vk_id, surname from product join user_table ut on product.user_id = ut.vk_id) as service on cart.product_id = service.id where cart.user_id = ?";

    private static final String SQL_DELETE =
            "DELETE FROM cart";

    private static final String SQL_DELETE_FROM_CART =
            "DELETE FROM cart where id = ? and user_id = ?";

    private static final String SQL_DELETE_FROM_CART_ALL =
            "DELETE FROM cart where user_id = ?";

    public void create(ProductCart cart){
        jdbcTemplate.update(SQL_INSERT, cart.getUserId(), cart.getProductId());
    }

    public List<ProductCart> readProductsByUser(Integer userId){
        return jdbcTemplate.query(SQL_SELECT, rowMapperCart, userId);
    }

    public void delete(){
        jdbcTemplate.update(SQL_DELETE);
    }

    public void deleteFromCart(Long cartId, Integer userId){
        jdbcTemplate.update(SQL_DELETE_FROM_CART, cartId, userId);
    }
    public void deleteAllCart(Integer userId){
        jdbcTemplate.update(SQL_DELETE_FROM_CART_ALL, userId);
    }

}