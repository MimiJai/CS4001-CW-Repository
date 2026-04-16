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
    // This method adds music to the MP3 by increasing memory used
    public void downloadMusic(int amount) {
        memory = memory + amount;
    }
    // This method removes music from the MP3 memory
    public void deleteMusic(int amount) {
        memory = memory - amount;
    }
    // This method returns a string showing MP3 details
    @Override
    public String toString() {
        return "MP3{model='" + getModel() + "' | memory='" + memory + "'}";
    }
    // This method displays MP3 details including memory
    @Override
    public void display() {
        System.out.println("MP3");
        super.display();
        System.out.println("memory=" + memory);
    }
}