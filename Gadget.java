// This class represents a general gadget
// It stores basic information such as model, price, weight, and size
// Other classes, such as Mobile and MP3, will use this as a base class
public class Gadget {
    private final String model;
    private double price; 
    private int weight; 
    private String size;
    
 // Constructor to create a Gadget with its details
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size; 
    }
// Getter methods to return the gadget details
    public String getModel() {
        return model;
    }
    public double getPrice() {
        return price;
    }
    
    public int getWeight() {
        return weight; 
    }
    
    public String getSize() {
        return size;
    }
    // This method displays the gadget details in the console
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Weight: " + weight);
        System.out.println("Size: " + size); 
    }
}