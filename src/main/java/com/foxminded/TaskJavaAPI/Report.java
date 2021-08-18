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

    public static final String ILLEGAL_EX = "Path is empty or null";
    private Parser parser;
    private FormatterReport form;
    public static final String NPEXEPTION_MESS = "input path is null";
    public static final String IOEXEPTION_MESS = "file not found";
    private List<String> linesStartLapLog;
    private List<String> linesEndLapLog;
    private List<String> linesFileAbbreviations;

    public Report(Parser parser, FormatterReport form){
        this.parser = parser;
        this.form = form;
    }

    public void writeFiles(String pathToLogStartLap, String pathToLogEndLap, String abbreviations) throws IOException{
        try {
            linesStartLapLog = Files.readAllLines ( Path.of (pathToLogStartLap));
            linesEndLapLog = Files.readAllLines (Path.of (pathToLogEndLap));
            linesFileAbbreviations = Files.readAllLines (Path.of (abbreviations));
        }catch(NullPointerException exception) {
            throw new NullPointerException(NPEXEPTION_MESS);
        }catch (IOException exception){
            throw new IOException(IOEXEPTION_MESS);
        }
    }

    public String getReport() throws ParseException, IllegalAccessException {
        return form.getForm (parser.toParsingLogs (linesStartLapLog, linesEndLapLog,
                    linesFileAbbreviations));
    }
}

