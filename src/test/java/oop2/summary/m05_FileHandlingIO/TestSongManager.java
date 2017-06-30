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
        for(SongPM song : allSongs){
            System.out.println(song);
        }

        //when
        int size = allSongs.size();
        SongPM firstSong = allSongs.get(0);

        //then
        assertEquals(9, size);  //Anzahl Zeilen in Songs.txt
        assertEquals("Hallela" ,firstSong.getTitel());
    }

    @Test
    public void testCountSongsOf(){
        //given
        List<SongPM> allSongs = songManager.findAll();
        String djBobo = allSongs.get(0).getInterpret();

        //when
        int songCount = songManager.countSongsOf(djBobo, allSongs);

        //then
        assertEquals(3, songCount); //DJ Bobo has 3 songs.
    }

    @Test
    public void testEvaluateSongs(){

    }

}
