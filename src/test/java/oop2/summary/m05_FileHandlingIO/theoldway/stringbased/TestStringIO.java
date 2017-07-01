package oop2.summary.m05_FileHandlingIO.theoldway.stringbased;

import org.junit.Test;

import java.io.IOException;
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
}
