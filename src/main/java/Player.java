import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private int hp;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Room go(String direction) {
        currentRoom = currentRoom.getRoom(currentRoom);
        if (direction.equalsIgnoreCase("south")) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                return currentRoom;
            }else System.out.println("You cannot go in that direction");
        }
        else if (direction.equalsIgnoreCase("north")) {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                return currentRoom;
            }else System.out.println("You cannot go in that direction");
        }
        else if (direction.equalsIgnoreCase("east")) {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                return currentRoom;
            }else System.out.println("You cannot go in that direction");
        }
        else if (direction.equalsIgnoreCase("west")) {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                return currentRoom;
            }else System.out.println("You cannot go in that direction");
        }return null;
    }

    public String getRoomDescription(){
        return currentRoom.getRoomDescription();
    }

    /*public Room getCurrentRoom() {
        return currentRoom;
    }
     */
    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }
}



