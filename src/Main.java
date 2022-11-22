import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FirePokemon fire1 = new FirePokemon("Charmender", "small", "lizard", 100, 100, 500);
        FirePokemon fire2 = new FirePokemon("Ninetails", "medium", "fox", 100, 100, 500);
        FirePokemon fire3 = new FirePokemon("Charizard", "big", "dragon", 100, 100, 500);
        WaterPokemon water1=new WaterPokemon("Squirtle","small","turtle",100,100,500);
        WaterPokemon water2=new WaterPokemon("Kecleon","medium","chameleon",100,100,500);
        ElectricPokemon electric1=new ElectricPokemon("Pikachu","small","mouse",100,100,500);
        ElectricPokemon electric2=new ElectricPokemon("Raichu","medium","mouse",100,100,500);
        RockPokemon rock1=new RockPokemon("Sandshry","medium","armadillo",100,100,500);
        RockPokemon rock2=new RockPokemon("Cubone","small","kangaroo",100,100,500);
        RockPokemon rock3=new RockPokemon("Tyranitar","big","dinosaur",100,100,500);
        ArrayList<Pokemon> pokemonChoice = new ArrayList<>();
        ArrayList<Pokemon> myPokemon = new ArrayList<>();
        ArrayList<Pokemon> enemyPokemon=new ArrayList<>();
        ArrayList<Actions>actions=new ArrayList<>();
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
        Actions action=new Actions(actions);
        MenuLayout menu = new MenuLayout(pokemonChoice,myPokemon);
        System.out.println();
        Scanner in = new Scanner(System.in);
        menu.printMainMenu(in);

//        for (Pokemon pokemon : myPokemon) {                    //test
//            System.out.println(pokemon);
//        }

    }

}