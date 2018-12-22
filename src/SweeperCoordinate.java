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

    private int yCord;

    public int getYCord(){
        return yCord;
    }

    public Boolean setCoordinate(String value, int fieldsize, String alphabet){
        if(value.length() != 2 ||
            alphabet.indexOf(value.charAt(0)) == -1 ||
            Character.isDigit(value.charAt(1)) ) {
            return false;
        }
        this.xCord = alphabet.indexOf(value.charAt(0));
        this.yCord = (int)value.charAt(1) - 1;
        return true;
    }

    @Override
    public String toString(){
        return xCord + String.valueOf(yCord);
    }
    
}