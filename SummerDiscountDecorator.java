/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaderopaii;

/**
 *
 * @author javie
 */

    
    public class SummerDiscountDecorator extends Decorator {
    private static final double SUMMER_DISCOUNT = 0.10; // 10% descuento
    
    public SummerDiscountDecorator(Component component) {
        super(component);
    }
    
    @Override
    public double applyDiscount() {
        double originalPrice = component.getPrice();
        return originalPrice - (originalPrice * SUMMER_DISCOUNT);
    }
    
    @Override
    public String getDescription() {
        return component.getDescription() + " (10% descuento verano)";
    }
}
    

