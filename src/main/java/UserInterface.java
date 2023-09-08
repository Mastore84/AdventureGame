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
                if (commandInput.length > 1) {
                    if (player.takeItem(player.getCurrentRoom().findItem(commandInput[1]))) {
                        player.takeItem(player.getCurrentRoom().findItem(commandInput[1]));
                    } else {
                        System.out.println("There is nothing like a(n) " + commandInput[1] + " to take around here.");
                    }
                } else {
                    System.out.println("Invalid command. Please type 'help' to get a list of available commands.");
                }
            }
            //drop command
            else if (commandInput[0].equalsIgnoreCase("drop") && commandInput.length > 1) {
                if (player.dropItem(player.findItem(commandInput[1]))) {
                    player.dropItem(player.findItem(commandInput[1]));
                } else {
                    System.out.println("You do not have a(n) " + commandInput[1] + " in your inventory.");
                }
            }
            //eat command
            else if (commandInput[0].equalsIgnoreCase("eat") && commandInput.length > 1) {
                if (player.findItem(commandInput[1]) != null) {
                    if (player.findItem(commandInput[1]).isEdible()) {
                        player.eat((commandInput[1]));
                        player.getInventory().remove(player.findItem(commandInput[1]));
                    } else if (!player.findItem(commandInput[1]).isEdible()) {
                        System.out.println("You cannot eat the " + commandInput[1] + ".");
                    }
                } else {
                    System.out.println("You do not have a(n) " + commandInput[1] + " in your inventory.");
                }
            }
            //equip command
            else if (commandInput[0].equalsIgnoreCase("equip") && commandInput.length > 1) {
                if (player.findItem(commandInput[1]) != null) {
                    if (player.getEquippedWeapon() != null) {
                        System.out.println("You already have a weapon equipped.\n" +
                                "Unequip that weapon first.");
                    } else if (player.findItem(commandInput[1]).isEquippable()) {
                        player.equip(commandInput[1]);
                        System.out.println("You equip the " + commandInput[1] + ".");
                    } else if (!player.findItem(commandInput[1]).isEquippable()) {
                        System.out.println("You cannot equip the " + commandInput[1] + ".");
                    }
                } else {
                    System.out.println("You do not have a(n) " + commandInput[1] + " in you inventory.");
                }
            }
            //unequip command
            else if (commandInput[0].equalsIgnoreCase("unequip") && commandInput.length > 1) {
                if (player.findWeapon(commandInput[1]) != null) {
                    if (player.getEquippedWeapon().equals(player.findWeapon(commandInput[1]))) {
                        player.unequip(commandInput[1]);
                        System.out.println("You unequip the " + commandInput[1] + ".");
                    }
                } else {
                    System.out.println("You have no " + commandInput[1] + " equipped.");
                }
            }
            //look command
            else if (userInput.equalsIgnoreCase("look")) {
                if (!player.getCurrentRoom().getItemList().isEmpty()) {
                    System.out.println(player.getRoomDescription());
                    System.out.println("You see the following item(s):");
                    player.getCurrentRoom().displayItems();
                    if (!player.getCurrentRoom().getEnemyList().isEmpty()) {
                        System.out.println("You see the following monster(s):");
                        player.getCurrentRoom().displayEnemies();
                    }
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
                                                            
                        'go *north*south*east*west*': Go in the desired direction.
                        'look': Look around the current room.
                        'inventory' or 'inv': Display your current inventory.
                        'take *item*' or 'get *item*': Pick up a desired item.
                        'drop *item*': Drop an item from your inventory.
                        'health': Check your current health status.
                        'eat *item*': Eat a food item from your inventory.
                        'equip *item*': Equip a weapon from your inventory.
                        'unequip *item*': Unequip a weapon you have equipped.
                        'attack *enemy*': Attack an enemy.
                        'help': Display this help screen.
                        'exit': Exits the game.
                                                            
                        """);
            }
            //attack command
            else if (commandInput[0].equalsIgnoreCase("attack")) {
                if (player.getEquippedWeapon() != null) {
                    if (commandInput.length > 1) {
                        if(player.getEquippedWeapon().getRemainingAmmo() == 0 && player.getEquippedWeapon().isRanged() == true){
                            System.out.println("Your weapon has no more ammunition in it.");
                        } else if (player.getCurrentRoom().getEnemyList() != null) {
                            if (player.getCurrentRoom().getEnemy(commandInput[1]) != null) {
                                player.getCurrentRoom().getEnemy(commandInput[1]).getHit(player.attack(player.getEquippedWeapon().getDamage()));
                                System.out.println("You attack the " + commandInput[1] + " for " + player.getEquippedWeapon().getDamage() + " damage!");
                                if(player.getEquippedWeapon().isRanged() && player.getEquippedWeapon().getRemainingAmmo() != 0){
                                    player.getEquippedWeapon().removeRemainingAmmo();
                                }
                                if(player.getCurrentRoom().getEnemy(commandInput[1]).getHealthPoints() > 0) {
                                    player.getHit(player.getCurrentRoom().getEnemy(commandInput[1]).getWeapon().getDamage());
                                    System.out.println("The " + commandInput[1] + " attacks you for " + player.getCurrentRoom().getEnemy(commandInput[1]).getWeapon().getDamage() + " damage!");
                                } else {
                                    System.out.println("You've killed the " + commandInput[1] + "!");
                                    player.getCurrentRoom().getEnemyList().remove(player.getCurrentRoom().getEnemy(commandInput[1]));
                                }if (player.getHealth() <= 0){
                                    System.out.println("\nYou have been killed by the " + commandInput[1] + "!\n" +
                                            "Game over! Better luck next time!");
                                        System.exit(1);
                                }
                            }else System.out.println("There is no " + commandInput[1] + " for you to attack here.");
                        } else System.out.println("There is no enemy here for you to attack.");
                    } else System.out.println("Please state which enemy you wish to attack.");
                }else System.out.println("You cannot attack without a weapon equipped!");
            }

            //health command
            else if (userInput.equalsIgnoreCase("health")) {
                if (player.getHealth() >= 100) {
                    System.out.println("Health: " + player.getHealth() + " - you are in perfect health.");
                } else if (player.getHealth() < 100 && player.getHealth() > 74) {
                    System.out.println("Health: " + player.getHealth() + " - you are in good health.");
                } else if (player.getHealth() < 75 && player.getHealth() > 24) {
                    System.out.println("Health: " + player.getHealth() + " - you are moderately healthy, but you would do well to avoid fighting right now.");
                } else if (player.getHealth() < 25 && player.getHealth() > 9) {
                    System.out.println("Health: " + player.getHealth() + " - you are in extremely poor health, and should find a way to heal yourself\n" +
                            "as soon as possible!");
                } else if (player.getHealth() < 10 && player.getHealth() > 0) {
                    System.out.println("Health: " + player.getHealth() + " - you are close to death and are in immediate need of healing!");
                } else System.out.println("You don't have any health.");
            }

            //inventory command
            else if (userInput.equalsIgnoreCase(("inventory")) || userInput.equalsIgnoreCase("inv")) {
                if (player.getInventory() != null) {
                    System.out.println("Your inventory consists of the following item(s):");
                    for (Item item : player.getInventory()) {
                        System.out.println(item.getName() + ",");
                    }
                } else System.out.println("Your inventory is empty.");
                if (player.getEquippedWeapon() != null) {
                    for (Weapon item : player.getEquippedWeaponList()) {
                        System.out.println("You have a(n) " + item.getName() + " equipped, which can deal " + item.getDamage() + " points of damage.");
                        if (item.isRanged()) {
                            System.out.println("It has " + item.getRemainingAmmo() + " use(s) left.");
                        }
                    }
                } else {
                    System.out.println("You do not have a weapon equipped.");
                }
            } else {
                System.out.println("Invalid command. Please type 'help' to get a list of available commands.");
            }
        }
    }
}