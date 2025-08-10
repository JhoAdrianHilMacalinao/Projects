/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bsiteacallgroup3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author HILMACLEAR
 */
public class BSITeacallGroup3 {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        // Initialize menu using a HashMap for flavors
        Map<String, Double> menu = new HashMap<>();// this is where you will set  the menu, 
        menu.put("Chocolada", 30.00);
        menu.put("Milktea", 20.00);
        menu.put("Ube tea", 30.00);

        // Initialize size adjustments
        Map<String, Double> size = new HashMap<>();//this is the sizes
        size.put("small", 0.00);
        size.put("medium", 20.00);
        size.put("large", 40.00);

        System.out.println("Welcome to BSITeacall! Please state your name:");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        while (true) {
            // Display menu for teas
            System.out.println("The available teas for today are:");
            menu.forEach((tea, price) -> System.out.println(tea + " - P" + String.format("%.2f", price)));//this will display the available tea
            System.out.println("\nPlease enter the name of the tea you want to order:");
            String choice = scanner.nextLine().trim();//the trim is used to remove additional spaces that  has been made in the beginning and at the last part

            if (menu.containsKey(choice)) {
                double basePrice = menu.get(choice);
                System.out.println("You have selected: " + choice + " - P" + String.format("%.2f", basePrice));

                // Ask for the size of the tea
                System.out.println("Please select the size of the tea (small, medium, large):");
                String selectedSize = scanner.nextLine().trim().toLowerCase();

                if (size.containsKey(selectedSize)) {
                    double sizePrice = size.get(selectedSize);
                    double totalPrice = basePrice + sizePrice;

                    System.out.println("You have selected a " + selectedSize + " " + choice + " - P" + String.format("%.2f", totalPrice));

                    // Ask for the payment
                    System.out.println("How much would you like to pay?");
                    double amountPay;

                    try {
                        amountPay = scanner.nextDouble();
                        scanner.nextLine(); // Clear newline from buffer
                    } catch (Exception e) {
                        System.out.println("Invalid amount entered. Please try again.");
                        scanner.nextLine(); // Clear invalid input
                        continue;
                    }

                    // Process payment
                    if (amountPay >= totalPrice) {
                        double change = amountPay - totalPrice;
                        System.out.println("Thank you! Your change is: P" + String.format("%.2f", change));
                    } else {
                        double remaining = totalPrice - amountPay;
                        System.out.println("Sorry, you still owe P" + String.format("%.2f", remaining));
                    }
                } else {
                    System.out.println("Sorry, that size is not available. Please try again.");
                    continue;
                }
            } else {
                System.out.println("That tea is not on our menu. Please try again.");
                continue;
            }

            // Ask if the customer wants to order again
            System.out.println("\nWould you like to order again? (yes/no)");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("no")) {
                System.out.println("Thank you for visiting! Goodbye.");
                break;
            } else if (!answer.equalsIgnoreCase("yes")) {
                System.out.println("Invalid response. Exiting.");
                break;
            }
        }

        scanner.close();
    }
}

    


    

