import java.io.IOException;
import java.text.ParseException;

import com.foxminded.TaskJavaAPI.Report;
import com.foxminded.TaskJavaAPI.formatter.FormatterReport;
import com.foxminded.TaskJavaAPI.parser.Parser;

public class Main {
   public static void main(String[] args) throws IllegalAccessException, IOException, ParseException {
       Report report = new Report(new Parser(), new FormatterReport());
       report.writeFiles("src/main/java/com/foxminded/TaskJavaAPI/resource/start.log",
	       "src/main/java/com/foxminded/TaskJavaAPI/resource/end.log",
	       "src/main/java/com/foxminded/TaskJavaAPI/resource/abbreviations.txt");
       
       System.out.print(report.getReport());
   }
}
