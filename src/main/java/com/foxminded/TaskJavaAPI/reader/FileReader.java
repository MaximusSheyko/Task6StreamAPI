package com.foxminded.TaskJavaAPI.reader;

import com.foxminded.TaskJavaAPI.data.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

public class FileReader {
    public final static String IO_EXCEPTION = "File is not found";
    private String pathToAbbreviation;

    public FileReader(String pathToAbbreviation) throws IOException {
        this();

        if (!pathToAbbreviation.isEmpty ()){
            setPathToAbbreviation (pathToAbbreviation);
        }
    }

    public FileReader(){
        this.pathToAbbreviation = "src/main/java/com/foxminded/TaskJavaAPI/resource/abbreviations.txt" ;
    }

    public void setPathToAbbreviation (String pathToAbbreviation) throws IOException {
        if (pathToAbbreviation == null){
            throw new IOException (IO_EXCEPTION);
        }

        this.pathToAbbreviation = pathToAbbreviation;
    }


    public DataFile getAllLines (String pathToLog) throws IOException {
        if (pathToLog == null){
            throw new IOException (IO_EXCEPTION);
        }

        DataFile data = new DataFile ();
        
        data.setLogLines (Files.readAllLines (Path.of (pathToLog)));
        getAllLinesAbbreviation(data);
        
        return data;
    }
    
    private void getAllLinesAbbreviation(DataFile data) throws IOException{
	Map<String, String> abbreviations = Files.readAllLines (Path.of (pathToAbbreviation))
	        .stream ()
	        .distinct()
	        .collect(Collectors.toMap((key) -> key.substring(0, 3),
	                (values) -> values.substring(values.indexOf ("_") + 1)));
	
	data.setAbbreviations(abbreviations);
    }

}

