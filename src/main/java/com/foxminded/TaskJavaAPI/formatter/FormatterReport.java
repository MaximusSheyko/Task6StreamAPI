package com.foxminded.TaskJavaAPI.formatter;

import com.foxminded.TaskJavaAPI.data.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FormatterReport {

    public static final String ILLEGAL_EXCEPTION = "list is null";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String VERTICAL_LINE = "|";

    public String getForm(List<Racer> racers) throws IllegalArgumentException {
	if (racers == null) {
	    throw new IllegalArgumentException(ILLEGAL_EXCEPTION);
	}

	StringBuilder report = new StringBuilder();
	int maxLengthFieldName = getMaxLengthLine(racers.stream()
		.map(Racer::getName)
		.toList());
	int maxLengthFieldCar = getMaxLengthLine(racers.stream()
		.map(Racer::getCar)
		.toList());
	int topRacer = 15;
	AtomicInteger position = new AtomicInteger(1);

	racers = racers.stream().sorted(Comparator.comparing(Racer::getTime)).toList();
	racers.stream()
		.forEach(racer -> racer.setTime(racer.getTime().replace("PT", "").replace("M", ":").replace("S", "")));
	racers.stream().limit(topRacer)
		.forEach(racer -> report.append(createLineTable(racer, maxLengthFieldCar, maxLengthFieldName, position)));
	report.append(String.format("%s", "-".repeat(maxLengthFieldCar + maxLengthFieldName) + LINE_SEPARATOR));
	racers.stream().skip(topRacer)
		.forEach(racer ->report.append(createLineTable(racer, maxLengthFieldCar, maxLengthFieldName, position)));

	return report.toString();
    }
    
    private String createLineTable(Racer racer,int maxLengthFieldCar,int maxLengthFieldName, AtomicInteger position) {
	StringBuilder line = new StringBuilder();
	
	line.append(String.format("%-2d ", position.getAndIncrement()))
	.append(String.format("%" + -maxLengthFieldName + "s", racer.getName()))
	.append(VERTICAL_LINE)
	.append(String.format("%" + -maxLengthFieldCar + "s|%s%s", racer.getCar(),racer.getTime(),
		LINE_SEPARATOR));
	
	return line.toString();
	
    }

    private int getMaxLengthLine(List<String> lines) {
	return lines.stream().sorted(Comparator.comparing(line -> (-1) * line.length())).toList().stream().findFirst()
		.get().length();
    }
}