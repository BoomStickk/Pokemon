import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Game> game;
    ArrayList<Pokemon> myPokemon;
    ArrayList<Pokemon> enemyPokemon;
    int crystalCounter = 0;
    Pokemon myCurrentFighter = null;
    int getMyDamage = 0;

    public int getCrystalCounter() {
        return crystalCounter;
    }

    public void setCrystalCounter(int crystalCounter) {
        this.crystalCounter = crystalCounter;
    }

    Game(ArrayList<Game> game, ArrayList<Pokemon> myPokemon, ArrayList<Pokemon> enemyPokemon) {
        this.game = game;
        this.myPokemon = myPokemon;
        this.enemyPokemon = enemyPokemon;
    }

    public int normalAttack() {

        return getMyCurrentFighter().getAttack() - getEnemyPokemon(enemyPokemon).getDefence();
    }

    public int elementalAttack() {
        if (!checkElementalDependency(enemyPokemon)) {

            return getMyCurrentFighter().getAttack();
        } else return getMyCurrentFighter().getAttack() - 2 * getEnemyPokemon(enemyPokemon).getDefence();
    }


    public void healPokemon() {
        System.out.println("your crystal quantity is "+crystalCounter);
        if ((crystalCounter > 0) && ((myPokemon.get(0).getLifePoints() < 0) ||( myPokemon.get(1).getLifePoints() < 0) ||( myPokemon.get(2).getLifePoints() < 0))) {
            System.out.println("what pokemon do you wish to heal");

            for (int i = 0; i < myPokemon.size(); i++) {
                if (myPokemon.get(i).getLifePoints() <= 0) {
                    System.out.println((i + 1) +" "+ myPokemon.get(i).getName());
                }
            }Scanner in = new Scanner(System.in);
            MenuLayout.checkValidInput(in, "[123]", "Invalid input(1,2,3): ");
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> myPokemon.get(0).setLifePoints(500);
                case 2 -> myPokemon.get(1).setLifePoints(500);
                case 3 -> myPokemon.get(2).setLifePoints(500);
            }
            System.out.println("your pokemon has been healed\npress enter to continue");
            MenuLayout.promptEnterKey();
        }else {
            System.out.println("you can't heal any pokemon\npress enter to continue ");
            MenuLayout.promptEnterKey();
        }
    }

    public void changePokemon() {
        System.out.println("\n" + "Choose your fighter");
        int deathCounter = 0;

        for (int i = 0; i < myPokemon.size(); i++) {
            if (myPokemon.get(i).getLifePoints() > 0) {
                System.out.println((i + 1) + " " + myPokemon.get(i).getName());
                deathCounter++;
            }
        }
        if (deathCounter > 0) {


            chooseMyPokemon(myPokemon);
        } else {
            System.out.println("Game over, you lost ");
        }
    }

    public void checkPokemon() {
        for (Pokemon pokemon : myPokemon) {
            System.out.println(pokemon);
        }
    }

    public void printActionMenu() {
        System.out.println("""
                1.Normal attack
                2.Elemental attack
                3.Change pokemon
                4.Heal pokemon
                5.Pokemon info""");

        chooseAction();
    }

    public void chooseAction() {
        Scanner in = new Scanner(System.in);
        MenuLayout.checkValidInput(in, "[12345]", "Invalid input(1,2,3,4,5): ");
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> normalAttack();
            case 2 -> elementalAttack();
            case 3 -> changePokemon();
            case 4 -> healPokemon();
            case 5 -> checkPokemon();
        }
        checkMyDamage(choice);
    }

    public int getGetMyDamage() {
        return getMyDamage;
    }

    public void setGetMyDamage(int getMyDamage) {
        this.getMyDamage = getMyDamage;
    }

    public void checkMyDamage(int choice) {
        int damage = 0;
        if (choice == 1) {

            damage = normalAttack();

        } else if (choice == 2) {

            damage = elementalAttack();

        }
        setGetMyDamage(damage);
    }

    public void startGame(ArrayList<Pokemon> myPokemon) {
        System.out.println("\n" + "Lets the game begin, your first enemy is... ");

        System.out.println("press enter to continue");

        MenuLayout.promptEnterKey();
        printEnemyPokemon();

        drawCurrentEnemy();
        System.out.println("\n" + "Choose your fighter");
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i + 1) + " " + myPokemon.get(i).getName());
        }
    }


    public Pokemon getEnemyPokemon(ArrayList<Pokemon> enemyPokemon) {
        Pokemon result = null;
//        if (enemyPokemon.get(0).getLifePoints() > 0) {
//            result = enemyPokemon.get(0);
//        } else if (enemyPokemon.get(1).getLifePoints() > 0) {
//            result = enemyPokemon.get(1);
//        }
//        if (enemyPokemon.get(2).getLifePoints() > 0) {
//            result = enemyPokemon.get(2);
//        } else if (enemyPokemon.get(3).getLifePoints() > 0) {
//            result = enemyPokemon.get(3);
//        } else if (enemyPokemon.get(4).getLifePoints() > 0)
//            result = enemyPokemon.get(4);
//        else {
//            System.out.println("game over, you won");
//        }

        if (enemyPokemon.get(0).getLifePoints() > 0 & enemyPokemon.get(1).getLifePoints() > 0 & enemyPokemon.get(2).getLifePoints() > 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            result = enemyPokemon.get(0);
        } else if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() > 0 & enemyPokemon.get(2).getLifePoints() > 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            result = enemyPokemon.get(1);
        } else if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() <= 0 & enemyPokemon.get(2).getLifePoints() > 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            result = enemyPokemon.get(2);
        } else if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() <= 0 & enemyPokemon.get(2).getLifePoints() <= 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            result = enemyPokemon.get(3);
        } else if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() <= 0 & enemyPokemon.get(2).getLifePoints() <= 0 & enemyPokemon.get(3).getLifePoints() <= 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            result = enemyPokemon.get(4);
        } else {
            System.out.println("game over you won ");
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

    public Pokemon getMyCurrentFighter() {
        return myCurrentFighter;
    }

    public void setMyCurrentFighter(Pokemon myCurrentFighter) {
        this.myCurrentFighter = myCurrentFighter;
    }

    public void chooseMyPokemon(ArrayList<Pokemon> myPokemon) {
        Pokemon result = null;
        Scanner in = new Scanner(System.in);
        MenuLayout.checkValidInput(in, "[123]", "Invalid input(1,2,3): ");
        int choice = in.nextInt();


        switch (choice) {
            case 1 -> result = myPokemon.get(0);
            case 2 -> result = myPokemon.get(1);
            case 3 -> result = myPokemon.get(2);
        }
        setMyCurrentFighter(result);

    }

    public Pokemon changeTurn(ArrayList<Pokemon> enemyPokemon) {
        Pokemon turn = getEnemyPokemon(enemyPokemon);
        if (turn.equals(getEnemyPokemon(enemyPokemon))) {
            turn = getMyCurrentFighter();
        } else {
            turn = getEnemyPokemon(enemyPokemon);
        }
        return turn;
    }

    public void fightBattle() {
        while (getMyCurrentFighter().getLifePoints() > 0 && getEnemyPokemon(enemyPokemon).getLifePoints() > 0) {

            if (getEnemyPokemon(enemyPokemon).getLifePoints() > 0) {
                System.out.println(getEnemyPokemon(enemyPokemon).getName() + "'s damage is " + getEnemyDamage());
                getMyCurrentFighter().setLifePoints(getMyCurrentFighter().getLifePoints() - getEnemyDamage());
                if(getMyCurrentFighter().getLifePoints()>0) {
                    System.out.println(getMyCurrentFighter().getName() + "'s life points are " + getMyCurrentFighter().getLifePoints());
                }else {
                    System.out.println(getMyCurrentFighter().getName() + "is knocked out ");
                    changeTurn(enemyPokemon);
                }
            } else {
                System.out.println("you win");break;
            }


            if (myCurrentFighter.getLifePoints() > 0) {
                printActionMenu();
                System.out.println(getMyCurrentFighter().getName() + "'s damage is " + getGetMyDamage());
                getEnemyPokemon(enemyPokemon).setLifePoints(getEnemyPokemon(enemyPokemon).getLifePoints() - getGetMyDamage());
                System.out.println(getEnemyPokemon(enemyPokemon).getName() + "'s health is " + getEnemyPokemon(enemyPokemon).getLifePoints());
                System.out.println();
                changeTurn(enemyPokemon);
            } else {
                changePokemon();
            }
        }
    }

    private void drawCurrentEnemy() {
        int deathCounter = 0;

        for (Pokemon pokemon : enemyPokemon) {
            if (pokemon.getLifePoints() <= 0) {
                deathCounter++;
            }
        }
        switch (deathCounter) {

            case 1 -> {
                System.out.println("second battle");
                printEnemyPokemon();
                setCrystalCounter(getCrystalCounter()+1);

            }
            case 2 -> {
                System.out.println("third battle");
                printEnemyPokemon();
                setCrystalCounter(getCrystalCounter()+1);

            }
            case 3 -> {
                System.out.println("forth battle");
                printEnemyPokemon();
                setCrystalCounter(getCrystalCounter()+1);

            }
            case 4 -> {
                System.out.println("final battle");
                printEnemyPokemon();
                setCrystalCounter(getCrystalCounter()+1);

            }
        }
    }

    public int getEnemyDamage() {
        if (checkElementalDependency(enemyPokemon)) {
            return getEnemyPokemon(enemyPokemon).getAttack();
        } else {
            return getEnemyPokemon(enemyPokemon).getAttack() - getMyCurrentFighter().getDefence();
        }
    }

    public boolean checkElementalDependency(ArrayList<Pokemon> enemyPokemon) {
        boolean result = false;
        if (changeTurn(enemyPokemon).equals(getMyCurrentFighter()) & (getMyCurrentFighter().getType().equals("electric")) & getEnemyPokemon(enemyPokemon).getType().equals("water")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon).equals(getMyCurrentFighter()) & (getMyCurrentFighter().getType().equals("water")) & getEnemyPokemon(enemyPokemon).getType().equals("fire")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon).equals(getMyCurrentFighter()) & (getMyCurrentFighter().getType().equals("fire")) & getEnemyPokemon(enemyPokemon).getType().equals("rock")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon).equals(getMyCurrentFighter()) & (getMyCurrentFighter().getType().equals("rock")) & getEnemyPokemon(enemyPokemon).getType().equals("electric")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon).equals(getEnemyPokemon(enemyPokemon)) & (getEnemyPokemon(enemyPokemon).getType().equals("electric")) & getMyCurrentFighter().getType().equals("water")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon).equals(getEnemyPokemon(enemyPokemon)) & (getEnemyPokemon(enemyPokemon).getType().equals("water")) & getMyCurrentFighter().getType().equals("fire")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon).equals(getEnemyPokemon(enemyPokemon)) & (getEnemyPokemon(enemyPokemon).getType().equals("fire")) & getMyCurrentFighter().getType().equals("rock")) {
            result = true;
        } else if
        (changeTurn(enemyPokemon).equals(getEnemyPokemon(enemyPokemon)) & (getEnemyPokemon(enemyPokemon).getType().equals("rock")) & getMyCurrentFighter().getType().equals("electric")) {
            result = true;
        }
        return !result;
    }
}


