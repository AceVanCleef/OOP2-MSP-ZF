package oop2.summary.m05_FileHandlingIO.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Degonas on 28.06.2017.
 */
public class ServiceFileBased {

    private static final String FILE_NAME = "/data/countries.csv";
    private static final String DELIMITER = ";";
    private static final String HEADLINE = "ID;NAME;NAME_LONG;CAPITAL;POPULATION;AREA;POPULATION_KM2;FLAG;ISO_3;ISO_2;TLD;NAME_ENGLISH;NAME_LOCAL;CONTINENT";

    /**
     * 13x Delimiter (';') and 14 columsn.
     * @return
     */
//    public List<CountryDTO> findAll() {
//        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {        // try-with-resources schliesst automatisch den Stream
//            return streamOfLines.skip(1)                                                 // erste Zeile ist die Headerzeile; ueberspringen
//                    .map(s -> new CountryDTO(s.split(DELIMITER, 14)))                // aus jeder Zeile ein DTO machen
//                    .collect(Collectors.toList());
//        }
//    }

//    private Stream<String> getStreamOfLines(String fileName) {
//        try {
//            return Files.lines(getPath(fileName), StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            throw new IllegalStateException(e);
//        }
//    }

//    private Path getPath(String fileName)  {
//        try {
//            return Paths.get(getClass().getResource(fileName).toURI());
//        } catch (URISyntaxException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }


//    /************************** Save Countries To File **************************/
//    public void save(List<CountryDTO> dtos){
//        try{
//            //1 dto -> einem String in form id;name;...
//            List<String> dtosAsString = dtos.stream()
//                    .map(dto -> convertToString(dto))
//                    .collect(Collectors.toList());
//
//
//            dtosAsString.add(0, HEADLINE);      // Add Headline to List at the beginning
//
//            Files.write(getPath(FILE_NAME), dtosAsString, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);    // Write everything into file
//
//        }catch (IOException e){
//            throw new IllegalStateException(e);
//        }
//    }


//    protected String convertToString(CountryDTO dto){
//        return dto.getID()          + DELIMITER +
//                dto.getNAME()       + DELIMITER +
//                dto.getNAME_LONG()  + DELIMITER +
//                dto.getCAPITAL()    + DELIMITER +
//                dto.getPOPULATION() + DELIMITER +
//                dto.getAREA()       + DELIMITER +
//                dto.getPOPULATION_KM2() + DELIMITER +
//                dto.getFLAG()       + DELIMITER +
//                dto.getISO_3()      + DELIMITER +
//                dto.getISO_2()      + DELIMITER +
//                dto.getTLD()        + DELIMITER +
//                dto.getNAME_ENGLISH()   + DELIMITER +
//                dto.getNAME_LOCAL() + DELIMITER +
//                dto.getCONTINENT();
//
//    }
}
