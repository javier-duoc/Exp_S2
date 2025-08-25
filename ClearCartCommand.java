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
    import java.util.ArrayList;
import java.util.List;

public class ClearCartCommand implements Command {
    private List<Component> cart;
    private List<Component> backup;
    
    public ClearCartCommand(List<Component> cart) {
        this.cart = cart;
        this.backup = new ArrayList<>(cart);
    }
    
    @Override
    public void execute() {
        cart.clear();
        System.out.println("🗑️ Carrito vaciado");
    }
    
    @Override
    public void undo() {
        cart.addAll(backup);
        System.out.println("✅ Carrito restaurado");
    }
}

