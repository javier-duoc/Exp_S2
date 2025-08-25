/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaderopaii;

/**
 *
 * @author javie
 */
    
    public class WinterDiscountDecorator extends Decorator {
    private static final double WINTER_DISCOUNT = 0.20; // 20% descuento
    
    public WinterDiscountDecorator(Component component) {
        super(component);
    }
    
    @Override
    public double applyDiscount() {
        double originalPrice = component.getPrice();
        return originalPrice - (originalPrice * WINTER_DISCOUNT);
    }
    
    @Override
    public String getDescription() {
        return component.getDescription() + " (20% descuento invierno)";
    }
}
    

