/**
 * Kontrolliert das Spiel
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class SweeperController {

    /**
     * Spielfeld
     */
    private SweeperBoard board;

    /**
     * Konstruktor
     * @param _fieldsize Feldgröße
     * @param _mineCount Minenanzahl
     * @param _uncoverdFields Aufgedeckte Felder
     */
    public SweeperController(int fieldsize, int mineCount, int uncoverdFields) {
        this.board = new SweeperBoard(fieldsize, mineCount, uncoverdFields);
    }

    /**
     * Startet das Spiel.
     */
    public void runGame() {
        
    }
}