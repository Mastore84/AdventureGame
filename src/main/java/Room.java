import java.util.ArrayList;

public class Room {

    private ArrayList<Item> items;

    private String roomName;
    private String roomDescription;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        north = null;
        south = null;
        east = null;
        west = null;
        this.items = new ArrayList<>();
    }

    public void setNorth(Room room) {
        this.north = room;
    }

    public void setSouth(Room room) {
        this.south = room;
    }

    public void setEast(Room room) {
        this.east = room;
    }

    public void setWest(Room room) {
        this.west = room;
    }

    public Room getSouth() {
        return south;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public Room getRoom(Room currentRoom) {
        return currentRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getName() {
        return roomName;
    }

    @Override
    public String toString() {
        String northName;
        String southName;
        String westName;
        String eastName;
        if (north != null) northName = north.getName();
        else northName = "null";
        if (south != null) southName = south.getName();
        else southName = "null";
        if (west != null) westName = west.getName();
        else westName = "null";
        if (east != null) eastName = east.getName();
        else eastName = "null";
        return "Room{" +
                "roomName='" + getRoomName() + '\'' +
                ", roomDescription='" + getRoomDescription() + '\'' +
                ", north=" + northName +
                ", south=" + southName +
                ", east=" + eastName +
                ", west=" + westName +
                '}';
    }


//metode for at lave og tilføje items

    public void addItem(String description, String name, boolean isEdible) {
        this.items.add(new Item(description, name, isEdible));
    }
    public void addFood(String description, String name, int healthPoints, boolean edible){
        this.items.add(new Food(description, name, healthPoints, edible));
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
    public ArrayList<Item> getItemList(){
        return items;
    }
    //display items in a room when using the 'look' command
    public void displayItems(){
        for (Item item : items) {
            System.out.print(item.getDescription());
            System.out.println(", ");
        }
    }
}
