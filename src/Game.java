import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Game> game;
    ArrayList<Pokemon> myPokemon;
    ArrayList<Pokemon> enemyPokemon;

    Game(ArrayList<Game> game, ArrayList<Pokemon> myPokemon, ArrayList<Pokemon> enemyPokemon) {
        this.game = game;
        this.myPokemon = myPokemon;
        this.enemyPokemon = enemyPokemon;
    }

    public void normalAttack() {

    }

    public void elementalAttack() {
    }

    public void specialAttack() {
    }

    public void healPokemon() {
    }

    public void changePokemon() {
    }

    public void checkPokemon() {
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println(myPokemon.get(i));
        }
    }

    public void printActionMenu(Scanner in) {
        int choice;
        System.out.println("""
                1.Normal attack
                2.Elemental attack
                3.Special attack
                4.Change pokemon
                5.Heal pokemon
                6.Pokemon info""");

        MenuLayout.checkValidInput(in, "[123456]", "Invalid input(1,2,3,4,5,6): ");
        choice = in.nextInt();
        chooseAction(choice);
    }

    public void chooseAction(int choice) {
        switch (choice) {
            case 1 -> normalAttack();
            case 2 -> elementalAttack();
            case 3 -> specialAttack();
            case 4 -> changePokemon();
            case 5 -> healPokemon();
            case 6 -> checkPokemon();
        }
    }

    public void startGame(ArrayList<Pokemon> myPokemon) {
        System.out.println("\n" + "Lets the game begin");
        printEnemyPokemon();

        System.out.println("\n" + "Choose your fighter");
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i + 1) + " " + myPokemon.get(i).getName());
        }
        chooseFighter(myPokemon);

    }

    public Pokemon getEnemyPokemon(ArrayList<Pokemon> enemyPokemon) {
        Pokemon result = null;
        if (enemyPokemon.get(0).lifePoints > 0 & enemyPokemon.get(1).lifePoints > 0 & enemyPokemon.get(2).lifePoints > 0 & enemyPokemon.get(3).lifePoints > 0 & enemyPokemon.get(4).lifePoints > 0) {
            result = enemyPokemon.get(0);
        }
        if (enemyPokemon.get(0).lifePoints <= 0 & enemyPokemon.get(1).lifePoints > 0 & enemyPokemon.get(2).lifePoints > 0 & enemyPokemon.get(3).lifePoints > 0 & enemyPokemon.get(4).lifePoints > 0) {
            result = enemyPokemon.get(1);
        }
        if (enemyPokemon.get(0).lifePoints <= 0 & enemyPokemon.get(1).lifePoints <= 0 & enemyPokemon.get(2).lifePoints > 0 & enemyPokemon.get(3).lifePoints > 0 & enemyPokemon.get(4).lifePoints > 0) {
            result = enemyPokemon.get(2);
        }
        if (enemyPokemon.get(0).lifePoints <= 0 & enemyPokemon.get(1).lifePoints <= 0 & enemyPokemon.get(2).lifePoints <= 0 & enemyPokemon.get(3).lifePoints > 0 & enemyPokemon.get(4).lifePoints > 0) {
            result = enemyPokemon.get(3);
        }
        if (enemyPokemon.get(0).lifePoints <= 0 & enemyPokemon.get(1).lifePoints <= 0 & enemyPokemon.get(2).lifePoints <= 0 & enemyPokemon.get(3).lifePoints <= 0 & enemyPokemon.get(4).lifePoints > 0) {
            result = enemyPokemon.get(4);
        }
        return result;

    }

    public void printEnemyPokemon() {
        if (getEnemyPokemon(enemyPokemon) == enemyPokemon.get(0)) {
            MenuLayout.drawFiles("cubone.txt");
            System.out.println(enemyPokemon.get(0));
        }
        if (getEnemyPokemon(enemyPokemon) == enemyPokemon.get(1)) {
            MenuLayout.drawFiles("kecleon.txt");
            System.out.println(enemyPokemon.get(4));
        }
        if (getEnemyPokemon(enemyPokemon) == enemyPokemon.get(2)) {
            MenuLayout.drawFiles("raichu.txt");
            System.out.println(enemyPokemon.get(2));
        }
        if (getEnemyPokemon(enemyPokemon) == enemyPokemon.get(3)) {
            MenuLayout.drawFiles("tyranitar.txt");
            System.out.println(enemyPokemon.get(3));
        }
        if (getEnemyPokemon(enemyPokemon) == enemyPokemon.get(4)) {
            MenuLayout.drawFiles("charizard.txt");
            System.out.println(enemyPokemon.get(4));
        }
    }

    public Pokemon chooseFighter(ArrayList<Pokemon> myPokemon) {
        Pokemon result = null;
        Scanner in = new Scanner(System.in);
        int fighterChoice = in.nextInt();
        switch (fighterChoice) {
            case 1 -> result=myPokemon.get(0);
            case 2 -> result=myPokemon.get(1);
            case 3 -> result=myPokemon.get(2);

        }return result;

    }
    public Pokemon changeTurn(ArrayList<Pokemon>enemyPokemon,ArrayList<Pokemon>myPokemon){
        Pokemon result = getEnemyPokemon(enemyPokemon);
        while ((getEnemyPokemon(enemyPokemon).lifePoints>0)&(chooseFighter(myPokemon).lifePoints>0)) {
            if(result.equals(getEnemyPokemon(enemyPokemon))) {
                result = chooseFighter(myPokemon);
            }else {
                result=getEnemyPokemon(enemyPokemon);
            }
        }
            return result;

    }
}
