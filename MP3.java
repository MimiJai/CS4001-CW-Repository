// Adds music to the MP3
public class MP3 extends Gadget {
    private int memory;

    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }
    // Returns the memory of the MP3
    public int getMemory() {
        return memory; 
    }
    // This method downloads music and reduces available memory
    public void downloadMusic(int amount) {
    if (amount <= 0) {
        System.out.println("Download size must be positive.");
    } else if (memory >= amount) {
        memory -= amount;
        System.out.println("Music downloaded successfully.");
    } else {
        System.out.println("Not enough memory available.");
    }
}
    // This method removes music from the MP3 memory
    public void deleteMusic(int amount) {
    if (amount > 0) {
        memory += amount;
    } else {
        System.out.println("Delete size must be positive.");
    }
}

// This method returns a string showing MP3 details
@Override
public String toString() {
    return "MP3{model='" + getModel() + "' | memory=" + memory + "}";
}
    // This method displays MP3 details including memory
    @Override
    public void display() {
        System.out.println("MP3");
        super.display();
        System.out.println("memory=" + memory);
    }
}