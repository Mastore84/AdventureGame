import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    private String userInput;
    private Adventure game;
    public UserInterface(Adventure game) {
        this.game = game;
        game.createMap();
    }
    public void start() {
        System.out.println(game.getRoomDescription());
        userInput = sc.nextLine();
        if (userInput.equals("look")) {
            System.out.println(game.getRoomDescription());
        }else if(userInput.equalsIgnoreCase("go south")){
            //game.go("south");
            System.out.println(game.getRoomDescription());
        }
    }
}
