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

}
