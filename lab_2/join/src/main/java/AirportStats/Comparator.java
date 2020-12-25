package AirportStats;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {
    protected Comparator() {
        super(AirportKey.class, true);
    }

    public int compare(WritableComparable arg1, WritableComparable arg2){

        AirportKey key1 = (AirportKey)arg1;
        AirportKey key2 = (AirportKey)arg2;
        return key1.getId().compareTo(key2.getId());
    }
}
