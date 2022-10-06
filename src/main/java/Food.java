public class Food extends Item{

    int healthPoints;

    public Food(String name, String description, int healthPoints) {
        super(name, description);
        this.healthPoints = healthPoints;
    }
}
