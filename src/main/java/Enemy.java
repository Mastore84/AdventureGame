public class Enemy {

    private String name;
    private String description;
    private int healthPoints;
    private Weapon weapon;

    public Enemy(String name, String description, int healthPoints, Weapon weapon){
        this.name = name;
        this.description = description;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getHealthPoints(){
        return healthPoints;
    }
    public Weapon getWeapon(){
        return weapon;
    }

    public int attack(int damage){
        return damage;
    }
    public int getHit(int damage){
        return damage;
    }
}
