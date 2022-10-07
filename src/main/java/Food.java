public class Food extends Item{

    int healthPoints;

    public Food(String name, String description, int healthPoints, boolean isEdible) {
        super(name, description, isEdible);
        this.healthPoints = healthPoints;
    }
}
