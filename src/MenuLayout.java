import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLayout {
    ArrayList<Pokemon> pokemonChoice;
    ArrayList<Pokemon> myPokemon;

    public MenuLayout(ArrayList<Pokemon> pokemonChoice, ArrayList<Pokemon> myPokemon) {
        this.pokemonChoice = pokemonChoice;
        this.myPokemon = myPokemon;
    }

    public static void drawFiles(String pathname) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(pathname));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        if (sc != null) {
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
        }
    }

    public void printMainMenu(Scanner in) {

        System.out.println("""
                1.NEW GAME
                2.INFO
                3.ABOUT
                4.EXIT""");
        checkValidInput(in, "[1234]", "Invalid input(1,2,3,4): ");
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> choosePokemon(pokemonChoice, in, myPokemon);
            case 2 -> MenuLayout.drawFiles("info.txt");
            case 3 -> MenuLayout.drawFiles("about.txt");
            case 4 -> MenuLayout.drawFiles("thanks.txt");

        }
    }

    private static void checkValidInput(Scanner sc, String pattern, String s) {
        while (!sc.hasNext(pattern)) {
            System.out.print(s);
            sc.next();
        }
    }

    public static void choosePokemon(ArrayList<Pokemon> pokemonChoice, Scanner in, ArrayList<Pokemon> myPokemon) {
        System.out.println("Choose 3 pokemon: ");
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        while (myPokemon.size() < 3) {
            System.out.println("pokemon No" + (myPokemon.size() + 1));
            checkValidInput(in, "[12345]", "Invalid input(1,2,3,4,5): ");
            int choice = in.nextInt();
            switch (choice) {

                case 1 -> {
                    if (checkIfChose(a)) continue;
                    myPokemon.add(pokemonChoice.get(0));
                    a = 1;
                }
                case 2 -> {
                    if (checkIfChose(b)) continue;
                    myPokemon.add(pokemonChoice.get(1));
                    b = 1;
                }
                case 3 -> {
                    if (checkIfChose(c)) continue;
                    myPokemon.add(pokemonChoice.get(2));
                    c = 1;
                }
                case 4 -> {
                    if (checkIfChose(d)) continue;
                    myPokemon.add(pokemonChoice.get(3));
                    d = 1;
                }
                case 5 -> {
                    if (checkIfChose(e)) continue;
                    myPokemon.add(pokemonChoice.get(4));
                    e = 1;
                }
            }
        }
    }

    private static boolean checkIfChose(int a) {
        if (a > 0) {
            System.out.println("You have already chosen that pokemon(try another)");
            return true;
        }
        return false;
    }


}

