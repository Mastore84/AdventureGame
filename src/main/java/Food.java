public class Food extends Item{

    int healthPoints;

    public Food(String name, String description, boolean isEdible, int healthPoints) {
        super(name, description, isEdible);
        this.healthPoints = healthPoints;
    }
}
