import java.util.ArrayList;

public class TestOrders {
    
    public static void main(String[] args) {

    // ******This was built for trial purposes******
    //     Order order1 = new Order("Harold");
    //     Item item1 = new Item("mocha", 2.5);
    //     Item item2 = new Item("mocha", 2.5);
    //     order1.setReady(false);
    //     order1.addItem(item1);
    //     order1.addItem(item2);
    //     // item1.setPrice(2.5);

    //     // Setting it this way will display the Customer Name, Items in the order, and the Total
    //     // order1.displayOrderInfo();

    //     This was a test sysout
    //     System.out.println(order1.getOrderTotal());

    // Menu Items
    Item item1 = new Item("mocha", 2.5);
    Item item2 = new Item("latte", 2.5);
    Item item3 = new Item("drip coffee", 3.0);
    Item item4 = new Item("capuccino", 3.5);
    

    // Create 2 orders for unspecified guests (without specifying a name);
    Order order1 = new Order();
    order1.addItem(item1);

    Order order2 = new Order();
    order2.addItem(item4);

    // Create 3 orders using the overloaded constructor to give each a name for the order.
    Order order3 = new Order("Moe");
    order3.addItem(item3);
    order3.addItem(item4);

    Order order4 = new Order("Larry");
    order4.addItem(item1);

    Order order5 = new Order("Curly");
    order5.addItem(item2);


    // Add at least 2 items to each of the orders using the addItem method you wrote, for example, to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);
// -- I added the items underneath each order that it belongs to

// Test the results and the display method by calling the display method on all of your orders, like so: order3.display();
// order1.display();
// order2.display();
// order3.display();
// order4.display();
// order5.display();


// Test your getStatusMessage functionality by setting some orders to ready and printing the messages for each order. For example: order2.setReady(true); System.out.println(order2.getStatusMessage());

    // order1.setReady(true);
    // order4.setReady(true);
    // order3.setReady(false);
    // order2.setReady(false);
    // order5.setReady(false);

    // System.out.println(order1.getStatusMessage());
    // System.out.println(order2.getStatusMessage());
    // System.out.println(order3.getStatusMessage());
    // System.out.println(order4.getStatusMessage());
    // System.out.println(order5.getStatusMessage());


    // Implement the getOrderTotal method within the Order class
    // System.out.printf("$%.2f\n",order1.getOrderTotal());
    // System.out.printf("$%.2f\n",order2.getOrderTotal());
    // System.out.printf("$%.2f\n",order3.getOrderTotal());
    // System.out.printf("$%.2f\n",order4.getOrderTotal());
    // System.out.printf("$%.2f\n",order5.getOrderTotal());

    // Test the total by printing the return value like so: System.out.println(order1.getOrderTotal());

    }
}
