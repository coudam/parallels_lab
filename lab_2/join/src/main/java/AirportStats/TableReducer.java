package AirportStats;

import org.apache.hadoop.mapreduce.Reducer;

import javax.xml.soap.Text;

public class TableReducer extends Reducer<AirportKey, Text, Text, Text> {
}
