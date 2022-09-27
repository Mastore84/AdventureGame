public class Adventure {

    UserInterface userInterface = new UserInterface();

    private String currentRoom;
    Room room1 = new Room("Room1", "This room is filled with the stench of death and decay.\n" +
            "Rats run across the putrid corpses of other failed adventures. Maybe you will join them. Tread carefully.");

    Room room2 = new Room("Room2", "The room appears very dark and desolate. The \n" +
            "freezing temperature chills you to the bone, almost numbing you in the process.\n" +
            "The feeling of wanting to escape grows increasingly stronger...");

    Room room3 = new Room("Room3", "You arrive in an ancient dungeon jail..\n" +
            "What meets you is the remains of a giant troll, its skeletons embracing the ancient chains");
    Room room4 = new Room("Room4", "");
    Room room5 = new Room("Room5", "Middle Room");
    Room room6 = new Room("Room6", "");
    Room room7 = new Room("Room7", "");
    Room room8 = new Room("Room8", "");
    Room room9 = new Room("Room9", "");

    public void go(String direction){

    }

    public void start(){
        userInterface.acceptInput();
        //System.out.println(room1.getRoomDescription());
        //System.out.println(room5.getRoomDescription());
    }
}
