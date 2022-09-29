public class Adventure {

    private Room currentRoom;

    public void createMap() {
        Room room1 = new Room("Room1", "This room is filled with the stench of death and decay.\n" +
                "Rats run across the putrid corpses of other failed adventures. Maybe you will join them. Tread carefully.");

        Room room2 = new Room("Room2", "The room appears very dark and desolate. The \n" +
                "freezing temperature chills you to the bone, almost numbing you in the process.\n" +
                "The feeling of wanting to escape grows increasingly stronger...");

        Room room3 = new Room("Room3", "You arrive in an ancient dungeon jail..\n" +
                "What meets you is the remains of a giant troll, its skeletons embracing the ancient chains");

        Room room4 = new Room("Room4", "This is room 4");

        Room room5 = new Room("Room5", "Middle Room");

        Room room6 = new Room("Room6", "");

        Room room7 = new Room("Room7", "");

        Room room8 = new Room("Room8", "");

        Room room9 = new Room("Room9", "");

        //Room 1 connections
        room1.setEast(room2);
        room1.setSouth(room4);

        //Room 2 connections
        room2.setEast(room3);
        room2.setWest(room1);

        //Room 3 connections
        room3.setWest(room2);
        room3.setSouth(room6);

        //Room 4 connections
        room4.setNorth(room1);
        room4.setSouth(room7);

        //Room 5 connections
        room5.setSouth(room8);

        //Room 6 connections
        room6.setNorth(room3);
        room6.setSouth(room9);

        //Room 7 connections
        room7.setNorth(room4);
        room7.setEast(room8);

        //Room 8 connections
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        //Room 9 connections
        room9.setWest(room8);
        room9.setNorth(room6);

        currentRoom = room1;
    }

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
}
