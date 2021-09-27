import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * The function is expected to return a STRING with the time converted.
     * The function accepts STRING s as parameter in the command line.
     */

    public static String timeConversion(String s) {
    String militaryTime = "00:00:00";
    String isAM_PM = s.substring(s.length() - 2, s.length());
    String standardTime = s.substring(0, s.length()-2);
    String standardHour = s.substring(0,2);
    String standardMinSec = s.substring(2,s.length()-2);
    
    int standardHourToInt = Integer.parseInt(standardHour); //gets an int for the standardHour
    int militaryHour = standardHourToInt + 12; //converts to a military hour
    boolean PM = false; //boolean to determine if it is the afternoon
    
    //conditional logic for 00 and 12 handling
    if(isAM_PM.equals("PM")) { PM = true; }
    
    //PM Logic
    if(PM) {
        if(standardHourToInt == 12){
            militaryHour = 12;
            militaryTime = militaryHour + standardMinSec;
            return militaryTime;
        }
        else { 
            militaryHour = standardHourToInt + 12;
            militaryTime = militaryHour + standardMinSec;
            return militaryTime;
        }
    }
    //AM logic
    if(isAM_PM.equals("AM")) {
        if(standardHourToInt == 12){
            String r = "00";
            militaryTime = r + standardMinSec;
            return militaryTime;
        }
        else{
        return standardTime;
        }
    }
    return null;
    }
}

public class timeConverter{
        public static void main(String[] args) {
        String s = args[0];
        String result = Result.timeConversion(s);
        System.out.println(result);
    }
}
