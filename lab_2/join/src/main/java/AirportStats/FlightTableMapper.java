package AirportStats;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class FlightTableMapper extends Mapper<LongWritable, Text, AirportKey, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] id_airpirt = CSVReader.readFlights(value);
        AirportKey akey = new AirportKey(id_airpirt[14].replace("/", ""), 0);
        context.write(akey, new Text(id_airpirt[17]));
    }
}