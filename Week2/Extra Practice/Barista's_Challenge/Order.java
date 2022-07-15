import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items = new ArrayList<>(); // defaults to null

    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Guest";
        // ArrayList<Item> items = new ArrayList<>();
    }
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        // ArrayList<Item> items = new ArrayList<>();
    }
    
    // ORDER METHODS
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!

    // Adds Items
    public void addItem(Item item) {
        this.items.add(item);
    // This sysout line is to see if the code itself
    // is working. Basically a trial code.
        // System.out.println(this.items);
    }

    // Gives order status
    public String getStatusMessage() {
        if (ready == true) {
            return "Your order is ready\n";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.\n";
        }
    }

    // Sums up the order
    public double getOrderTotal() {
        double sum = 0.0;
        for (int i = 0; i < items.size(); i++) {
            sum +=  items.get(i).getPrice();
        }
        return sum;
    }

    
    public void display() {
        System.out.printf("Customer Name:  %s \n\n",getName());
        for (int i = 0; i < items.size(); i++) {
        System.out.printf("%s - $%.2f \n\n" ,items.get(i).getName(), items.get(i).getPrice());
        }
        System.out.printf("Total: $%.2f\n\n\n", getOrderTotal());
    }

    // GETTERS & SETTERS

    // This is the getter for name
    public String getName() {
        return name;
    }

    // This is the setter for name
    public void setName(String name) {
        this.name = name;
    }

    // This is the getter for ready
    public boolean isReady() {
        return ready;
    }
    
    // This is the setter for ready
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    // ArrayList<Item> Getter
    public ArrayList<Item> getItems() {
        return items;
    }

    // ArrayList<Item> Setter
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

}

