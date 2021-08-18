package com.foxminded.TaskJavaAPI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.foxminded.TaskJavaAPI.parser.Parser;

class ParserTest {

    private Parser parser;
    public static final String NPE_MESSAGE = "lists is null";
    
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
    

}
