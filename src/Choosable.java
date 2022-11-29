import java.util.ArrayList;

public interface Choosable {
    void printMainMenu();

    void chooseMenuOption(int choice);

    void choosePokemon(ArrayList<Pokemon> pokemonChoice, ArrayList<Pokemon> myPokemon);

    void printPokemonInfo(ArrayList<Pokemon> pokemonChoice);
}
