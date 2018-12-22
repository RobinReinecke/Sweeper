/**
 * Abstrakte Klasse für die zwei Feldtypen.
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public abstract class SweeperField {

    /**
     * Umfandlung des Feldes in einen String
     * @param uncoverd Feld aufgedeckt ausgeben oder nicht.
     * @return Feld als String.
     */
    public abstract String toString(Boolean uncoverd);
}