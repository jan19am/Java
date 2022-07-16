public class Gorilla extends Mammal{

    public void throwSomething() {
        if (super.energyLevel < 5) {
            System.out.println("The Gorilla does not have enough energy to throw something.");
        }
        else {
            super.energyLevel -= 5;
            System.out.println(super.energyLevel);
            System.out.println("The Gorilla has thrown something.");
        }
    }

    public void eatBananas() {
        super.energyLevel += 10;
        System.out.println(super.energyLevel);
        System.out.println("The Gorilla loves their bananas.");
    }

    public void climb(){
        if (super.energyLevel < 10) {
            System.out.println("The Gorilla does not have enough energy to climb.");
        }
        else {
            super.energyLevel -= 10;
            System.out.println(super.energyLevel);
            System.out.println("The Gorilla has climbed a tree.");
        }
    }
}
