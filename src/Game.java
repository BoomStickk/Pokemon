import java.util.ArrayList;
import java.util.Scanner;

public class Game implements Actionable {
    private final ArrayList<Pokemon> myPokemon;
    private final ArrayList<Pokemon> enemyPokemon;
    private int crystalCounter = 0;
    private Pokemon myCurrentFighter = null;
    private Pokemon opponentCurrentFighter = null;
    private int getMyDamage = 0;

    public int getCrystalCounter() {
        return crystalCounter;
    }

    public void setCrystalCounter(int crystalCounter) {
        this.crystalCounter = crystalCounter;
    }

    Game(ArrayList<Pokemon> myPokemon, ArrayList<Pokemon> enemyPokemon) {
        this.myPokemon = myPokemon;
        this.enemyPokemon = enemyPokemon;
    }

    public int normalAttack() {

        return getMyCurrentFighter().getAttack() - getOpponentCurrentFighter().getDefence();
    }

    public int elementalAttack() {
        if (!checkElementalDependency()) {

            return getMyCurrentFighter().getAttack();
        } else return getMyCurrentFighter().getAttack() - 2 * getOpponentCurrentFighter().getDefence();
    }


    public void healPokemon() {
        System.out.println("your crystal quantity is " + crystalCounter);
        if ((crystalCounter > 0) && ((myPokemon.get(0).getLifePoints() < 0) || (myPokemon.get(1).getLifePoints() < 0) || (myPokemon.get(2).getLifePoints() < 0))) {
            System.out.println("what pokemon do you wish to heal");

            for (int i = 0; i < myPokemon.size(); i++) {
                if (myPokemon.get(i).getLifePoints() <= 0) {
                    System.out.println((i + 1) + " " + myPokemon.get(i).getName());
                }
            }
            Scanner in = new Scanner(System.in);
            MenuLayout.checkValidInput(in, "[123]", "Invalid input(1,2,3): ");
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> myPokemon.get(0).setLifePoints(500);
                case 2 -> myPokemon.get(1).setLifePoints(500);
                case 3 -> myPokemon.get(2).setLifePoints(500);
            }
            setCrystalCounter(getCrystalCounter() - 1);
            System.out.println("your pokemon has been healed, you used up 1 crystal, now you have" + getCrystalCounter() + "\npress enter to continue");
            MenuLayout.promptEnterKey();
        } else {
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

    public void printActionMenu() {
        System.out.println("""
                1.Normal attack
                2.Elemental attack
                3.Change pokemon
                4.Heal pokemon""");

        chooseAction();
    }

    public void chooseAction() {
        Scanner in = new Scanner(System.in);
        MenuLayout.checkValidInput(in, "[1234]", "Invalid input(1,2,3,4): ");
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> normalAttack();
            case 2 -> elementalAttack();
            case 3 -> changePokemon();
            case 4 -> healPokemon();
        }
        checkMyAction(choice);
    }

    public int getGetMyDamage() {
        return getMyDamage;
    }

    public void setGetMyDamage(int getMyDamage) {
        this.getMyDamage = getMyDamage;
    }

    public void checkMyAction(int choice) {
        if (choice == 1) {

            setGetMyDamage(normalAttack());

        } else if (choice == 2) {

            setGetMyDamage(elementalAttack());

        } else if (choice == 3 || choice == 4) {
            fightBattle();
        } else {
            actMyTurn();
        }

    }

    public void startGame(ArrayList<Pokemon> myPokemon) {
        System.out.println("\n" + "Lets the game begin, your first enemy is... ");
        setOpponentCurrentFighter(enemyPokemon.get(0));
        System.out.println("press enter to continue");
        MenuLayout.promptEnterKey();
        printEnemyPokemon();
        System.out.println("\n" + "Choose your fighter");
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i + 1) + " " + myPokemon.get(i).getName());
        }
    }


    public Pokemon getEnemyPokemon(ArrayList<Pokemon> enemyPokemon) {

//

        if (enemyPokemon.get(0).getLifePoints() > 0 & enemyPokemon.get(1).getLifePoints() > 0 & enemyPokemon.get(2).getLifePoints() > 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            setOpponentCurrentFighter(enemyPokemon.get(0));
        } else if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() > 0 & enemyPokemon.get(2).getLifePoints() > 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            setOpponentCurrentFighter(enemyPokemon.get(1));
        } else if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() <= 0 & enemyPokemon.get(2).getLifePoints() > 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            setOpponentCurrentFighter(enemyPokemon.get(2));
        } else if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() <= 0 & enemyPokemon.get(2).getLifePoints() <= 0 & enemyPokemon.get(3).getLifePoints() > 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            setOpponentCurrentFighter(enemyPokemon.get(3));
        } else if (enemyPokemon.get(0).getLifePoints() <= 0 & enemyPokemon.get(1).getLifePoints() <= 0 & enemyPokemon.get(2).getLifePoints() <= 0 & enemyPokemon.get(3).getLifePoints() <= 0 & enemyPokemon.get(4).getLifePoints() > 0) {
            setOpponentCurrentFighter(enemyPokemon.get(4));
        }
        return getOpponentCurrentFighter();

    }

    public void printEnemyPokemon() {
        if (getOpponentCurrentFighter() == enemyPokemon.get(0)) {
            System.out.println(enemyPokemon.get(0) + "\n");
        }
        if (getOpponentCurrentFighter() == enemyPokemon.get(1)) {

            System.out.println("Get ready for the second battle");
            System.out.println(enemyPokemon.get(1) + "\n");
        }
        if (getOpponentCurrentFighter() == enemyPokemon.get(2)) {
            System.out.println("The third won't be as easy");
            System.out.println(enemyPokemon.get(2) + "\n");
        }
        if (getOpponentCurrentFighter() == enemyPokemon.get(3)) {
            System.out.println("You are doing pretty good, onto the forth");
            System.out.println(enemyPokemon.get(3) + "\n");
        }
        if (getOpponentCurrentFighter() == enemyPokemon.get(4)) {
            System.out.println("You have no chance, you will be done in this final battle");
            System.out.println(enemyPokemon.get(4) + "\n");
        }
    }

    public Pokemon getOpponentCurrentFighter() {
        return opponentCurrentFighter;
    }

    public void setOpponentCurrentFighter(Pokemon opponentCurrentFighter) {
        this.opponentCurrentFighter = opponentCurrentFighter;
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
        System.out.println("Press enter to continue");
        MenuLayout.promptEnterKey();
        drawVersusScreen();


    }

    public Pokemon changeTurn() {
        Pokemon turn = getOpponentCurrentFighter();
        if (turn.equals(getOpponentCurrentFighter())) {
            turn = getMyCurrentFighter();
        } else {
            turn = getOpponentCurrentFighter();
        }
        return turn;
    }

    public void fightBattle() {
        while (true) {


            if (actOpponentTurn()) break;


            if (actMyTurn()) break;
        }
    }

    private boolean actMyTurn() {
        if (myCurrentFighter.getLifePoints() > 0) {
            printActionMenu();
            System.out.println("The damage dealt by " + getMyCurrentFighter().getName() + " is " + getGetMyDamage());
            getOpponentCurrentFighter().setLifePoints(getOpponentCurrentFighter().getLifePoints() - getGetMyDamage());
            if (getOpponentCurrentFighter().getLifePoints() > 0) {

                System.out.println(getOpponentCurrentFighter().getName() + "'s life points are now down to " + getOpponentCurrentFighter().getLifePoints() + "\n");
            } else {
                System.out.println(getOpponentCurrentFighter().getName() + " is knocked out \nYou win 1 crystal");
                changeTurn();
                setCrystalCounter(getCrystalCounter() + 1);
                System.out.println("you currently have " + crystalCounter + "\n");
                setOpponentCurrentFighter(getEnemyPokemon(enemyPokemon));
                evolve();
                changeEvolutionStats();

                System.out.println("Press enter to continue");
                MenuLayout.promptEnterKey();
                drawVersusScreen();
                printEnemyPokemon();
            }

        } else {
            int deathCounter = 0;
            for (Pokemon pokemon : myPokemon) {
                if (pokemon.getLifePoints() <= 0) {
                    deathCounter++;
                }
            }
            if (deathCounter < 3) {
                changePokemon();
            } else {
                System.out.println("Game over,you loose");
                return true;
            }
        }
        return false;
    }

    private boolean actOpponentTurn() {
        if (getOpponentCurrentFighter().getLifePoints() > 0) {
            System.out.println("The damage dealt by " + getOpponentCurrentFighter().getName() + " is " + getEnemyDamage());
            getMyCurrentFighter().setLifePoints(getMyCurrentFighter().getLifePoints() - getEnemyDamage());
            if (getMyCurrentFighter().getLifePoints() > 0) {
                System.out.println(getMyCurrentFighter().getName() + "'s life points are now down to " + getMyCurrentFighter().getLifePoints() + "\n");
            } else {
                System.out.println(getMyCurrentFighter().getName() + "is knocked out \n");
                changeTurn();

            }
        } else {
            System.out.println("Game over, you win");
            return true;
        }
        return false;
    }


    public int getEnemyDamage() {
        if (checkElementalDependency()) {
            return getOpponentCurrentFighter().getAttack();
        } else {
            return getOpponentCurrentFighter().getAttack() - getMyCurrentFighter().getDefence();
        }
    }

    public boolean checkElementalDependency() {
        boolean result = false;
        if (changeTurn().equals(getMyCurrentFighter()) & (getMyCurrentFighter().getType().equals("electric")) & getOpponentCurrentFighter().getType().equals("water")) {
            result = true;
        } else if
        (changeTurn().equals(getMyCurrentFighter()) & (getMyCurrentFighter().getType().equals("water")) & getOpponentCurrentFighter().getType().equals("fire")) {
            result = true;
        } else if
        (changeTurn().equals(getMyCurrentFighter()) & (getMyCurrentFighter().getType().equals("fire")) & getOpponentCurrentFighter().getType().equals("rock")) {
            result = true;
        } else if
        (changeTurn().equals(getMyCurrentFighter()) & (getMyCurrentFighter().getType().equals("rock")) & getOpponentCurrentFighter().getType().equals("electric")) {
            result = true;
        } else if
        (changeTurn().equals(getOpponentCurrentFighter()) & (getOpponentCurrentFighter().getType().equals("electric")) & getMyCurrentFighter().getType().equals("water")) {
            result = true;
        } else if
        (changeTurn().equals(getOpponentCurrentFighter()) & (getOpponentCurrentFighter().getType().equals("water")) & getMyCurrentFighter().getType().equals("fire")) {
            result = true;
        } else if
        (changeTurn().equals(getOpponentCurrentFighter()) & (getOpponentCurrentFighter().getType().equals("fire")) & getMyCurrentFighter().getType().equals("rock")) {
            result = true;
        } else if
        (changeTurn().equals(getOpponentCurrentFighter()) & (getOpponentCurrentFighter().getType().equals("rock")) & getMyCurrentFighter().getType().equals("electric")) {
            result = true;
        }
        return !result;
    }

    public void drawVersusScreen() {
        if (getMyCurrentFighter().getName().equals("Pikachu") && getOpponentCurrentFighter().getName().equals("Cubone")) {
            MenuLayout.drawFiles("pikatch vs cubone.txt");
        } else if (getMyCurrentFighter().getName().equals("Pikachu") && getOpponentCurrentFighter().getName().equals("Kecleon")) {
            MenuLayout.drawFiles("pikatchu vs kecleon.txt");
        } else if (getMyCurrentFighter().getName().equals("Pikachu") && getOpponentCurrentFighter().getName().equals("Raichu")) {
            MenuLayout.drawFiles("pikatchu vs raichu.txt");
        } else if (getMyCurrentFighter().getName().equals("Pikachu") && getOpponentCurrentFighter().getName().equals("Tyranitar")) {
            MenuLayout.drawFiles("pikatchu vs tyranitar.txt");
        } else if (getMyCurrentFighter().getName().equals("Pikachu") && getOpponentCurrentFighter().getName().equals("Charizard")) {
            MenuLayout.drawFiles("pikatchu vs charizard.txt");
        } else if (getMyCurrentFighter().getName().equals("Charmender") && getOpponentCurrentFighter().getName().equals("Cubone")) {
            MenuLayout.drawFiles("charmender vs cubone.txt");
        } else if (getMyCurrentFighter().getName().equals("Charmender") && getOpponentCurrentFighter().getName().equals("Kecleon")) {
            MenuLayout.drawFiles("charmender vs kecleon.txt");
        } else if (getMyCurrentFighter().getName().equals("Charmender") && getOpponentCurrentFighter().getName().equals("Raichu")) {
            MenuLayout.drawFiles("charmender vs raichu.txt");
        } else if (getMyCurrentFighter().getName().equals("Charmender") && getOpponentCurrentFighter().getName().equals("Tyranitar")) {
            MenuLayout.drawFiles("charmender vs tyranitar.txt");
        } else if (getMyCurrentFighter().getName().equals("Charmender") && getOpponentCurrentFighter().getName().equals("Charizard")) {
            MenuLayout.drawFiles("charmender vs charizard.txt");
        } else if (getMyCurrentFighter().getName().equals("Ninetails") && getOpponentCurrentFighter().getName().equals("Cubone")) {
            MenuLayout.drawFiles("nine vs cubone.txt");
        } else if (getMyCurrentFighter().getName().equals("Ninetails") && getOpponentCurrentFighter().getName().equals("Kecleon")) {
            MenuLayout.drawFiles("nine vs kecleon.txt");
        } else if (getMyCurrentFighter().getName().equals("Ninetails") && getOpponentCurrentFighter().getName().equals("Raichu")) {
            MenuLayout.drawFiles("nine vs raichu.txt");
        } else if (getMyCurrentFighter().getName().equals("Ninetails") && getOpponentCurrentFighter().getName().equals("Tyranitar")) {
            MenuLayout.drawFiles("nine vs tyranitar.txt");
        } else if (getMyCurrentFighter().getName().equals("Ninetails") && getOpponentCurrentFighter().getName().equals("Charizard")) {
            MenuLayout.drawFiles("nine vs charizard.txt");
        } else if (getMyCurrentFighter().getName().equals("Squirtle") && getOpponentCurrentFighter().getName().equals("Cubone")) {
            MenuLayout.drawFiles("squirtle vs cubone.txt");
        } else if (getMyCurrentFighter().getName().equals("Squirtle") && getOpponentCurrentFighter().getName().equals("Kecleon")) {
            MenuLayout.drawFiles("squirtle vs kecleon.txt");
        } else if (getMyCurrentFighter().getName().equals("Squirtle") && getOpponentCurrentFighter().getName().equals("Raichu")) {
            MenuLayout.drawFiles("squirtle vs raichu.txt");
        } else if (getMyCurrentFighter().getName().equals("Squirtle") && getOpponentCurrentFighter().getName().equals("Tyranitar")) {
            MenuLayout.drawFiles("squirtle vs tyranitar.txt");
        } else if (getMyCurrentFighter().getName().equals("Squirtle") && getOpponentCurrentFighter().getName().equals("Charizard")) {
            MenuLayout.drawFiles("squirtle vs charizard.txt");
        } else if (getMyCurrentFighter().getName().equals("Sandshry") && getOpponentCurrentFighter().getName().equals("Cubone")) {
            MenuLayout.drawFiles("sandshru vs cubone.txt");
        } else if (getMyCurrentFighter().getName().equals("Sandshry") && getOpponentCurrentFighter().getName().equals("Kecleon")) {
            MenuLayout.drawFiles("sandshru vs kecleon.txt");
        } else if (getMyCurrentFighter().getName().equals("Sandshry") && getOpponentCurrentFighter().getName().equals("Raichu")) {
            MenuLayout.drawFiles("sandshru vs raichu.txt");
        } else if (getMyCurrentFighter().getName().equals("Sandshry") && getOpponentCurrentFighter().getName().equals("Tyranitar")) {
            MenuLayout.drawFiles("sandshru vs tyranitar.txt");
        } else if (getMyCurrentFighter().getName().equals("Sandshry") && getOpponentCurrentFighter().getName().equals("Charizard")) {
            MenuLayout.drawFiles("sandshru vs charizard.txt");
        }
    }
    public void evolve(){
        if(myCurrentFighter.getSize().equals("small")){
            myCurrentFighter.setSize("medium");
            System.out.println(myCurrentFighter.getName()+" evolved to "+getMyCurrentFighter().getSize());
        }else if(myCurrentFighter.getSize().equals("medium")){
            myCurrentFighter.setSize("big");
            System.out.println(myCurrentFighter.getName()+" evolved to "+getMyCurrentFighter().getSize());
        }
    }
    public void changeEvolutionStats(){
        if(myCurrentFighter.getSize().equals("medium")){
            myCurrentFighter.setAttack(myCurrentFighter.getAttack()+50);
            myCurrentFighter.setLifePoints(600);
            myCurrentFighter.setDefence(myCurrentFighter.getDefence()+20);
        }else if(myCurrentFighter.getSize().equals("big")){
            myCurrentFighter.setAttack(myCurrentFighter.getAttack()+50);
            myCurrentFighter.setLifePoints(700);
            myCurrentFighter.setDefence(myCurrentFighter.getDefence()+20);
        }
    }
}


