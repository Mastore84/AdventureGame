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

        Room room4 = new Room("Room4", "kaejnfkjaenf");

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

    public boolean go(String direction, Room currentRoom) {
        if (direction.equalsIgnoreCase("south")) {
            System.out.println(currentRoom.getSouth());
            if (currentRoom.getSouth() != null) {
                System.out.println(currentRoom.getSouth());
                currentRoom.setSouth(currentRoom.getSouth());

               return true;
            }
        }return false;
    }


    public String getRoomDescription(){
        return currentRoom.getRoomDescription();
    }

    public void start() {
        /*userInterface.acceptInput();
        System.out.println(room1.getRoomDescription());
        System.out.println(room5.getRoomDescription());*/
    }
}
