/**
 * Koordinaten.
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class SweeperCoordinate {

    private int xCord;
    
    public int getXCord() {
        return xCord;
    }

    private char xCordChar;

    private int yCord;

    public int getYCord() {
        return yCord;
    }

    /**
     * Koordinate parsen.
     * @param value zu parsender String
     * @param fieldsize Größe des Felds
     * @param alphabet Alphabet
     * @return true = erfolgreich, false = fehlerhafter String
     */
    public Boolean setCoordinate(String value, int fieldsize, String alphabet) {
        if (value.length() < 2 | value.length() > 3) {
            return false;
        }
        if (alphabet.indexOf(value.charAt(0)) == -1 ) {
            return false;
        }
        if (value.length() >= 2) {
            if (!Character.isDigit(value.charAt(1))) {
                return false;
            }
            if(Character.getNumericValue(value.charAt(1)) < 1 
            || Character.getNumericValue(value.charAt(1)) > fieldsize) {
                return false;
            }
            if (value.length() == 3) {
                if (!Character.isDigit(value.charAt(2))) {
                    return false;
                }
                if (Integer.valueOf(value.substring(1)) > fieldsize) {
                    return false;
                }
            }
        }

        this.xCordChar = value.charAt(0);
        this.xCord = alphabet.indexOf(value.charAt(0));
        this.yCord = Integer.valueOf(value.substring(1)) - 1;
        return true;
    }

    @Override
    public String toString() {
        return this.xCordChar + String.valueOf(this.yCord + 1);
    }
    
}