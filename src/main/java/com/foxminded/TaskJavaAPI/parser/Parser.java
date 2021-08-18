package com.foxminded.TaskJavaAPI.parser;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import com.foxminded.TaskJavaAPI.data.Racer;

public class Parser {

    private String patternDate = "yyyy-MM-dd_HH:mm:ss.SSS";
    public static final String NPE_MESSAGE = "lists is null";

    public List<Racer> toParsingLogs(List<String> startLap, List<String>
            endLap, List<String> abbreviations) throws ParseException {
	if(startLap == null || endLap == null || abbreviations == null) {
	    throw new NullPointerException(NPE_MESSAGE);
	}
        List<Racer> racers = new ArrayList<> ();
        Map<String, String> startDate = createMap (startLap);
        Map<String, String> endDate = createMap (endLap);
        Map<String, String> nameAndCarsRacer = abbreviations
                .stream ().distinct().collect(Collectors.toMap((key) -> key.substring(0, 3),
                        (values) -> values.substring(values.indexOf ("_") + 1)));
        Set<String> keys = nameAndCarsRacer.keySet ();
        var formatter = DateTimeFormatter.ofPattern (patternDate, Locale.ENGLISH);

        for (String key : keys){
            var timeStart = LocalDateTime.parse (startDate.get (key),formatter);
            var timeEnd = LocalDateTime.parse (endDate.get (key), formatter);
            Duration duration = Duration.between (timeStart, timeEnd);
            String name = nameAndCarsRacer.get (key)
                    .substring (0, nameAndCarsRacer.get (key).indexOf ("_"));
            String car = nameAndCarsRacer.get (key).
                    substring (nameAndCarsRacer.get (key).lastIndexOf ("_") + 1);
            String time = duration.toString ();
            racers.add (new Racer (name, time, car));
        }

        return racers;
    }

    private Map<String,String>  createMap(List<String>  listRacers){
        return listRacers.stream ()
                .distinct()
                .collect(Collectors.toMap((key) -> key.substring(0, 3),
                        (values) -> values.substring(3)));
    }
}
