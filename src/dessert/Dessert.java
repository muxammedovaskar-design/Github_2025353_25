/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dessert;

/**
 * This class stores information about a dessert
 */

public class Dessert {
// Name of the dessert
private String name;
// Weight of the dessert
private int weight;
// Expiration date
private String bestBefore;
// Time when dessert was added
private String timeAdded;


public Dessert (String name, int weight, String bestBefore, String timeAdded){
    this.name=name;
    this.weight=weight;
    this.bestBefore=bestBefore;
    this.timeAdded=timeAdded;
        
}

    public String getName() {
        return name;
    }
    public int getWeight(){
        return weight;
    }
    public String getBestBefore(){
        return bestBefore;
        
    }
    public String getTimeAdded(){
        return timeAdded;
    }
     /**
     * Returns all dessert info as a string
     */
    
    @Override
    public String toString (){
        return "Dessert: "+ name +
                "\nWeight: " + weight + 
                "\nBest Before: " + bestBefore + 
                "\nTime Added: " + timeAdded + "\n";
    }


   
}
