public class ElectricPokemon extends Pokemon {
    private final String type="electric";

    ElectricPokemon(String name,String size,String appearance,int attack,int defence,int lifePoints){
        super(name,size,appearance,attack,defence,lifePoints);


    }

    @Override
    public String toString() {
        return "ElectricPokemon{" +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", appearance='" + appearance + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", lifePoints=" + lifePoints +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public int calculateElementalAttack() {
        return 0;
    }
}


