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
        SweeperIO.printField(this.board.getField(), true);
        SweeperIO.printField(this.board.getField(), false);
    }

    private void DefuseMine(SweeperCoordinate coordinate) {
        Boolean success = this.board.defuseBomb(coordinate);
        SweeperIO.printDefuse(success);
    }
}