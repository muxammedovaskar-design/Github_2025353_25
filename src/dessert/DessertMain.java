/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dessert;

/**
 * This is the main class to run the program
 */
public class DessertMain {

    /**
     * @param args the command line arguments
     */
    //Main method – program starts here
    public static void main(String[] args) {
        Dessertqueue fridge = new Dessertqueue(); // Create a dessert queue (fridge)
        // Create dessert objects
        Dessert d1 = new Dessert ("Cheesecake", 500, "7 days", "21-03-2026 10:00");
        Dessert d2 = new Dessert ("Brownie", 250, "7 days", "21-03-2026 10:10");
        // Add desserts to the queue
        fridge.addDessert(d1);
        fridge.addDessert(d2);
        // Display all desserts
        System.out.println("All desserts:");
        System.out.println(fridge.displayDessert());
        // Show next dessert (without removing)
        System.out.println("Next dessert:");
        System.out.println(fridge.peekDessert());
        // Remove first dessert
        System.out.println("Removed dessert");
        System.out.println(fridge.removeDessert());
        // Show remaining desserts
        System.out.println("After removal:");
        System.out.println(fridge.displayDessert());
    }
    
    
}
