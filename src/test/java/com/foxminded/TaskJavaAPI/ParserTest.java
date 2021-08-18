package com.foxminded.TaskJavaAPI;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.foxminded.TaskJavaAPI.data.Racer;
import com.foxminded.TaskJavaAPI.parser.Parser;

class ParserTest {

    private Parser parser;
    public static final String NPE_MESSAGE = "lists is null";
    public static final String START_LAP_DATE = "SVF2018-05-24_12:02:58.917";
    public static final String END_LAP_DATE = "SVF2018-05-24_12:04:03.332";
    public static final String ABBREVATIONS = "SVF_Sebastian Vettel_FERRARI";
    
    @BeforeEach
    void init() {
	parser = new Parser();
    }
    
    @Test
    void testToParsingLogs_whenInputListIsNull() {
	assertThrows(NullPointerException.class,
		()->parser.toParsingLogs(null, null, null));
	
	assertEquals(NPE_MESSAGE, assertThrows(NullPointerException.class,
		()->parser.toParsingLogs(null, null, null)).getMessage());
    }
    
    @Test
    void testToParsingLogs_whenInputListIsValid() throws ParseException {
	List<String> startLap = Arrays.asList(START_LAP_DATE);
	List<String> endLap = Arrays.asList(END_LAP_DATE);
	List<String> abbreviations = Arrays.asList(ABBREVATIONS);
	List<Racer> racers = new ArrayList<Racer>();
	racers.add(new Racer("Sebastian Vettel", "PT1M4.415S", "FERRARI"));
	
	
	assertEquals(racers.toString(), 
		parser.toParsingLogs(startLap, endLap, abbreviations).toString());
    }
    

}
