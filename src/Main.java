import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuLayout menu=new MenuLayout() ;
        FirePokemon fire1=new FirePokemon("Charmender","small","lizard",100,100,500,"fire");
        FirePokemon fire2=new FirePokemon("Ninetails","medium","fox",100,100,500,"fire");
        FirePokemon fire3=new FirePokemon("Charizard","big","dragon",100,100,500,"fire");
        ArrayList<Pokemon> pokemonChoice = new ArrayList<>();

        pokemonChoice.add(fire1);
        pokemonChoice.add(fire2);

        MenuLayout.drawFiles("pokemon_title.txt");
        System.out.println();
        Scanner in = new Scanner(System.in);
        menu.printMainMenu(in);


    }

}