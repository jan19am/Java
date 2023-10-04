import java.util.ArrayList;
public class CafeUtil {

    public int getStreakGoal() {
        int sum = 0;
        for(int i = 0; i < 11; i++) {
            sum += i;
        }
        return sum;
    }

// double means my return type
// getOrderTotal is the name of my function
// double[] input type and brackets means that it is a list
    public double getOrderTotal(double[] lineItems) {   
        double sum = 0;
        for(int i = 0; i < lineItems.length; i++) {
            sum += lineItems[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menu) {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i +" "+ menu.get(i));
        }
    }
    
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println("There are " + customers.size() + 
        " people in front of you.");
        customers.add(userName);
        System.out.println(customers);    
    }

}
