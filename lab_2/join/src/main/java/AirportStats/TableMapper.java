package AirportStats;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class TableMapper extends Mapper<LongWritable, Text, AirportKey, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException{
        String
    }
}
