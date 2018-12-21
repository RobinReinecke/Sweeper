/**
 * Hausaufgabe 4. Minesweeper Implementierung
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class Sweeper {
    public static void main() {
        int fieldsize = 10;
        int mineCount = 23;
        int uncoveredFields = 5;
        
        SweeperController game = new SweeperController(fieldsize, mineCount, uncoveredFields);
        game.runGame();
    }
}