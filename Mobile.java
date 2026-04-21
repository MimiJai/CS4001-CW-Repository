// This class represents a Mobile phone.
// It extends Gadget and adds credit for making calls.
public class Mobile extends Gadget {
    
    private double credit; 

    public Mobile(String model, double price, int weight, String size, double credit ) {
        super(model, price, weight, size);
        this.credit = credit; 
    }
    // Returns the current credit
    public double getCredit() { 
        return credit;
    }
    // Adds credit to the mobile
    public void addCredit(double amount) {
    if (amount > 0) {
        credit += amount;
    } else {
        System.out.println("Credit amount must be positive.");
    }
}
    
    // Reduces credit when a call is made
    public void makeCall(double minutes) {
    if (minutes <= 0) {
        System.out.println("Call duration must be positive.");
    } else if (credit >= minutes) {
        credit -= minutes;
        System.out.println("Call made for " + minutes + " minutes.");
    } else {
        System.out.println("Not enough credit to make the call.");
    }
}
    
    // shows mobile details including credit
    @Override
    public void display() {
        super.display();
        System.out.println("Credit: " + credit);
        
}
     @Override
    public String toString() {
        return "Mobile{model='" + getModel() + "' | credit=" + credit + "}";
    }

}
