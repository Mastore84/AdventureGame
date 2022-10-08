public class Item {

    private String name;
    private String description;
    private boolean isEdible;
    private boolean isEquippable;

    public Item(String name, String description, boolean isEdible, boolean isEquippable) {
        this.name = name;
        this.description = description;
        this.isEdible = isEdible;
        this.isEquippable = isEquippable;
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
    public boolean isEquippable(){
        return isEquippable;
    }
    public String toString() {
        return name;
    }
}


