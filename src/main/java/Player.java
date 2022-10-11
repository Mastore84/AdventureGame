import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    int hp;
    private ArrayList<Item> inventory;
    private ArrayList<Weapon> equippedWeapon;

    public Player() {
        this.hp = 100;
        inventory = new ArrayList<>();
        equippedWeapon = new ArrayList<>();

    }
    public int getHealth(){
        return hp;
    }
    //movement related methods
    public boolean go(String direction) {
        currentRoom = currentRoom.getRoom(currentRoom);
        if (direction.equalsIgnoreCase("south")) {
            if (currentRoom.getSouth() != null) {
                currentRoom = currentRoom.getSouth();
                return true;
            }else return false;
        }
        else if (direction.equalsIgnoreCase("north")) {
            if (currentRoom.getNorth() != null) {
                currentRoom = currentRoom.getNorth();
                return true;
            }else return false;
        }
        else if (direction.equalsIgnoreCase("east")) {
            if (currentRoom.getEast() != null) {
                currentRoom = currentRoom.getEast();
                return true;
            }else return false;
        }
        else if (direction.equalsIgnoreCase("west")) {
            if (currentRoom.getWest() != null) {
                currentRoom = currentRoom.getWest();
                return true;
            }else return false;
        } return false;
    }
    //item and inventory related methods
    public ArrayList<Item> getInventory() {
        if(inventory.isEmpty()){
            return null;
        }else {
            return inventory;
        }
    }
    public ArrayList<Weapon> getEquippedWeapon(){
        if(equippedWeapon.isEmpty()){
            return null;
        }else {
            return equippedWeapon;
        }
    }

    public boolean takeItem(Item item){
        if(currentRoom.getItemList().contains(item)){
            System.out.println("You take the " + item.getName() + ".");
            inventory.add(item);
            currentRoom.removeItem(item);
            return true;
        }
        else return false;
    }

    public Item findItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    public Weapon findWeapon(String weaponName){
        for (Weapon item : equippedWeapon){
            if (item.getName().equalsIgnoreCase(weaponName)){
                return item;
            }
        }
        return null;
    }

    //room related methods
    public String getRoomDescription(){
        return currentRoom.getRoomDescription();
    }

    public void setInitialRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    //item actions
    public boolean dropItem(Item item){
        if(inventory.contains(item)) {
            System.out.println("You drop the " + item.getName() + ".");
            inventory.remove(item);
            if(item instanceof Food){
                currentRoom.addFood(item.getName(), item.getDescription(), item.isEdible(), item.isEquippable(),((Food) item).getHealthPoints());
            } else if(item instanceof MeleeWeapon){
                currentRoom.addMeleeWeapon(item.getName(), item.getDescription(), item.isEdible(), item.isEquippable(), ((Weapon) item).isRanged(), ((Weapon) item).getDamage());
            }else if(item instanceof RangedWeapon){
                currentRoom.addRangedWeapon(item.getName(), item.getDescription(), item.isEdible(), item.isEquippable(), ((Weapon) item).isRanged(), ((Weapon) item).getDamage(), ((RangedWeapon) item).getRemainingAmmo());
            }
            else {
                currentRoom.addItem(item.getName(), item.getDescription(), item.isEdible(), item.isEquippable());
            }
            return true;
        }
        else return false;
    }
    public boolean eat(String foodName){
        for (Item item : inventory){
            if(item instanceof Food) {
                if(foodName.equalsIgnoreCase(item.getName())) {
                    Food selectedFood = (Food) item;
                    System.out.println("You eat the " + selectedFood.getName());
                    hp = hp + selectedFood.healthPoints;
                    if(selectedFood.healthPoints < 0){
                        System.out.println("The " + selectedFood + " is poisonous! You lose " + selectedFood.healthPoints + " health points!");
                    }
                    else {
                        System.out.println("The " + selectedFood + " heals you for " + selectedFood.healthPoints + " health points!");
                    }
                }return true;
            }
        }return false;
    }
    public boolean equip(String weaponName){
        for (Item item : inventory){
            if(item instanceof Weapon){
                if (weaponName.equalsIgnoreCase(item.getName())){
                    Weapon selectedWeapon = (Weapon) item;
                    equippedWeapon.add(selectedWeapon);
                    inventory.remove(selectedWeapon);
                } return true;
            }
        }return false;
    }
    public boolean unequip(String weaponName){
        for (Item item : equippedWeapon){
            if(item instanceof RangedWeapon){
                if (weaponName.equalsIgnoreCase(item.getName())) {
                    RangedWeapon selectedWeapon = (RangedWeapon) item;
                    inventory.add(selectedWeapon);
                    equippedWeapon.remove(selectedWeapon);
                }
            }else if(item instanceof MeleeWeapon){
                if (weaponName.equalsIgnoreCase(item.getName())) {
                    MeleeWeapon selectedWeapon = (MeleeWeapon) item;
                    inventory.add(selectedWeapon);
                    equippedWeapon.remove(selectedWeapon);
                }
            }return true;
        }return false;
    }
    public int attack(int damage){
        return damage;
    }

    public int getHit(int damage){

        return damage;
    }
}



