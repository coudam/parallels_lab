package AirportStats;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class TablePartitioner extends Partitioner<AirportKey, Text>  {
    @Override
    public int getPartition(AirportKey airportKey, Text text, int i) {
        return (airportKey.getId());
    }
}
