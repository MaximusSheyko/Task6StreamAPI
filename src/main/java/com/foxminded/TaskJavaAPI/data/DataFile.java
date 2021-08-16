package com.foxminded.TaskJavaAPI.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFile {
    List<String> logLines = new ArrayList<> ();
    Map<String, String> abbreviations = new HashMap<> ();

    public List<String> getLogLines () {
        return logLines;
    }

    public void setLogLines (List<String> logLines) {
        this.logLines = logLines;
    }

    public Map<String, String> getAbbreviations () {
        return abbreviations;
    }

    public void setAbbreviations (Map<String, String> abbreviations) {
        this.abbreviations = abbreviations;
    }
}
