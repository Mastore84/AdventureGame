import java.util.Scanner;

public class UserInterface {
    private Player player;
    private Adventure game;
    private Scanner sc;
    private String userInput;
    private boolean shouldContinue = true;

    public UserInterface(Adventure game) {
        sc = new Scanner(System.in);
        this.game = game;

    }

    public void start() {
        player = game.getPlayer();
        System.out.println("Welcome to the game! Type 'help' for a list of available commands\n" +
                "type 'look' to get a description of your current room\n" +
                "type 'exit' to exit the game\n" +
                "\nYou enter the castle. As you enter, the door shuts behind you. In vain, you attempt to open the door,\n" +
                "only to discover that it has been locked up tight. You are trapped! Your only means of escape is to\n" +
                "search the castle for a way out.\n" +
                "Good luck hero!\n");
        while (shouldContinue) {
            System.out.println("Type command: ");
            userInput = sc.nextLine();
           /*
           vi tjekker for go-kommando ved først at splitte ved mellemrum, og tjekker at første kommando er go
           ellers tjekker vi om første input er look, exit eller help.
            */
            String[] commandInput = userInput.split(" ");
            if (commandInput[0].equals("go")) {
               /*
               vi kører go med go-kommandoens input og hvis den retunerer true, printer vi om hvorvidt du er
               kommet ind i lokalet eller ej
                */
                if (player.go(commandInput[1]))
                    System.out.println("You enter the room to the " + commandInput[1]);
                else System.out.println("You cannot go that way. Try another way");

            } else {
                if (userInput.equals("look")) {
                    System.out.println(player.getRoomDescription());
                } else if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye! Thanks for playing!");
                    shouldContinue = false;
                } else if (userInput.equalsIgnoreCase("help")) {
                    System.out.println("""
                            Available commands:
                                                                
                            'go north': Move north of your position.
                            'go south': Move south of your position.
                            'go east': Move east of your position.
                            'go west': Move west of your position.
                            'look': Look around the current room.
                            'inventory' : Display your current inventory.
                            'take' followed by an item name: Pick up a desired item. TODO
                            'drop': Choose an item from your inventory to drop. TODO
                            'health': Check your current health status. TODO
                            'eat': Eat a food item from your inventory. TODO
                            'help': Display this help screen.
                            'exit': Exits the game.
                                                                
                            """);
                } else if (userInput.equalsIgnoreCase(("inventory"))) {
                    if(player.getInventory() != null) {
                        System.out.println("Your inventory consist of the following items:");
                        System.out.println(player.getInventory());
                    }else System.out.println("Your inventory is empty.");
                } else if (userInput.equalsIgnoreCase("drop")) {

                } else {
                    System.out.println("Invalid command. Please type 'help' to get a list of available commands.");
                }
            }
        }
    }
}