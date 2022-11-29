import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Pokemon fire1 = new Pokemon("Charmender", "small", "lizard", 100, 20, 500,"fire");
        Pokemon fire2 = new Pokemon("Ninetails", "medium", "fox", 150, 40, 600,"fire");
        Pokemon fire3 = new Pokemon("Charizard", "big", "dragon", 200, 20, 700,"fire");
        Pokemon water1=new Pokemon("Squirtle","small","turtle",100,20,500,"water");
        Pokemon water2=new Pokemon("Kecleon","medium","chameleon",150,40,600,"water");
        Pokemon electric1=new Pokemon("Pikachu","small","mouse",100,20,500,"electric");
        Pokemon electric2=new Pokemon("Raichu","medium","mouse",150,40,600,"electric");
        Pokemon rock1=new Pokemon("Sandshry","medium","armadillo",150,40,600,"rock");
        Pokemon rock2=new Pokemon("Cubone","small","kangaroo",100,20,500,"rock");
        Pokemon rock3=new Pokemon("Tyranitar","big","dinosaur",200,60,700,"rock");
        ArrayList<Pokemon> pokemonChoice = new ArrayList<>();
        ArrayList<Pokemon> myPokemon = new ArrayList<>();
        ArrayList<Pokemon> enemyPokemon=new ArrayList<>();
        ArrayList<Pokemon> allPokemon=new ArrayList<>();
        pokemonChoice.add(electric1);
        pokemonChoice.add(fire1);
        pokemonChoice.add(water1);
        pokemonChoice.add(rock1);
        pokemonChoice.add(fire2);
        enemyPokemon.add(rock2);
        enemyPokemon.add(water2);
        enemyPokemon.add(electric2);
        enemyPokemon.add(rock3);
        enemyPokemon.add(fire3);
        allPokemon.addAll(pokemonChoice);
        allPokemon.addAll(enemyPokemon);
        Game game1=new Game(myPokemon,enemyPokemon);
        MenuLayout menu = new MenuLayout(pokemonChoice,myPokemon,game1);
        System.out.println();

        menu.printMainMenu();




    }

}