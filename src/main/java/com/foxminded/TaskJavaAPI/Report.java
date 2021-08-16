package com.foxminded.TaskJavaAPI;

import com.foxminded.TaskJavaAPI.reader.*;
import com.foxminded.TaskJavaAPI.formatter.*;

import java.io.IOException;

public class Report {

    public static final String ILLEGAL_EX = "Path is empty or null";
    private FileReader fileReader;
    private FormatterReport form;

    public Report(FileReader fileReader, FormatterReport form){
        this.fileReader = fileReader;
        this.form = form;
    }

    public String getReport(String pathToLog) throws IllegalAccessException, IOException {
        if (pathToLog == null || pathToLog.isEmpty ()){
            throw new IllegalAccessException (ILLEGAL_EX);
        }

        return form.getForm (fileReader.getAllLines (pathToLog));
    }
}

