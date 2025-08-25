/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaderopaii;

/**
 *
 * @author javie
 */
    
    public class CouponDiscountDecorator extends Decorator {
    private double couponDiscount;
    
    public CouponDiscountDecorator(Component component, double couponDiscount) {
        super(component);
        this.couponDiscount = couponDiscount;
    }
    
    @Override
    public double applyDiscount() {
        double originalPrice = component.getPrice();
        return originalPrice - (originalPrice * couponDiscount);
    }
    
    @Override
    public String getDescription() {
        return component.getDescription() + " (" + (couponDiscount * 100) + "% descuento cupón)";
    }
}
