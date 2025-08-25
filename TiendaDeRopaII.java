/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tiendaderopaii;

import java.util.Scanner;

/**
 *
 * @author javie
 */
public class TiendaDeRopaII {

    public static void main(String[] args) {
        
        

        Scanner scanner = new Scanner(System.in);
        CartManager cartManager = new CartManager();
        DiscountManager discountManager = DiscountManager.getInstance();
        
        System.out.println("====================");
        System.out.println("¡BIENVENIDOS A ADIDAS!");
        System.out.println("====================");
        
        System.out.println("RECUERDA QUE POR ESTE MES TENEMOS:");
        System.out.println("• 10% DE DESCUENTO EN ROPA DE VERANO");
        System.out.println("• 20% DE DESCUENTO EN ROPA DE INVIERNO");
        System.out.println("• CUPÓN 20INV: 20% ADICIONAL EN INVIERNO");
        
        // Productos de ejemplo
        Component poleraVerano = new Product("Polera Adidas Verano", 19990, "VERANO");
        Component shortDeportivo = new Product("Short Adidas", 22000, "VERANO");
        Component chaquetaInvierno = new Product("Chaqueta Adidas Invierno", 45990, "INVIERNO");
        Component buzoInvierno = new Product("Buzo Adidas", 32990, "INVIERNO");
        Component zapatillas = new Product("Zapatillas Ultraboost", 89990, "CALZADO");
        
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver carrito");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Vaciar carrito");
            System.out.println("5. Deshacer última acción");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1 -> {
                    System.out.println("\nSeleccione producto:");
                    System.out.println("1. Polera Verano - $19990");
                    System.out.println("2. Short Deportivo - $22000");
                    System.out.println("3. Chaqueta Invierno - $45990");
                    System.out.println("4. Buzo Invierno - $32990");
                    System.out.println("5. Zapatillas - $89990");
                    System.out.print("Opción: ");
                    
                    int producto = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("¿Tiene cupón? (deje vacío si no): ");
                    String couponCode = scanner.nextLine();
                    
                    Component selectedProduct = null;
                    switch (producto) {
                        case 1 -> selectedProduct = poleraVerano;
                        case 2 -> selectedProduct = shortDeportivo;
                        case 3 -> selectedProduct = chaquetaInvierno;
                        case 4 -> selectedProduct = buzoInvierno;
                        case 5 -> selectedProduct = zapatillas;
                        default -> System.out.println("❌ Producto inválido");
                    }
                    
                    if (selectedProduct != null) {
                        cartManager.addProduct(selectedProduct, couponCode);
                    }
                }
                
                case 2 -> cartManager.showCart();
                
                case 3 -> {
                    if (!cartManager.isEmpty()) {
                        cartManager.showCart();
                        System.out.print("Ingrese número de producto a eliminar: ");
                        int index = scanner.nextInt();
                        cartManager.removeProduct(index - 1);
                    } else {
                        System.out.println("🛒 El carrito está vacío");
                    }
                }
                
                case 4 -> cartManager.clearCart();
                
                case 5 -> cartManager.undoLastCommand();
                
                case 0 -> System.out.println("👋 ¡Gracias por comprar en Adidas!");
                
                default -> System.out.println("❌ Opción inválida");
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
}
        
    
}
