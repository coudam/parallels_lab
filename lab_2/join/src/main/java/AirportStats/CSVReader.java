package AirportStats;

import org.apache.hadoop.io.Text;


public class CSVReader {
    public static String[] readWithSplit(Text t){
        return t.toString().split(",");
    }

    public static String[] readWithSpacialSplit(Text t){
        return t.toString().split(",\"()!=@#$?");
    }

    public static String readWithoutSlash(Text t){
        return t.toString().replace("/","");
    }
}
