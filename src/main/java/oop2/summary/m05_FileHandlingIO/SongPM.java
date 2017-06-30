package oop2.summary.m05_FileHandlingIO;

/**
 * Created by Degonas on 30.06.2017.
 */
public class SongPM {
    private String interpret;
    private String titel;
    private String umsatz;

    public SongPM(String[] split) {
        interpret   = split[0];
        titel       = split[1];
        umsatz      = split[2];
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getUmsatz() {
        return umsatz;
    }

    public void setUmsatz(String umsatz) {
        this.umsatz = umsatz;
    }
}
