import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Game> game;
    ArrayList<Pokemon> myPokemon;
    ArrayList<Pokemon>enemyPokemon;
    Game(ArrayList<Game> game,ArrayList<Pokemon>myPokemon,ArrayList<Pokemon>enemyPokemon){
        this.game=game;
        this.myPokemon=myPokemon;
        this.enemyPokemon=enemyPokemon;
    }
    public void normalAttack(){
    }
    public void elementalAttack(){
    }
    public void specialAttack(){
    }
    public void healPokemon(){
    }
    public void changePokemon(){
    }
    public void checkPokemon(){
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println(myPokemon.get(i));
        }
    }
    public void printActionMenu(Scanner in){
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
        chooseAction( choice);
    }
    public void chooseAction(int choice){
        switch (choice){
            case 1->normalAttack();
            case 2->elementalAttack();
            case 3->specialAttack();
            case 4->changePokemon();
            case 5->healPokemon();
            case 6->checkPokemon();
        }
    }
    public void startGame(ArrayList<Pokemon>myPokemon){
        System.out.println("\n"+"Lets the game begin");
        printOpponent(enemyPokemon);
        System.out.println("\n"+"Choose your fighter");
        for (int i = 0; i < myPokemon.size(); i++) {
            System.out.println((i+1)+" "+myPokemon.get(i).getName());
        }
    }
    public void printOpponent(ArrayList<Pokemon>enemyPokemon){
        System.out.println("\n"+"Your opponent is "+"\n");
        for (int i = 0; i < enemyPokemon.size(); i++) {
            System.out.println(enemyPokemon.get(i));
        }

    }


}
