import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    private String userInput;
    private Adventure game;
    private boolean shouldContinue = true;
    public UserInterface(Adventure game) {
        this.game = game;
        game.createMap();
    }
    public void start() {
        System.out.println("You enter the room.");
        while (shouldContinue){
            userInput = sc.nextLine();
            if (userInput.equals("look")) {
                System.out.println(game.getRoomDescription());
            }else if(userInput.equalsIgnoreCase("go south")){
                game.go("south");
                System.out.println("You enter the room.");
            }else if(userInput.equalsIgnoreCase("go north")){
                game.go("north");
                System.out.println("You enter the room.");
            }else if(userInput.equalsIgnoreCase("go east")){
                game.go("east");
                System.out.println("You enter the room.");
            }else if(userInput.equalsIgnoreCase("go west")){
                game.go("west");
                System.out.println("You enter the room.");
            }else if (userInput.equalsIgnoreCase("exit")){
                System.out.println("Goodbye! Thanks for playing!");
                shouldContinue = false;
            }
            else {
                System.out.println("Invalid command. Please type 'go' followed by a direction");
            }
        }
    }
}
