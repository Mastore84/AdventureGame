public class Weapon extends Item{

    private boolean isRanged;
    private int damage;
    private int remainingAmmo;

    public Weapon(String name, String description, boolean isEdible, boolean isRanged, int damage, int remainingAmmo){
        super(name, description, isEdible);
        this.isRanged = isRanged;
        this.damage = damage;
        this.remainingAmmo = remainingAmmo;
    }

    public int remainingUses(){
        return remainingAmmo;
    }

}
