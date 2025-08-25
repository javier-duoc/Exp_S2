/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaderopaii;

/**
 *
 * @author javie
 */

    public abstract class Decorator implements Component {
    protected Component component;
    
    public Decorator(Component component) {
        this.component = component;
    }
    
    @Override
    public String getDescription() {
        return component.getDescription();
    }
    
    @Override
    public double getPrice() {
        return component.getPrice();
    }
    
    @Override
    public String getCategory() {
        return component.getCategory();
    }
    
    @Override
    public abstract double applyDiscount();
}
    
    

