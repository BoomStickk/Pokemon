public class FirePokemon extends Pokemon{
    String type;
    FirePokemon(){
        super();
        this.type ="Fire";
    }
    FirePokemon(String name,String size,String appearance,int attack,int defence,int lifePoints,String type){
        super(name,size,appearance,attack,defence,lifePoints);
        this.type=type;

    }

    @Override
    public String toString() {
        return "FirePokemon{" +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", look='" + appearance + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", lifePoints=" + lifePoints +
                "type='" + type + '\'' +
                '}';
    }
}
