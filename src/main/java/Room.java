public class Room {

    private String roomName;
    private String roomDescription;
    private String north;
    private String south;
    private String east;
    private String west;

    public Room(String roomName, String roomDescription){
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        north = null;
        south = null;
        east = null;
        west = null;
    }

    public void setNorth(Room room){
        room.north = "north";
    }

    public void setSouth(Room room){
        room.south = "south";
    }

    public void setEast(Room room){
        room.east = "east";
    }

    public void setWest(Room room){
        room.west = "west";
    }

    public String getRoomDescription(){
        return roomDescription;
    }
}
