package oop2.summary.m05_FileHandlingIO.theoldway.stringbased;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by degonas on 01.07.2017.
 */
public class TestStringIO {

    @Test
    public void testFindAll(){
        //given
        StringIO iomanager = new StringIO();

        //when
        List<String[]> allSongs = null;
        String[] firstSong = null;
        try {
            allSongs = iomanager.findAll();
            firstSong = allSongs.get(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        assertEquals("DJ Bobo", firstSong[0]);  //interpret
        assertEquals("Hallela", firstSong[1]);  //title
    }

    @Test
    public void triggerSave(){
        //given
        StringIO iomanager = new StringIO();
        //Daten:
        List<String[]> songs = Arrays.asList(
                new String[]{"DJ Bobo",     "Hallelu",  "120000"},
                new String[]{"DJ Steve",    "Mamamia",  "220000"},
                new String[]{"DJ Bobo",     "Chiuaua",  "100000"}
        );

        //when
        try {
            iomanager.save(songs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //then
        // Check out the file output.txt and compare them against List<String[]> songs.
    }
}
