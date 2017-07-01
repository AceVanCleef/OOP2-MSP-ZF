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

    /**************************** File Einlesen **************************************/

    public List<String[]> findAll() throws IOException{

        BufferedReader inputStream = null;      //Reads the File

        List<String[]> collector = new ArrayList<>();        //collect all Songs


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

    /**************************** In File speichern **************************************/

    public void save(List<String[]> allSongs) throws IOException {

        BufferedWriter outputStream = null;     //Alternativ: PrintWriter, da BufferedWriter.write(s) + BufferedWriter.newLine() = PrintWriter.println(s).

        try{
            outputStream = new BufferedWriter(new FileWriter("output.txt"));

            outputStream.write(HEADLINE);
            outputStream.newLine();

            for(String[] song : allSongs){
                String line = song[0] + DELIMITER + song[1] + DELIMITER + song[2];
                outputStream.write(line);
                outputStream.newLine();
            }
        }
        finally {
            if(outputStream != null){
                outputStream.close();
            }
        }
    }

    private InputStream getPath(String filename){
       return getClass().getResourceAsStream(filename); //finds file and returns it as a binary stream
    }
}
