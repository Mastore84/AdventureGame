public class Room {

    private String roomName;
    private String roomDescription;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    public Room(String roomName, String roomDescription){
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        north = null;
        south = null;
        east = null;
        west = null;
    }

    public void setNorth(Room room){
        this.north = room;
    }

    public void setSouth(Room room){
        this.south = room;
    }

    public void setEast(Room room){
        this.east = room;
    }

    public void setWest(Room room){
        this.west = room;
    }

    public Room getSouth(){
        return south;
    }
    public String getRoomDescription(){
        return roomDescription;
    }

    public boolean moveSouth(){
        if(south == null){
            return false;
        }else return true;
    }
}
