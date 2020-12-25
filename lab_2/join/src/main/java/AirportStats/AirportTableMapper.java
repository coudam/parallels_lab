package AirportStats;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class AirportTableMapper extends Mapper<LongWritable, Text, AirportKey, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] id_airport = CSVReader.readAirports(value);
        AirportKey akey = new AirportKey(id_airport[0].replace("\"", ""), 0);
        context.write(akey, new Text(id_airport[1]));
    }
}
