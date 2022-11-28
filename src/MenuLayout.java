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
                    2.GAME MECHANICS
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

                game.fightBattle();


                System.out.println("\n" + "Press enter to continue...");
                promptEnterKey();
            }
            case 2 -> {
                System.out.println("""
                        The Pokemon you're fighting against attacks first. Each Pokemon has their own weakness and strength.\s
                        A Water Pokemon is stronger in a battle against a Fire Pokemon. If a Fire Pokemon attacks a Water Pokemon, the Fire Pokemon's attack will be less damaging.\s
                        A Fire Pokemon does more damage to a Rock Pokemon, and a Rock Pokemon does more damage to an Electric Pokemon. A Water Pokemon is weaker than an Electric Pokemon.\s
                        Furthermore, each Pokemon specializes in attack or defense. If it specializes in attack, it does more damage, and if it specializes in defense, it can take more damage\s
                        from the opponent.
                        Press Enter to go back to the Menu.""");
                promptEnterKey();
            }
            case 3 -> {
                System.out.println("""
                        Trayan a.k.a. the Pokemon master guru pro lvl 38479234 and Presiyana who has never played a game in her life created this masterpiece of a game in 2022 with
                        cold sweat and bloodso that YOU can become the best Pokemon trainer that ever existed. It took them nearly a decade to come up with the plot, the strategy and probably
                        a couple of sleepless nights to write the code.Nevertheless, this game is a masterpiece, and they hope you enjoy it!\s
                        Press Enter to go back to the Menu.""");
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

    public void choosePokemon(ArrayList<Pokemon> pokemonChoice, ArrayList<Pokemon> myPokemon) {
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

    public static void promptEnterKey() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public  void printPokemonInfo(ArrayList<Pokemon> pokemonChoice) {
        for (int i = 0; i < pokemonChoice.size(); i++) {
            System.out.println((i + 1) + " " + pokemonChoice.get(i));
        }
    }

}

