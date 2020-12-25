package AirportStats;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

public class TableReducer extends Reducer<AirportKey, Text, Text, Text> {
}
