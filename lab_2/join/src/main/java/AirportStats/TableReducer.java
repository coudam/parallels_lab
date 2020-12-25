package AirportStats;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class TableReducer extends Reducer<AirportKey, Text, Text, Text> {
    public  void reduce(AirportKey key, Iterable<Text> valuse, Context context) throws IOException {
        int count = 0;
        Text first = new Text(valuse.next());
        double min, max, sum = 0;
    }
}
