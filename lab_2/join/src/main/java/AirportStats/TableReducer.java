package AirportStats;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.Iterator;

public class TableReducer extends Reducer<AirportKey, Text, Text, Text> {
    public  void reduce(AirportKey key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        Iterator<Text> i = values.iterator();
        Text t = new Text(i.next());
//        Text first = new Text(i.next());
        double min = Double.MAX_VALUE, max = 0, sum = 0, value;

        while (i.hasNext()) {
            try{
                value = Double.parseDouble(i.next().toString());
            } catch(NumberFormatException ex){
                continue;
            }
            if (value > max) max = value;
            if (value < min) min = value;
            count ++;
            sum += value;
        }

        if (count != 0) context.write(t ,new Text("min value = " + min + " ; max value = " + max + " ; average value = " + sum / count));
    }
}
