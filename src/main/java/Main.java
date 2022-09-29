public class Main {

    public static void main(String[] args) {
        Adventure game = new Adventure();
        game.createMap();
        UserInterface userInterface = new UserInterface(game);
        userInterface.start();
    }
}
