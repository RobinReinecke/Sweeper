import java.util.Random;

/**
 * Spielfeld.
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class SweeperBoard {

    private SweeperField[][] field;
    
    /**
     * Initialisieren des Spielfelds
     * @param fieldsize Spielfeldgröße
     * @param mineCount Minenanzahl
     * @param uncoverdFields Aufgedeckte Felder
     */
    public SweeperBoard(int fieldsize, int mineCount, int uncoverdFields) {
        this.field = new SweeperField[fieldsize][fieldsize];
        this.fillBoard(mineCount, uncoverdFields);
    }

    /**
     * Befüllen des Spielfelds mit den Minen
     * @param mineCount Anzahl Minen
     * @param uncoverdFields Aufgedeckte Felder
     */
    private void fillBoard(int mineCount, int uncoverdFields) {
        Random rdm = new Random();

        //Minen zufällig platzieren
        for (int i = 0; i < mineCount; i++) {
            SweeperField tempField = field[rdm.nextInt(field[0].length + 1)][rdm.nextInt(field[0].length + 1)];
            
            if (tempField == null) {
                tempField = new SweeperMineField();
            }
            else{
                i--;
            }
        }

        //Rest auffüllen mit normalen Feldern
        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field[1].length; j++) {
                if (field[i][j] == null) {
                    field[i][j] = new SweeperNormalField();
                    field[i][j].adjacentBombs = countAdjacentBombs(field[i][j]);
                }
            }
        }
    }

    private SweeperField countAdjacentBombs(SweeperField field) {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < max; i++) {
                
            }
        }
    }
}