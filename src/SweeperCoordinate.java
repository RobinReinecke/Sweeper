/**
 * Koordinaten.
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class SweeperCoordinate {

    private int xCord;
    
    public int getXCord(){
        return xCord;
    }

    private char xCordChar;

    private int yCord;

    public int getYCord(){
        return yCord;
    }

    public Boolean setCoordinate(String value, int fieldsize, String alphabet){
        if(value.length() != 2 ||
            alphabet.indexOf(value.charAt(0)) == -1 ||
            !Character.isDigit(value.charAt(1)) ) {
            return false;
        }
        this.xCordChar = value.charAt(0);
        this.xCord = alphabet.indexOf(value.charAt(0));
        this.yCord = Character.getNumericValue(value.charAt(1)) - 1;
        return true;
    }

    @Override
    public String toString(){
        return this.xCordChar + String.valueOf(this.yCord + 1);
    }
    
}