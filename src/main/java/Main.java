public class Main {

    public static void main(String[] args) {
       /* Adventure game = new Adventure();
        game.createMap();
        UserInterface userInterface = new UserInterface(game);
        userInterface.start();*/
        Room room1 = new Room("hsdsfhb", "dfasub");
        Room room2 = new Room("auuuueee", "");
        Adventure game = new Adventure();
        room1.setSouth(room2);
        room2.setNorth(room1);
        System.out.println(room1);
        Room currentRoom = room1;
        //game.go("south", currentRoom);
        System.out.println(room1);
        System.out.println(room2);

    }
}
