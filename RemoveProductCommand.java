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

public class RemoveProductCommand implements Command {
    private List<Component> cart;
    private Component product;
    private int index;
    
    public RemoveProductCommand(List<Component> cart, int index) {
        this.cart = cart;
        this.index = index;
        if (index >= 0 && index < cart.size()) {
            this.product = cart.get(index);
        }
    }
    
    @Override
    public void execute() {
        if (index >= 0 && index < cart.size()) {
            product = cart.remove(index);
            System.out.println("❌ Producto eliminado: " + product.getDescription());
        }
    }
    
    @Override
    public void undo() {
        if (product != null) {
            cart.add(index, product);
            System.out.println("✅ Producto restaurado: " + product.getDescription());
        }
    }
}
    
