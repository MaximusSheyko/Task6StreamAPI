package com.foxminded.TaskJavaAPI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.foxminded.TaskJavaAPI.formatter.FormatterReport;
import com.foxminded.TaskJavaAPI.parser.Parser;

@RunWith(MockitoJUnitRunner.class)
class ReportTest {

    @Mock
    private Parser parser;
    @Mock
    private FormatterReport format;
    
    @InjectMocks
    private Report report;
    
    @BeforeEach
    void init() {
	parser = mock(Parser.class);
	format = mock(FormatterReport.class);
	report = new Report(parser, format);
	
    }
    
    @Test
    void testReport_callMockObjects() throws IllegalAccessException, ParseException {
	report.getReport();
	
	verify(parser,times(1)).toParsingLogs(null, null, null);
	verify(format, times(1)).getForm(parser.toParsingLogs(null, null, null));
    }

    @Test
    void testWriteFiles_whenInputPathIsInvalid() {
	assertThrows(IOException.class, 
		() -> report.writeFiles("232", "sd/p", "jkk"));
    }
    
    @Test
    void testWriteFiles_whenInputPathIsNull() {
	assertThrows(NullPointerException.class, 
		() -> report.writeFiles(null, null, null));
    }

}
