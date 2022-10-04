public class Item {

    private String name;

    public Item(String name, String s) {
        this.name = name;

    }
    public String getName() {
        return name;
    }
    public Item(Item item) {
        this.name = item.name;
    }

    public String toString() {
        return name;
    }
}



