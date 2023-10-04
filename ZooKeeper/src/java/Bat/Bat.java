package java.Bat;

public class Bat {
    
    // Create a Bat class that can fly(), eatHumans(), and attackTown() and has a default energy level of 300.
    public int energyLevel = 300;
    
    // For the fly() method, print the sound of a bat taking off and decrease its energy by 50.
    public void fly() {
        if (energyLevel < 50) {
            System.out.println("The bat does not have enough energy to fly.");
        }
        else {
            energyLevel -= 50;
            System.out.println("Energy: " + energyLevel);
            System.out.println("The sound of a bat taking off.");
        }
    }

    // For the eatHumans() method, print the so- well, never mind, just increase its energy by 25.
    public void eatHumans() {
        if (energyLevel < 25) {
            System.out.println("The bat does not have enough energy to eat.");
        }
        else {
            energyLevel -= 25;
            System.out.println("Energy: " + energyLevel);
            System.out.println("so- well, never mind.");
        }
    }

    // For the attackTown() method, print the sound of a town on fire and decrease its energy by 100.
    public void attackTown() {
        if (energyLevel < 100) {
            System.out.println("The bat does not have enough energy to attack.");
        }
        else {
            energyLevel -= 100;
            System.out.println("Energy: " + energyLevel);
            System.out.println("the sound of a town on fire.");
        }
    }

}
