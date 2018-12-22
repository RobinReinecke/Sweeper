import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Klasse füe die Konsoleninteraktion
 *
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class SweeperIO {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Feld ausgeben
     * @param field Das auszugebene Feld
     * @param uncoverd true = Alle Felder aufdecken 
     */
    public static void printField(SweeperField[][] field, Boolean uncoverd) {
        StringBuilder sb = new StringBuilder("  |");
        for (int i = 0; i < field[0].length; i++) {
            sb.append(ALPHABET.charAt(i % 27) + "|");
        }
        sb.append("\n");

        for (int i = 0; i < field[1].length; i++) {
            if (i <= 8) {
                sb.append(" ");
            }            
            sb.append(i + 1);
            sb.append("|");

            for (int j = 0; j < field[0].length; j++) {
                sb.append(field[j][i].toString(uncoverd) + "|");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    /**
     * Eingabe einer Koordinate vom Nutzer fordern.
     * @param fieldsize Größe des Feldes zur Validierung
     * @return Koordinatenobjekt
     */
    public static SweeperCoordinate requireCoordinate(int fieldsize) {
        SweeperCoordinate cord = new SweeperCoordinate();
        String coordinate = "";
        do {
            System.out.print("Enter next coordinate (e.g. \"H4\"): ");
            coordinate = scanner.next();
        } while (!cord.setCoordinate(coordinate, fieldsize, ALPHABET));

        return cord;
    }

    /**
     * Eingabe einer Action vom Nutzer fordern.
     * @return SweeperAction
     */
    public static SweeperAction requireAction() {
        //Scanner scanner = new Scanner(System.in);
        int action = -1;
        do {    
            System.out.print("Enter action (1 for ’move onto’ , 2 for ’defuse’): ");
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException exception) {
                scanner.nextLine();
                scanner.reset();
            }
        } while (action != 1 && action != 2);

        return action == 1 ? SweeperAction.MOVEONTO : SweeperAction.DEFUSE;
    }

    /**
     * Ausgabe des Entschärfens.
     * @param coordinate Koordinate
     * @param success True = Entschärfen war erfolgreich
     */
    public static void printDefuse(SweeperCoordinate coordinate, Boolean success) {
        System.out.println("Trying to defuse'" + coordinate.toString() + "'");
        System.out.println(success ? "Defused a landmine!" : "Nothing happend!");
    }

    /**
     * Ausgabe des Aufdeckens.
     * @param coordinate Koordinate
     * @param success False = Auf eine Mine getreten
     */
    public static void printMoveOnto(SweeperCoordinate coordinate, Boolean success) {
        System.out.println(success ? "Moving onto '" + coordinate.toString() + "'" 
            : "Stepped on a landmine!");
    }

    /**
     * Ausgabe, dass der Nutzer gewonnen hat.
     */
    public static void printWin() {
        System.out.println("You won!");
    }
}