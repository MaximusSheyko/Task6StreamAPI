package com.foxminded.TaskJavaAPI;

import static org.mockito.Mockito.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.foxminded.TaskJavaAPI.data.DataFile;
import com.foxminded.TaskJavaAPI.formatter.FormatterReport;
import com.foxminded.TaskJavaAPI.reader.FileReader;

@RunWith(MockitoJUnitRunner.class)
class ReportTest {
    
    @Mock
    private FormatterReport formatter;
    @Mock
    private FileReader reader;
    @InjectMocks
    private Report report;
    
    
    @BeforeEach
    void init() {
	formatter = mock(FormatterReport.class);
	reader = mock(FileReader.class);
	report = new Report(reader, formatter);
    }
    
    @Test
    void testGetReport_CallMockMethode() throws IllegalAccessException, IOException {
	report.getReport("testPath");
	
	verify(reader, times(1)).getAllLines("testPath");
	verify(formatter, times(1)).getForm(reader.getAllLines("testPath"));
    }
    
    @Test 
    void testGetReport_whenInputPathIsNullOrEmpty() throws IllegalAccessException, IOException {	
	assertThrows(IllegalArgumentException.class, () -> report.getReport(""));

    }
    

}
