import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class MenuLayout {
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
    public static void printMainMenu(Scanner in) {

        System.out.println("""
                1.NEW GAME
                2.INFO
                3.ABOUT
                4.EXIT""");
        checkValidInput(in, "[1234]", "Invalid input(1,2,3,4): ");
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> System.out.println("new");
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
}
