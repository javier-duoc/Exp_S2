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
import java.util.Stack;

public class CartManager {
    private List<Component> cart;
    private Stack<Command> commandHistory;
    private DiscountManager discountManager;
    
    public CartManager() {
        cart = new ArrayList<>();
        commandHistory = new Stack<>();
        discountManager = DiscountManager.getInstance();
    }
    
    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }
    
    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
        } else {
            System.out.println("No hay comandos para deshacer");
        }
    }
    
    public void addProduct(Component product, String couponCode) {
        Component discountedProduct = discountManager.applyAllDiscounts(product, couponCode);
        executeCommand(new AddProductCommand(cart, discountedProduct));
    }
    
    public void removeProduct(int index) {
        executeCommand(new RemoveProductCommand(cart, index));
    }
    
    public void clearCart() {
        executeCommand(new ClearCartCommand(cart));
    }
    
    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("🛒 El carrito está vacío");
            return;
        }
        
        System.out.println("\n=== 🛒 CARRITO DE COMPRAS ===");
        double total = 0;
        double totalDiscount = 0;
        
        for (int i = 0; i < cart.size(); i++) {
            Component product = cart.get(i);
            double originalPrice = product.getPrice();
            double finalPrice = product.applyDiscount();
            double discount = originalPrice - finalPrice;
            
            System.out.printf("%d. %s%n", i + 1, product.getDescription());
            System.out.printf("   Precio original: $%.2f%n", originalPrice);
            if (discount > 0) {
                System.out.printf("   Descuento: -$%.2f%n", discount);
            }
            System.out.printf("   Precio final: $%.2f%n%n", finalPrice);
            
            total += finalPrice;
            totalDiscount += discount;
        }
        
        System.out.println("-----------------------------");
        System.out.printf("Total descuentos: -$%.2f%n", totalDiscount);
        System.out.printf("TOTAL A PAGAR: $%.2f%n", total);
    }
    
    public boolean isEmpty() {
        return cart.isEmpty();
    }
    
    public int getCartSize() {
        return cart.size();
    }

    void addProduct(Component selectedProduct, String couponCode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

