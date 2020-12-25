package AirportStats;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class TableMapper extends Mapper<LongWritable, Text, AirportKey, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException{
        String id_airpirt[] = CSVReader.readAirports(value);
        AirportKey akey = new AirportKey(id_airpirt[0].replace("/", ""), 0);
        context.write();
    }
}
