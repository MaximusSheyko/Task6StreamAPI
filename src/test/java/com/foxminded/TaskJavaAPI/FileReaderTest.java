package com.foxminded.TaskJavaAPI;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.foxminded.TaskJavaAPI.reader.FileReader;

class FileReaderTest {
    
    FileReader reader;
    
    @BeforeEach
    void init() {
	reader = new FileReader();
    }
    
    @Test
    void testGetAllLines_whenInputPathIsNullOrEmpty() {
	assertThrows(IOException.class,
		()->reader.getAllLines(null));
	assertThrows(IOException.class,
		()->reader.getAllLines(""));
	
    }
    
    @Test
    void testGetAllLines_whenInputPathIsInvalid() {
   	assertThrows(IOException.class,
   		()->reader.getAllLines("sdsd/099"));
    }
    
    @Test
    void testGetAllLines_whenInputPathIsValid() throws IOException {
   	assertNotNull(reader.getAllLines("src/main/java/com/foxminded/TaskJavaAPI/resource/start.log"));
    }
}
