public class Item {
    
    // MEMBER VARIABLES
    private String name; 
    private double price;
    

    // CONSTRUCTOR
    //   Takes a name and price as arguments 
    //   and sets them accordingly
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    


    // GETTERS & SETTERS  - for name and price
    // This is the getter for name
    public String getName() {
        return name;
    }

    // This is the setter for name.
    public void setName(String name) {
        this.name = name;
    }

    // This is the getter for price
    public double getPrice() {
        return price;
    }

    // This is the setter for price
    public void setPrice(double price) {
        this.price = price;
    }
}
