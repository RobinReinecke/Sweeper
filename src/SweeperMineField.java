/**
 * Minenfeld
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class SweeperMineField extends SweeperField {
    private Boolean defused = false;

    public Boolean getDefused() {
        return defused;
    }

    public void setDefused(Boolean value) {
        this.defused = value;
    }

    /**
     * Ausgabe des Felds als String
     * @param uncoverd True = aufgedeckt
     * @return Feld als String
     */
    public String toString(Boolean uncoverd) {
        if (uncoverd) {
            return "X";
        }
        if (this.defused) {
            return "!";
        }
        return " ";
    }
}