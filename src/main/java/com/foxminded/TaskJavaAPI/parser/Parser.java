package com.foxminded.TaskJavaAPI.parser;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import com.foxminded.TaskJavaAPI.data.Racer;

public class Parser {

    private String patternDate = "yyyy-MM-dd_HH:mm:ss.SSS";
    public static final String ILLEGAL_EXCEPTION = "lists is null";

    public List<Racer> toParsingLogs(List<String> startLap, List<String>
            endLap, List<String> abbreviations)  {
	if(startLap == null || endLap == null || abbreviations == null) {
	    throw new IllegalArgumentException(ILLEGAL_EXCEPTION);
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
            var name = nameAndCarsRacer.get (key)
                    .substring (0, nameAndCarsRacer.get (key).indexOf ("_"));
            var car = nameAndCarsRacer.get (key).
                    substring (nameAndCarsRacer.get (key).lastIndexOf ("_") + 1);
            var time = duration.toString ();
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
