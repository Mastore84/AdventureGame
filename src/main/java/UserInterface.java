import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    String userInput = sc.nextLine();

    public UserInterface() {
    }
    public void acceptInput() {
        if (userInput.equals("look")) {
            room1.getRoomDescription();
        }
    }
}
