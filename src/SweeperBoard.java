import java.util.Random;

/**
 * Spielfeld.
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class SweeperBoard {

    private SweeperField[][] field;
    
    public SweeperField[][] getField() {
        return this.field;
    }

    private int fieldsize;

    public int getFieldsize() {
        return this.fieldsize;
    }

    /**
     * Prüft, ob es noch nicht entschärfte Minen gibt.
     * @return True = ja, false = nein
     */
    public Boolean getStillUndefusedMines() {
        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field[1].length; j++) {
                if (this.field[i][j].getClass() == SweeperMineField.class) {
                    if (!((SweeperMineField) (this.field[i][j])).getDefused()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Initialisieren des Spielfelds
     * @param fieldsize Spielfeldgröße
     * @param mineCount Minenanzahl
     * @param uncoverdFields Aufgedeckte Felder
     */
    public SweeperBoard(int fieldsize, int mineCount, int uncoverdFields) {
        this.fieldsize = fieldsize;
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
            int xCord = rdm.nextInt(field[0].length);
            int yCord = rdm.nextInt(field[1].length);
            
            if (field[xCord][yCord] == null) {
                field[xCord][yCord] = new SweeperMineField();
            } else {
                i--;
            }
        }

        //Rest auffüllen mit normalen Feldern
        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field[1].length; j++) {
                if (field[i][j] == null) {
                    field[i][j] = new SweeperNormalField();
                    ((SweeperNormalField) field[i][j]).setAdjacentBombs(countAdjacentBombs(i, j));
                }
            }
        }

        //Felder aufdecken
        for (int i = 0; i < uncoverdFields; i++) {
            int xCord = rdm.nextInt(field[0].length);
            int yCord = rdm.nextInt(field[1].length);
            
            if (field[xCord][yCord].getClass() == SweeperNormalField.class) {
                if (!((SweeperNormalField) field[xCord][yCord]).getUncoverd()) {
                    ((SweeperNormalField) field[xCord][yCord]).setUncoverd(true);
                }
            } else {
                i--;
            }
        }
    }

    private int countAdjacentBombs(int xCord, int yCord) {
        int count = 0;
        for (int k = -1; k < 2; k++) {
            for (int i = -1; i < 2; i++) {
                if (xCord + k >= 0 && yCord + i >= 0 
                    && xCord + k <= field[0].length - 1 
                    && yCord + i <= field[1].length - 1) {
                    if (this.field[xCord + k][yCord + i] != null) {
                        if (this.field[xCord + k][yCord + i].getClass() 
                            == SweeperMineField.class) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * Aufdecken des Felds.
     * @param coordinate Koordinate des Feldes.
     * @return True = Feld wurde aufgedeckt, False = Mine aufgedeckt
     */
    public Boolean moveOntoField(SweeperCoordinate coordinate) {
        int xCord = coordinate.getXCord();
        int yCord = coordinate.getYCord();

        if (this.field[xCord][yCord].getClass() == SweeperMineField.class) {
            return false;
        }
        ((SweeperNormalField) (this.field[xCord][yCord])).setUncoverd(true);
        return true;
    }

    /**
     * Versucht das Feld zu entschärfen.
     * @param coordinate Koordinate des zu entschärfenden Feldes.
     * @return True = geklappt, False = nicht geklappt
     */
    public Boolean defuseBomb(SweeperCoordinate coordinate) {
        int xCord = coordinate.getXCord();
        int yCord = coordinate.getYCord();

        if (this.field[xCord][yCord].getClass()
            != SweeperMineField.class) {
            return false;
        }
        if (((SweeperMineField)
            (this.field[xCord][yCord])).getDefused() == true) {
            return false;
        } else {
            ((SweeperMineField)
            (this.field[coordinate.getXCord()]
                [coordinate.getYCord()])).setDefused(true);
            return true;
        }
    }
}