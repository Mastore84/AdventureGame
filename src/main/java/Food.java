public class Food extends Item{

    int healthPoints;

    public Food(String name, String description, boolean isEdible, boolean isEquippable, int healthPoints) {
        super(name, description, isEdible, isEquippable);
        this.healthPoints = healthPoints;
    }
    public int getHealthPoints(){
        return healthPoints;
    }
}
