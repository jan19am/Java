public class Mammal {

    public int energyLevel = 100;

    public int displayEnergy() {
        System.out.println("Energy: " + energyLevel);
        return energyLevel;
    }

    public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
