import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello, " + name;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        // YOUR CODE HERE
        return "The Current Time is: " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        return conversation;
    }


    public String inspirationalQuotes(String quote) {
        return quote;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

