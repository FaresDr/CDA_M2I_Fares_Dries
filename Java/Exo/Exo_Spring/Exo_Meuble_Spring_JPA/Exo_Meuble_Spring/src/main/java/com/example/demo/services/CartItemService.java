package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CartItemService implements ICartItemService {

    private CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {this.cartItemRepository = cartItemRepository;}

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    @Override
    public CartItem update(CartItem cartItem) {
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    @Override
    public void delete(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }


}
