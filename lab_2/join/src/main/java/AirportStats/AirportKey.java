package AirportStats;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.Text;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class AirportKey implements WritableComparable<AirportKey> {
    private Text Id;
    private IntWritable table;

    public AirportKey() {
        this.Id = new Text();
        this.table = new IntWritable();
    }
    public AirportKey(String name, int table) {
        this.Id = new Text(name);
        this.table = new IntWritable(table);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        Id.write(out);
        table.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        Id.readFields(in);
        table.readFields(in);
    }

    @Override
    public int compareTo(AirportKey o) {
        if (this.Id.compareTo(o.Id) != 0) return this.Id.compareTo(o.Id);
        else return this.table.compareTo(o.table);
    }

    public Text getId(){
        return this.Id;
    }
}

public class 