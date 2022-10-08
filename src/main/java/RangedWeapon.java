public class RangedWeapon extends Weapon{

    private int remainingAmmo;
    public RangedWeapon(String name, String description, boolean isEdible, boolean isEquippable, int damage, int remainingAmmo){
        super(name, description, isEdible, isEquippable, damage);
        this.remainingAmmo = remainingAmmo;
    }

    public int getRemainingAmmo(){
        return remainingAmmo;
    }

}
