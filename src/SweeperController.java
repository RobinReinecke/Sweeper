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
     * @param fieldsize Feldgröße
     * @param mineCount Minenanzahl
     * @param uncoverdFields Aufgedeckte Felder
     */
    public SweeperController(int fieldsize, int mineCount, int uncoverdFields) {
        this.board = new SweeperBoard(fieldsize, mineCount, uncoverdFields);
    }

    /**
     * Startet das Spiel.
     */
    public void runGame() {
        SweeperIO.printField(this.board.getField(), false);
        
        Boolean running = true;

        do {
            SweeperCoordinate coordinate = 
                SweeperIO.requireCoordinate(this.board.getFieldsize());
            
            SweeperAction action = SweeperIO.requireAction();

            if (action == SweeperAction.MOVEONTO) {
                running = this.moveOntoField(coordinate);
            } else {
                this.defuseMine(coordinate);
            }
            
            if (!this.board.getStillUndefusedMines()) {
                running = false;
                SweeperIO.printWin();
            }
            
            if (!running) {
                continue;
            }
            SweeperIO.printField(this.board.getField(), false);
        } while (running);

        SweeperIO.printField(this.board.getField(), true);
    }

    private Boolean moveOntoField(SweeperCoordinate coordinate) {
        Boolean success = this.board.moveOntoField(coordinate);
        SweeperIO.printMoveOnto(coordinate, success);
        return success;
    }

    private void defuseMine(SweeperCoordinate coordinate) {
        Boolean success = this.board.defuseBomb(coordinate);
        SweeperIO.printDefuse(coordinate, success);
    }


}