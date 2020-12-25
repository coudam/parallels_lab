package AirportStats;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.Iterator;

public class TableReducer extends Reducer<AirportKey, Text, Text, Text> {
    public  void reduce(AirportKey key, Iterable<Text> values, Context context) throws IOException {
        int count = 0;
        Iterator<Text> i = values.iterator();
        Text first = new Text(i.next());
        double min, max, sum = 0;
    }
}
