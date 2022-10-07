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
            if (commandInput[0].equalsIgnoreCase("go")) {
               /*
               vi kører go med go-kommandoens input og hvis den retunerer true, printer vi om hvorvidt du er
               kommet ind i lokalet eller ej
                */
                if (player.go(commandInput[1]))
                    System.out.println("You enter the room to the " + commandInput[1] + ".");
                else System.out.println("You cannot go that way. Try another way");

            }
            //take command
            else if (commandInput[0].equalsIgnoreCase("take") || commandInput[0].equalsIgnoreCase("get")) {
                if (player.takeItem(player.getCurrentRoom().findItem(commandInput[1]))) {
                    player.takeItem(player.getCurrentRoom().findItem(commandInput[1]));
                } else {
                    System.out.println("There is nothing like a(n) " + commandInput[1] + " to take around here.");
                }
            }
            //drop command
            else if (commandInput[0].equalsIgnoreCase("drop")) {
                if (player.dropItem(player.findItem(commandInput[1]))){
                    player.dropItem(player.findItem(commandInput[1]));
                } else System.out.println("You do not have a(n) " + commandInput[1] + " in your inventory.");
            }
            //eat command
            else if (commandInput[0].equalsIgnoreCase("eat")) {
                if(player.findItem(commandInput[1]).isEdible()) {
                    player.eat((commandInput[1]));
                    player.getInventory().remove(player.findItem(commandInput[1]));
                }
                else System.out.println("You cannot eat the " + commandInput[1] + ".");
            }
            //look command
            else if (userInput.equals("look")) {
                if (!player.getCurrentRoom().getItemList().isEmpty()) {
                    System.out.println(player.getRoomDescription());
                    System.out.println("You see the following item(s):");
                    player.getCurrentRoom().displayItems();
                } else System.out.println(player.getRoomDescription());

            }
            //exit command
            else if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! Thanks for playing!");
                shouldContinue = false;
            }
            //help command
            else if (userInput.equalsIgnoreCase("help")) {
                System.out.println("""
                        Available commands:
                                                            
                        'go north': Move north of your position.
                        'go south': Move south of your position.
                        'go east': Move east of your position.
                        'go west': Move west of your position.
                        'look': Look around the current room.
                        'inventory' : Display your current inventory.
                        'take' followed by an item name: Pick up a desired item.
                        'drop': Choose an item from your inventory to drop.
                        'health': Check your current health status.
                        'eat': Eat a food item from your inventory. TODO
                        'help': Display this help screen.
                        'exit': Exits the game.
                                                            
                        """);
            }
            //health command
            else if (userInput.equalsIgnoreCase("health")){
                if(player.getHealth() >= 100){
                    System.out.println("Health: " + player.getHealth() + " - you are in perfect health.");
                }
                else if (player.getHealth() < 100 && player.getHealth() > 74){
                    System.out.println("Health: " + player.getHealth() + " - you are in good health.");
                }
                else if (player.getHealth() < 75 && player.getHealth() > 24){
                    System.out.println("Health: " + player.getHealth() + " - you are moderately healthy, but you would do well to avoid fighting right now.");
                }
                else if (player.getHealth() < 25 && player.getHealth() > 9){
                    System.out.println("Health: " + player.getHealth() + " - you are in extremely poor health, and should find a way to heal yourself\n" +
                            "as soon as possible!");
                }
                else if(player.getHealth() < 10 && player.getHealth() > 0){
                    System.out.println("Health: " + player.getHealth() + " - you are close to death and are in immediate need of healing!");
                }
                else System.out.println(player.getHealth()/*"You don't have any health."*/);
            }

            //inventory command
            else if (userInput.equalsIgnoreCase(("inventory"))) {
                if (player.getInventory() != null) {
                    System.out.println("Your inventory consists of the following item(s):");
                    for (Item item : player.getInventory()) {
                        System.out.println(item.getName() + ",");
                    }
                } else System.out.println("Your inventory is empty.");
            }
            else {
                System.out.println("Invalid command. Please type 'help' to get a list of available commands.");
            }
        }
    }
}