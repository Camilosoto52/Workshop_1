/**
 * This module will try to recreate an application for purchasing electronic devices.
 *
 * Copyright (C) 2024  Juan Camilo Soto Martinez  <juancamilosoto52@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * This class represents an appliance store.
 *
 * Args:
 *  input (Scanner): Allows me to enter the data.
 *  receipts (ArrayList<Receipt>): Keep the receipts made.
 *  shCart (ArrayList): It is the shopping cart where the chosen devices are stored.
 *  com (boolean): It is used in some menus.
 * 
 */
import java.util.Scanner;

public class Store_Manager {
    
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to My virtual Shop"){

        // Selecction Of Category 
        boolean continueBuy = true;
        while (continueBuy) {
            System.out.println("Select a category to view products:");
            for (Product.Smartphones category1 : Product.Smartphones.values()) {
                System.out.println("Smartphones" + category1);
            }
            System.out.println("Select a category to view products:");
            for (Product.Accessories  category2 : Product.Accessories.values()) {
                System.out.println("Accessories" + category2);
            }

            String inputCategory = scanner.nextLine().toUpperCase();
            Product.Smartphones categoryselected;
            try {
                categoryselected = Product.Smartphones.valueOf(inputCategory);
                store.showproductsbySmartphones(categoryselected);
                
            }
            catch (IllegalArgumentException e) {
                System.out.println(" Invalid category ");
                continue;
            }

            try {
                Product.Accessories categoryselected1 = Product.Accessories.valueOf(inputCategory);
                store.showproductsbyAccesories(categoryselected1);
                
            } catch (IllegalArgumentException e) {
                System.out.println(" Invalid category ");
                continue;
            }

            // Add products to cart
            boolean follow = true;
            while (follow) {
                System.out.print("Enter the name of the product (0 to exit : ");
                int idProducto = scanner.nextInt();
                if (idProducto == 0) {
                    seguir = false;
                } else {
                    Product product = store.ObtainProductById(idProducto);
                    if (product != null) {
                        cart.agregarProducto(Product product);
                    } else {
                        System.out.println("Product doesnt finded");
                    }
                }
            }

            // Ask if you want to continue shopping in another category
            System.out.print("Do you want to continue buying? (Y/N): ");
            scanner.nextLine();  // Clean buffer
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals("N")) {
                continueBuy = false;
            }
        }

        // Create the customer and the order
        System.out.print("Enter your name ");
        String namecustomer = scanner.nextLine();
        System.out.print("Enter your adress for shipping ");
        String adress = scanner.nextLine();

        Customer customer = new Customer(namecustomer, adress);
        Order order = new Order(customer, cart);

        // Send the order
        order.send();
    
}
}