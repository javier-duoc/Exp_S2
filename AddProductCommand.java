/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaderopaii;

/**
 *
 * @author javie
 */
    
import com.mycompany.tiendaderopaii.InterfazCommand.Command;
    import java.util.List;

public class AddProductCommand implements Command {
    private List<Component> cart;
    private Component product;
    
    public AddProductCommand(List<Component> cart, Component product) {
        this.cart = cart;
        this.product = product;
    }
    
    @Override
    public void execute() {
        cart.add(product);
        System.out.println("✅ Producto agregado: " + product.getDescription());
    }
    
    @Override
    public void undo() {
        cart.remove(product);
        System.out.println("❌ Producto removido: " + product.getDescription());
    }
}

