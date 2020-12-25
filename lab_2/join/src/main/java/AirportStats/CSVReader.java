package AirportStats;

import org.apache.hadoop.io.Text;


public class CSVReader {
    public static String[] read(Text t){
        return t.toString().split(",");
    }

    public static String[] readAirports(Text t){
        return t.toString().split(",\"()!=@#$?");
    }

    public static String readWithoutSlash(Text t){
        return t.toString().replace("/","");
    }
}
