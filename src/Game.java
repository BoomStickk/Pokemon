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

    public int normalAttack(int choice) {

        return getMyPokemon(myPokemon, choice).getAttack() - getEnemyPokemon(enemyPokemon).getDefence();
    }

    public int elementalAttack(int choice) {
        if (checkElementalDependency(myPokemon, enemyPokemon, choice)) {

            return getMyPokemon(myPokemon, choice).getAttack();
        } else return getMyPokemon(myPokemon, choice).getAttack() - 2 * getEnemyPokemon(enemyPokemon).getDefence();
    }


    public void healPokemon() {
    }

    public void changePokemon() {
        System.out.println("change pokemon");
        System.out.println("\n" + "Choose your fighter");
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i + 1) + " " + myPokemon.get(i).getName());
        }
        Scanner in=new Scanner(System.in);
        int choice=in.nextInt();
        chooseMyPokemon(myPokemon, choice);
    }

    public void checkPokemon() {
        for (Pokemon pokemon : myPokemon) {
            System.out.println(pokemon);
        }
    }

    public void printActionMenu() {
        int choice;
        System.out.println("""
                1.Normal attack
                2.Elemental attack
                3.Change pokemon
                4.Heal pokemon
                5.Pokemon info""");
        Scanner in = new Scanner(System.in);
        MenuLayout.checkValidInput(in, "[12345]", "Invalid input(1,2,3,4,5): ");
        choice = in.nextInt();
        chooseAction(choice);
    }

    public void chooseAction(int choice) {
        switch (choice) {
            case 1 -> normalAttack(choice);
            case 2 -> elementalAttack(choice);
            case 3 -> changePokemon();
            case 4 -> healPokemon();
            case 5 -> checkPokemon();
        }getMyDamage(choice);
    }
    public int getMyDamage(int choice){
        int damage=0;
        if (choice==1){

            damage= normalAttack(choice);

        }else if(choice==2){

            damage= elementalAttack(choice);

        }return damage;
    }

    public void startGame(ArrayList<Pokemon> myPokemon) {
        System.out.println("\n" + "Lets the game begin");
        printEnemyPokemon();

        System.out.println("\n" + "Choose your fighter");
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i + 1) + " " + myPokemon.get(i).getName());
        }
    }


    public Pokemon getEnemyPokemon(ArrayList<Pokemon> enemyPokemon) {
        Pokemon result = null;
        if (enemyPokemon.get(0).getLifePoints() > 0 & enemyPokemon.get(1).getLifePoints() > 0 & enemyPokemon.get(2).getLifePoints() > 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            result = enemyPokemon.get(0);
        }
        if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() > 0 & enemyPokemon.get(2).getLifePoints() > 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            result = enemyPokemon.get(1);
        }
        if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() <= 0 & enemyPokemon.get(2).getLifePoints() > 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            result = enemyPokemon.get(2);
        }
        if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() <= 0 & enemyPokemon.get(2).getLifePoints() <= 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            result = enemyPokemon.get(3);
        }
        if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() <= 0 & enemyPokemon.get(2).getLifePoints() <= 0 & enemyPokemon.get(3).getLifePoints() <= 0 & enemyPokemon.get(4).getLifePoints() > 0) {
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

    public Pokemon chooseMyPokemon(ArrayList<Pokemon> myPokemon, int choice) {
        Pokemon result = null;

        switch (choice) {
            case 1 -> result = myPokemon.get(0);
            case 2 -> result = myPokemon.get(1);
            case 3 -> result = myPokemon.get(2);
        }
        return result;
    }

    public Pokemon getMyPokemon(ArrayList<Pokemon> myPokemon, int choice) {
        return chooseMyPokemon(myPokemon, choice);
    }

    public Pokemon changeTurn(ArrayList<Pokemon> enemyPokemon, ArrayList<Pokemon> myPokemon, int choice) {
        Pokemon turn = getEnemyPokemon(enemyPokemon);
        if (turn.equals(getEnemyPokemon(enemyPokemon))) {
            turn = getMyPokemon(myPokemon, choice);
        } else {
            turn = getEnemyPokemon(enemyPokemon);
        }
        return turn;
    }

    public void fightBattle(int choice) {
        while (((myPokemon.get(0).getLifePoints() > 0) || (myPokemon.get(1).getLifePoints() > 0) || (myPokemon.get(2).getLifePoints() > 0)) && ((enemyPokemon.get(0).getLifePoints() > 0) || (enemyPokemon.get(1).getLifePoints() > 0) || (enemyPokemon.get(2).getLifePoints() > 0) || (enemyPokemon.get(3).getLifePoints() > 0) || (enemyPokemon.get(4).getLifePoints() > 0))) {
            System.out.println("The enemy damage is " + getEnemyDamage(choice));
            getMyPokemon(myPokemon,choice).setLifePoints(getMyPokemon(myPokemon,choice).getLifePoints()-getEnemyDamage(choice));
            System.out.println(getMyPokemon(myPokemon,choice).getName()+"'s life points are "+getMyPokemon(myPokemon,choice).getLifePoints());
            System.out.println();

            printActionMenu();
            System.out.println("my damage is "+getMyDamage(choice));
            getEnemyPokemon(enemyPokemon).setLifePoints(getEnemyPokemon(enemyPokemon).getLifePoints()-getMyDamage(choice));
            System.out.println(getEnemyPokemon(enemyPokemon).getName()+"'s health is "+getEnemyPokemon(enemyPokemon).getLifePoints());
            System.out.println();
        }
    }

    public int getEnemyDamage(int choice) {
        if (checkElementalDependency(myPokemon, enemyPokemon, choice)) {
            return getEnemyPokemon(enemyPokemon).getAttack();
        } else {
            return getEnemyPokemon(enemyPokemon).getAttack() - getMyPokemon(myPokemon, choice).getDefence();
        }
    }

    public boolean checkElementalDependency(ArrayList<Pokemon> myPokemon, ArrayList<Pokemon> enemyPokemon, int choice) {
        boolean result = false;
        if (changeTurn(enemyPokemon, myPokemon, choice).equals(getMyPokemon(myPokemon, choice)) & (getMyPokemon(myPokemon, choice).getType().equals("electric")) & getEnemyPokemon(enemyPokemon).getType().equals("water")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon, myPokemon, choice).equals(getMyPokemon(myPokemon, choice)) & (getMyPokemon(myPokemon, choice).getType().equals("water")) & getEnemyPokemon(enemyPokemon).getType().equals("fire")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon, myPokemon, choice).equals(getMyPokemon(myPokemon, choice)) & (getMyPokemon(myPokemon, choice).getType().equals("fire")) & getEnemyPokemon(enemyPokemon).getType().equals("rock")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon, myPokemon, choice).equals(getMyPokemon(myPokemon, choice)) & (getMyPokemon(myPokemon, choice).getType().equals("rock")) & getEnemyPokemon(enemyPokemon).getType().equals("electric")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon, myPokemon, choice).equals(getEnemyPokemon(enemyPokemon)) & (getEnemyPokemon(enemyPokemon).getType().equals("electric")) & getMyPokemon(myPokemon, choice).getType().equals("water")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon, myPokemon, choice).equals(getEnemyPokemon(enemyPokemon)) & (getEnemyPokemon(enemyPokemon).getType().equals("water")) & getMyPokemon(myPokemon, choice).getType().equals("fire")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon, myPokemon, choice).equals(getEnemyPokemon(enemyPokemon)) & (getEnemyPokemon(enemyPokemon).getType().equals("fire")) & getMyPokemon(myPokemon, choice).getType().equals("rock")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon, myPokemon, choice).equals(getEnemyPokemon(enemyPokemon)) & (getEnemyPokemon(enemyPokemon).getType().equals("rock")) & getMyPokemon(myPokemon, choice).getType().equals("electric")) {
            result = true;
        }
        return result;
    }
}


