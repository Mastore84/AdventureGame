public class Item {

    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String toString() {
        return name;
    }
}


