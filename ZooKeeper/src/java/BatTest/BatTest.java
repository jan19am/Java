package java.BatTest;
import java.Bat.Bat;

public class BatTest {
    
    public static void main(String[] args) {

// Create a BatTest class to instantiate a bat and have it attack three towns, eat two humans, and fly twice.
    Bat bruce = new Bat();
    bruce.attackTown();
    bruce.attackTown();
    bruce.attackTown();
    bruce.eatHumans();
    bruce.eatHumans();
    bruce.fly();
    bruce.fly();
    }
}