package com.example.demo.services;

import com.example.demo.entity.CartItem;


import java.util.List;

public interface ICartItemService {
    List<CartItem> findAll();
    CartItem findById(Long id);
    CartItem save(CartItem cartItem);
    CartItem update(CartItem cartItem);
    void delete(CartItem cartItem);
}
