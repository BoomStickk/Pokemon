import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuLayout {
    ArrayList<Pokemon> pokemonChoice;
    ArrayList<Pokemon> myPokemon;
    Game game;


    public MenuLayout(ArrayList<Pokemon> pokemonChoice, ArrayList<Pokemon> myPokemon, Game game) {
        this.pokemonChoice = pokemonChoice;
        this.myPokemon = myPokemon;
        this.game = game;
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

    public void printMainMenu() {

        int choice;
        do {
            drawFiles("pokemon_title.txt");
            System.out.println("""
                    1.NEW GAME
                    2.INFO
                    3.ABOUT
                    4.EXIT""");
            Scanner in = new Scanner(System.in);
            checkValidInput(in, "[1234]", "Invalid input(1,2,3,4): ");
            choice = in.nextInt();
            chooseMenuOption(choice);
        } while (choice != 4);
    }

    public void chooseMenuOption( int choice) {

        switch (choice) {
            case 1 -> {
                drawFiles("ash.txt");
                promptEnterKey();
                choosePokemon(pokemonChoice,  myPokemon);
                game.startGame(myPokemon);
                game.chooseMyPokemon(myPokemon);
                game.fightBattle(choice);
                System.out.println("\n" + "Press enter to continue...");
                promptEnterKey();
            }
            case 2 -> {
                drawFiles("info.txt");
                promptEnterKey();
            }
            case 3 -> {
                drawFiles("about.txt");
                promptEnterKey();
            }
            case 4 -> drawFiles("thanks.txt");
        }
    }

    public static void checkValidInput(Scanner sc, String pattern, String s) {
        while (!sc.hasNext(pattern)) {
            System.out.print(s);
            sc.next();
        }
    }

    public static void choosePokemon(ArrayList<Pokemon> pokemonChoice, ArrayList<Pokemon> myPokemon) {
        drawFiles("choice.txt");
        System.out.println("                       1.Pikachu                                       2.Charmender                                                           3.Squirtle                                            4.Ninetales                                                    5.Sandshry");
        printPokemonInfo(pokemonChoice);
        Scanner in=new Scanner(System.in);
        System.out.println("\n" + "Choose 3 pokemon: ");
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

    public void promptEnterKey() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void printPokemonInfo(ArrayList<Pokemon> pokemonChoice) {
        for (int i = 0; i < pokemonChoice.size(); i++) {
            System.out.println((i + 1) + " " + pokemonChoice.get(i));
        }
    }
}

