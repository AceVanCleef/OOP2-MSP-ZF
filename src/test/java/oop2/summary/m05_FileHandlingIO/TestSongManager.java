package oop2.summary.m05_FileHandlingIO;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


import java.util.List;

/**
 * Created by degonas on 30.06.2017.
 */
public class TestSongManager {

    private SongManager songManager;

    @Before
    public void setUp(){
        songManager = new SongManager();
    }

    @Test
    public void testFindAll(){
        //given
        List<SongPM> allSongs = songManager.findAll();

        //when
        int size = allSongs.size();
        SongPM firstSong = allSongs.get(0);
        for(SongPM song : allSongs){
            System.out.println(song);
        }

        //then
        assertEquals(9, size);  //Anzahl Zeilen in Songs.txt
        assertEquals("Hallela" ,firstSong.getTitel());
    }

    @Test
    public void testCountSongsOf(){

    }

    @Test
    public void testEvaluateSongs(){

    }

}
