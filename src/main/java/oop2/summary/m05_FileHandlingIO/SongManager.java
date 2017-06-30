package oop2.summary.m05_FileHandlingIO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Degonas on 30.06.2017.
 */
public class SongManager {

    private static final String FILE_NAME = "/Songs.txt";
    private static final String DELIMITER = ";";
    private static final String HEADLINE = "INTERPRET;TITEL;UMSATZ";

    //todo: Die zweite Methode wertete diese HashMap aus und gab die gesamte Anzahl an Songs in einem Integer zurück. Diese Aufgabe gab nur etwa 4 Punkte, die andere etwa 15…?

    //todo: Mit Unittest überprüfen, ob evaluateSongs() und evtl andere Methoden wie countSongsOf(), findAll() richtig funktionieren.


    /**************************** HashMap<Interpret, Anz.Songs> erstellen **************************************/

    //HashMap<String, Integer>: String = Künstlername, Integer = Anzahl Songs dieses Künstlers
    public HashMap<String, Integer> evaluateSongs(){
        List<SongPM> allSongs = findAll();
        //gather all keys:
        List<String> keys = allSongs.stream()
                                .map(songPM -> songPM.getInterpret())
                                .distinct()
                                .collect(Collectors.toList());
        //create the hashmap and fill it with (key, value) - pairs:
        HashMap<String, Integer> songHeuristic = new HashMap<>();
        for (String interpret : keys){
            songHeuristic.put(interpret, countSongsOf(interpret, allSongs));
        }

        return songHeuristic;
    }

    /** counts the amount of
     */
    public int countSongsOf(String interpret, List<SongPM> allSongs){       //can be private. But Junit -> public
        return (int) allSongs.stream()
                .filter(songPM -> songPM.getInterpret().equals(interpret))
                .count();
    }


    /**************************** File Einlesen **************************************/

    public List<SongPM> findAll() {
        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {        // try-with-resources schliesst automatisch den Stream
            return streamOfLines.skip(1)                                          // erste Zeile ist die Headerzeile; ueberspringen
                    .map(s -> new SongPM(s.split(DELIMITER, 3)))             // aus jeder Zeile ein SongPM machen
                    .collect(Collectors.toList());
        }
    }

    private Stream<String> getStreamOfLines(String fileName) {
        try {
            return Files.lines(getPath(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Path getPath(String fileName) {
        try {
            return Paths.get(getClass().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }


    public static void main(String[] args){

    }
}
