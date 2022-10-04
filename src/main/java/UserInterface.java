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
        System.out.println("Welcome to the game! Type help for a list of availible commands\n" +
                "type look to get a description of your current room\n" +
                "type exit to exit the game\n" +
                "you enter the castle");
        while (shouldContinue){
            userInput = sc.nextLine();
           /*
           vi tjekker for go-kommando ved først at splitte ved mellemrum, og tjekker at første kommando er go
           ellers tjekker vi om første input er look, exit eller help.
            */
            String[] commandInput = userInput.split(" " );
            if (commandInput[0].equals("go")){
               /*
               vi kører go med go-kommandoens input og hvis den retunerer true, printer vi om hvorvidt du er
               kommet ind i lokalet eller ej
                */
                if(game.go(commandInput[1]))
                System.out.println("You enter the room to the " + commandInput[1]);
                else System.out.println("You cannot go that way. Try another way");

            }
            else {
                if (userInput.equals("look")) {
                    System.out.println(game.getRoomDescription());
                }else if (userInput.equalsIgnoreCase("exit")){
                    System.out.println("Goodbye! Thanks for playing!");
                    shouldContinue = false;
                }else if (userInput.equalsIgnoreCase("help")){
                    System.out.println("""
                                    Available commands:
                                    
                                    'Go north': Move north of your position.
                                    'Go south': Move south of your position.
                                    'Go east': Move east of your position.
                                    'Go west': Move west of your position.
                                    'help': Display this help screen.
                                    'exit': Exits the game.
                                    
                                    """);
            }
            else {
                System.out.println("Invalid command. Please type 'help' to get a list of available commands.");
            }

            }



        }
    }
}
