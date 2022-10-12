public abstract class Weapon extends Item{
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
    public void removeRemainingAmmo(){
        remainingAmmo = remainingAmmo - 1;
    }
    public int getDamage(){
        return damage;
    }
    //public abstract AttackEnum attack();


    public boolean isRanged(){
        return isRanged;
    }

}
