public class Food extends Item{

    boolean edible;

    public Food(String name, String description, boolean edible) {
        super(name, description);
        this.edible = edible;
    }
}
