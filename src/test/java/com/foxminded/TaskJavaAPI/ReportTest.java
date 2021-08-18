package com.foxminded.TaskJavaAPI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    Parser parser;
    @Mock
    FormatterReport format;
    
    @InjectMocks
    Report report;
    
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
	verify(format, times(2)).getForm(parser.toParsingLogs(null, null, null));
    }

    //@Test
    void testWriteFiles() {
	fail("Not yet implemented");
    }

}
