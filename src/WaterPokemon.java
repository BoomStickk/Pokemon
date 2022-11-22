public class WaterPokemon extends Pokemon {
    private final String type="water";

    WaterPokemon(String name,String size,String appearance,int attack,int defence,int lifePoints){
        super(name,size,appearance,attack,defence,lifePoints);


    }

    @Override
    public String toString() {
        return "WaterPokemon{" +
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

    @Override
    public int calculateNormalAttack() {
        return 0;
    }

    @Override
    public int calculateSpecialAttack() {
        return 0;
    }
}

