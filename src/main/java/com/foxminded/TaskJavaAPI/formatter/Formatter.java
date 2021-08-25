package com.foxminded.TaskJavaAPI.formatter;

import java.util.List;

public interface Formatter<T> {
    public String getForm(List<T> objects);
}
