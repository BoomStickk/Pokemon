
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
    Pokemon(String name,String size,String appearance,int attack,int defence,int lifePoints){
        this.name=name;
        this.size=size;
        this.appearance =appearance;
        this.attack=attack;
        this.defence=defence;
        this.lifePoints=lifePoints;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", look='" + appearance + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", lifePoints=" + lifePoints +
                '}';
    }

}
