//package oop2.summary.m05_FileHandlingIO.service;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.Files;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class ServiceFileBased {
//
//    private static final String FILE_NAME = "/Songs.txt";
//    private static final String DELIMITER = ";";
//    private static final String HEADLINE = "INTERPRET;TITEL;UMSATZ";
//
//    public List<String> findAll() {
//        try (Stream<String> streamOfLines = getStreamOfLines(FILE_NAME)) {        // try-with-resources schliesst automatisch den Stream
//            return streamOfLines.skip(1)                                          // erste Zeile ist die Headerzeile; ueberspringen
//                    .map(s -> new CountryDTO(s.split(DELIMITER, 3)))             // aus jeder Zeile ein DTO machen
//                    .collect(Collectors.toList());
//        }
//    }
//
//    private Stream<String> getStreamOfLines(String fileName) {
//        try {
//            return Files.lines(getPath(fileName), StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//
//    private Path getPath(String fileName) {
//        try {
//            return Paths.get(getClass().getResource(fileName).toURI());
//        } catch (URISyntaxException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }
//}