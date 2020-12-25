package AirportStats;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.Iterator;

public class TableReducer extends Reducer<AirportKey, Text, Text, Text> {
    public  void reduce(AirportKey key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        Iterator<Text> i = values.iterator();
        Text first = new Text(i.next());
        double min = Double.parseDouble(first.toString()), max = min, sum = 0;

        while (i.hasNext()) {
            double value = Double.parseDouble(i.next().toString());
            if (value > max) max = value;
            if (value < min) min = value;
            count ++;
            sum += value;
        }

        if (count != 0) context.write(new Text("Stats: "),new Text("min value = " + min + " ;\nmax value = " + max + " ;\naverage value = " + sum / count));
    }
}
