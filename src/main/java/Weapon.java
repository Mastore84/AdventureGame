public class Weapon extends Item{
    private int damage;
    private int remainingAmmo;
    private boolean isRanged;

    public Weapon(String name, String description, boolean isEdible, boolean isEquippable, boolean isRanged, int damage){
        super(name, description, isEdible, isEquippable);
        this.damage = damage;
        this.isRanged = isRanged;
    }

    public int getRemainingAmmo(){
        return remainingAmmo;
    }
    public int getDamage(){
        return damage;
    }

    public boolean isRanged(){
        return isRanged;
    }

}
