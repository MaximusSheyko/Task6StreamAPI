package com.foxminded.TaskJavaAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import com.foxminded.TaskJavaAPI.formatter.FormatterReport;
import com.foxminded.TaskJavaAPI.parser.Parser;

public class Report {

    private Parser parser;
    private FormatterReport format;
    public static final String ILLEGAL_EXCEPTION_MESSAGE = "input path is null";
    public static final String IOEXCEPTION_MESSAGE = "file not found";
    private List<String> linesStartLapLog;
    private List<String> linesEndLapLog;
    private List<String> linesFileAbbreviations;

    public Report(Parser parser, FormatterReport form){
        this.parser = parser;
        this.format = form;
    }

    public void writeFiles(String pathToLogStartLap, String pathToLogEndLap, String abbreviations) throws IOException{
        try {
            linesStartLapLog = Files.readAllLines ( Path.of (pathToLogStartLap));
            linesEndLapLog = Files.readAllLines (Path.of (pathToLogEndLap));
            linesFileAbbreviations = Files.readAllLines (Path.of (abbreviations));
        }catch(IllegalArgumentException exception) {
            throw new IllegalArgumentException(ILLEGAL_EXCEPTION_MESSAGE);
        }catch (IOException exception){
            throw new IOException(IOEXCEPTION_MESSAGE);
        }
    }

    public String getReport() throws ParseException, IllegalAccessException {
        return format.getForm (parser.toParsingLogs (linesStartLapLog, linesEndLapLog,
                    linesFileAbbreviations));
    }
}

