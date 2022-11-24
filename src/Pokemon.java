
public abstract class Pokemon {
    protected String name;

    protected String size;
    protected String appearance;
    protected int attack;
    protected int defence;
    protected int lifePoints;
    Pokemon(){
        this.name="Pikachu";
        this.size="small";
        this.appearance ="mouse";
        this.attack=100;
        this.defence=100;
        this.lifePoints=100;
    }

    public String getName() {
        return name;
    }

    Pokemon(String name, String size, String appearance, int attack, int defence, int lifePoints){
        this.name=name;
        this.size=size;
        this.appearance =appearance;
        this.attack=attack;
        this.defence=defence;
        this.lifePoints=lifePoints;
    }

    @Override
    public String toString() {
        return
                "name=" + name + '\'' +
                ", size='" + size + '\'' +
                ", appearance='" + appearance + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", lifePoints=" + lifePoints
                ;
    }
    public abstract int calculateElementalAttack();
    public abstract int calculateNormalAttack();
    public abstract int calculateSpecialAttack();

}
