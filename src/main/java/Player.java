import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    int hp;
    private ArrayList<Item> inventory;

    public Player() {
        this.hp = 100;
        inventory = new ArrayList<>();

    }
    public void getHealth(){
        if(hp == 100){
            System.out.println("Health: " + hp + " - you are in perfect health.");
        }
        else if (hp < 100 && hp > 74){
            System.out.println("Health: " + hp + " - you are in good health, but you would do well to avoid fighting right now.");
        }
        else if (hp < 75 && hp > 24){
            System.out.println("Health: " + hp + " - you are in poor health, and should avoid fighting at any cost.");
        }
        else if (hp < 25 && hp > 9){
            System.out.println("Health: " + hp + " - you are in extremely poor health, and should find a way to heal yourself\n" +
                    "as soon as possible!");
        }
        else if(hp < 10 && hp > 0){
            System.out.println("Health: " + hp + " - you are close to death and are in immediate need of healing!");
        }
        else System.out.println("You don't have any health.");
    }
    //movement related methods
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
    //item and inventory related methods
    public ArrayList<Item> getInventory() {
        if(inventory.isEmpty()){
            return null;
        }else {
            return inventory;
        }
    }
    public boolean takeItem(Item item){
        if(currentRoom.getItemList().contains(item)){
            System.out.println("You take the " + item.getName() + ".");
            inventory.add(item);
            currentRoom.removeItem(item);
            return true;
        }
        else return false;
    }
    public boolean dropItem(Item item){
        if(inventory.contains(item)) {
            System.out.println("You drop the " + item.getName() + ".");
            inventory.remove(item);
            currentRoom.addItem(item.getName(), item.getDescription());
            return true;
        }
        else return false;
    }

    public Item findItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    //room related methods
    public String getRoomDescription(){
        return currentRoom.getRoomDescription();
    }

    public void setInitialRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }
}



