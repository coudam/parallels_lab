package AirportStats;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class FlightTableMapper extends Mapper<LongWritable, Text, AirportKey, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] id_airport = CSVReader.readFlights(value);
        if (id_airport[17].equals("") || id_airport[17].equals("\"ARR_DELAY\"")) return;
        AirportKey akey = new AirportKey(id_airport[14].replace("\"", ""), 0);
        context.write(akey, new Text(id_airport[17]));
    }
}