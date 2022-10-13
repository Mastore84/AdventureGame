public class RangedWeapon extends Weapon{

    private int remainingAmmo;
    public RangedWeapon(String name, String description, boolean isEdible, boolean isEquippable, boolean isRanged, int damage, int remainingAmmo){
        super(name, description, isEdible, isEquippable, isRanged, damage);
        this.remainingAmmo = remainingAmmo;
    }

    public int getRemainingAmmo(){
        return remainingAmmo;
    }

    public void removeRemainingAmmo(){
        remainingAmmo = remainingAmmo - 1;
    }

}
