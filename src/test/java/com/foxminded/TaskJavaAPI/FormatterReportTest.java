package com.foxminded.TaskJavaAPI;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.foxminded.TaskJavaAPI.data.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.foxminded.TaskJavaAPI.formatter.FormatterReport;

class FormatterReportTest {

    FormatterReport format;
    public static final String REPORT_TABLE = "1  Make Horn  |FERRARI |1:12.434"
	    + System.lineSeparator() + "2  Maxim Smith|MERCEDES|1:4.415"
	    + System.lineSeparator() + "-------------------"
	    + System.lineSeparator();
    
    @BeforeEach
    void init() {
	format = new FormatterReport();
    }
    
    
    @Test
    void testGetForm_whenInDateIsValid() throws IllegalAccessException {
	List<Racer> racers = new ArrayList<Racer>();
	
	racers.add(new Racer("Make Horn", "PT1M12.434S","FERRARI"));
	racers.add(new Racer("Maxim Smith", "PT1M4.415S", "MERCEDES"));
	
	assertNotNull(format.getForm(racers));
	assertEquals(REPORT_TABLE, format.getForm(racers));	
    }
    
    @Test
    void testGetForm_whenInDateIsNull() throws IllegalAccessException {
	assertThrows(IllegalAccessException.class, 
		() -> format.getForm(null));
	
	assertNotNull(assertThrows(IllegalAccessException.class, 
		() -> format.getForm(null)).getMessage());
    }
}
