package com.foxminded.TaskJavaAPI.data;

public class Racer {
    private String name;
    private String car;
    private String time;

    public Racer(String name, String time, String car){
        this(name, time);
        this.car = car;
    }

    public Racer(String name, String time){
        this.name = name;
        this.time = time;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getCar () {
        return car;
    }

    public void setCar (String car) {
        this.car = car;
    }

    public String getTime () {
        return time;
    }

    public void setTime (String time) {
        this.time = time;
    }

    @Override
    public String toString() {
	return "Racer [name=" + name + ", car=" + car + ", time=" + time + "]";
    }
    
    
}


