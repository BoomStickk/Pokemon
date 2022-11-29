
public  class Pokemon {
    protected String name;

    private String size;
    private final String appearance;
    private int attack;
    private int defence;
    private int lifePoints;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;
    Pokemon(){
        this.name="Pikachu";
        this.size="small";
        this.appearance ="mouse";
        this.attack=100;
        this.defence=100;
        this.lifePoints=100;
        this.type="electric";
    }

    public String getName() {
        return name;
    }

    Pokemon(String name, String size, String appearance, int attack, int defence, int lifePoints,String type){
        this.name=name;
        this.size=size;
        this.appearance =appearance;
        this.attack=attack;
        this.defence=defence;
        this.lifePoints=lifePoints;
        this.type=type;
    }

    @Override
    public String toString() {
        return
                "name=" + name + '\'' +
                ", size='" + size + '\'' +
                ", appearance='" + appearance + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", lifePoints=" + lifePoints+
                        ", type=" + type

                ;
    }
    public void calculateElementalAttack(){

    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void calculateNormalAttack(){

    }
    public void calculateSpecialAttack(){

    }

}
