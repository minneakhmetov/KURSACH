/*
 * Developed by Razil Minneakhmetov on 12/21/18 6:46 PM.
 * Last modified 12/21/18 6:46 PM.
 * Copyright © 2018. All rights reserved.
 */

package com.kursach.services;
import com.kursach.models.ProductCart;

import java.util.List;

public interface CartService {
    void addToCart(ProductCart cart);

    List<ProductCart> getProductsInCart(Integer id);

    void deleteFromCart(Long productId, Integer userId);

    void deleteAllCart(Integer userId);
}
