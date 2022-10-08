public class Weapon extends Item{
    private int damage;
    private int remainingAmmo;

    public Weapon(String name, String description, boolean isEdible, boolean isEquippable, int damage){
        super(name, description, isEdible, isEquippable);
        this.damage = damage;
    }

    public int getRemainingAmmo(){
        return remainingAmmo;
    }
    public int getDamage(){
        return damage;
    }

}
