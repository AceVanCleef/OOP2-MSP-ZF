package oop2.summary.m05_FileHandlingIO.theoldway.stringbased;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by degonas on 01.07.2017.
 */
public class StringIO {

    private static final String FILE_NAME = "Songs.txt";                //must be in same folder as this script.
    private static final String DELIMITER = ";";
    private static final String HEADLINE = "INTERPRET;TITEL;UMSATZ";

    public List<String[]> findAll() throws IOException{

        BufferedReader inputStream = null;      //Reads the File

        List<String[]> collector = new ArrayList<>();        //collect all Songs

        System.out.println(new File("").getAbsolutePath());

        try{
            inputStream = new BufferedReader(new InputStreamReader(getPath(FILE_NAME)));  //Liest Zeile als String.

            String line;
            while( (line = inputStream.readLine()) != null){
                String[] lineAsArray = line.split(DELIMITER, 3);
                collector.add(lineAsArray);
            }

        }
        finally {
            if(inputStream != null){
                inputStream.close();
            }
        }

        return collector;
    }

    private InputStream getPath(String filename){
       return getClass().getResourceAsStream(filename); //finds file and returns it as a binary stream
    }
}
