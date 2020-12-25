package AirportStats;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class AirportsStatsRun {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "join");
        job.setJarByClass(AirportsStatsRun.class);
        job.setJobName("Stat");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirportTableMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FlightTableMapper.class);
        Path outputPath = new Path(args[2]);
        FileOutputFormat.setOutputPath(job, outputPath);
        job.setPartitionerClass(TablePartitioner.class);
        job.setGroupingComparatorClass(Comparator.class);
        job.setReducerClass(TableReducer.class);
        job.setMapOutputKeyClass(AirportKey.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        outputPath.getFileSystem(conf);
        job.waitForCompletion(true);
        System.exit(0);
    }
}
