/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaderopaii;

/**
 *
 * @author javie
 */
    
    public class DiscountManager {
    private static DiscountManager instance;
    
    private DiscountManager() {
        // Constructor privado para evitar instanciación directa
    }
    
    public static DiscountManager getInstance() {
        if (instance == null) {
            instance = new DiscountManager();
        }
        return instance;
    }
    
    public Component applySummerDiscount(Component product) {
        if ("VERANO".equalsIgnoreCase(product.getCategory())) {
            return new SummerDiscountDecorator(product);
        }
        return product;
    }
    
    public Component applyWinterDiscount(Component product) {
        if ("INVIERNO".equalsIgnoreCase(product.getCategory())) {
            return new WinterDiscountDecorator(product);
        }
        return product;
    }
    
    public Component applyCouponDiscount(Component product, double discountPercentage) {
        return new CouponDiscountDecorator(product, discountPercentage);
    }
    
    public Component applyAllDiscounts(Component product, String couponCode) {
        Component discountedProduct = product;
        
        // Aplicar descuentos automáticos por categoría
        discountedProduct = applySummerDiscount(discountedProduct);
        discountedProduct = applyWinterDiscount(discountedProduct);
        
        // Aplicar descuento por cupón si es válido
        if ("20INV".equals(couponCode) && "INVIERNO".equalsIgnoreCase(product.getCategory())) {
            discountedProduct = applyCouponDiscount(discountedProduct, 0.20);
        }
        
        return discountedProduct;
    }
}

