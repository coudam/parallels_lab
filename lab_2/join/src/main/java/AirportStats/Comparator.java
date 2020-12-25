package AirportStats;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {

    public int compare(WritableComparator arg1, WritableComparator arg2){
        AirportKey key1 = new AirportKey(arg1);
        AirportKey key2 = new AirportKey(arg2);
        return

    }
}
