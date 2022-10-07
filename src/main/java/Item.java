public class Item {

    private String name;
    private String description;
    private boolean isEdible;
    public Item(String name, String description, boolean isEdible) {
        this.name = name;
        this.description = description;
        this.isEdible = isEdible;
    }
    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Item(Item item) {
        this.name = item.name;
    }
    public boolean isEdible(){
        return isEdible;
    }

    public String toString() {
        return name;
    }
}


