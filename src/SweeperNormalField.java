/**
 * Normales Feld.
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class SweeperNormalField extends SweeperField {

    private int adjacentBombs;
    
    private Boolean uncoverd = false;

    public Boolean getUncoverd() {
        return this.uncoverd;
    }

    public void setUncoverd(Boolean value) {
        this.uncoverd = value;
    }


    public int getAdjacentBombs() {
        return adjacentBombs;
    }

    public void setAdjacentBombs(int value) {
        this.adjacentBombs = value;
    }

    /**
     * Ausgabe des Felds als String
     * @param uncoverd True = aufgedeckt
     * @return Feld als String
     */
    public String toString(Boolean uncoverd) {
        if (uncoverd || this.uncoverd) {
            return String.valueOf(adjacentBombs);
        }
        return " ";
    }
    
}