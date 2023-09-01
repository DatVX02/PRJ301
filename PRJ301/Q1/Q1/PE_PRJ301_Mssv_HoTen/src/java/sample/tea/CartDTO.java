/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tea;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Acer
 */
public class CartDTO {

    private Map<String, TeaDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, TeaDTO> cart) {
        this.cart = cart;
    }

    public Map<String, TeaDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, TeaDTO> cart) {
        this.cart = cart;
    }

    public void add(TeaDTO tea) {
        if (this.cart == null) {
            this.cart = new HashMap<String, TeaDTO>();
        }
        if (this.cart.containsKey(tea.getId())) {
            int currentQuantity = this.cart.get(tea.getId()).getQuantity();
            tea.setQuantity(currentQuantity + tea.getQuantity());
        }
        this.cart.put(tea.getId(), tea);
    }

    public void update(String id, TeaDTO newTea) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.replace(id, newTea);
        }
    }

    public void remove(String id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
}
