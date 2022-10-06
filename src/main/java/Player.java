import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList inventory;

    public Player() {
        int hp = 100;
        inventory = new ArrayList<Item>();
        Item i = new Item("lamp", "a shiny brass lamp");
        inventory.add(i);
    }
    public boolean go(String direction) {
        currentRoom = currentRoom.getRoom(currentRoom);
        if (direction.equalsIgnoreCase("south")) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                return true;
            }else return false;
        }
        else if (direction.equalsIgnoreCase("north")) {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                return true;
            }else return false;
        }
        else if (direction.equalsIgnoreCase("east")) {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                return true;
            }else return false;
        }
        else if (direction.equalsIgnoreCase("west")) {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                return true;
            }else return false;
        } return false;
    }

    public ArrayList<Item> getInventory() {
        if(inventory.isEmpty()){
            return null;
        }else {
            return inventory;
        }
    }
    public void takeItem(Item item){
        inventory.add(item);
    }
    public void dropItem(Item item){
        inventory.remove(item);
    }
    public String getRoomDescription(){
        return currentRoom.getRoomDescription();
    }
    public void setInitialRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }
}



