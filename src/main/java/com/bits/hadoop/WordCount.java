package com.bits.hadoop;

import com.bits.hadoop.mapper.WordCountMapper;
import com.bits.hadoop.reducer.WordCountReducer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCount {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        if (args.length != 2) {
            System.err.println("Usage: WordCount <input path> <output path>");
            System.exit(-1);
        }
        final String inputLocation = args[0];
        final String outputLocation = args[1];
        // Define a MapReduce Job
        Job job = Job.getInstance();
        job.setJarByClass(WordCount.class);
        job.setJobName("Word Count");

        // Set input and output locations
        FileInputFormat.addInputPath(job, new Path(inputLocation));
        FileOutputFormat.setOutputPath(job, new Path(outputLocation));

        // Set Mapper and Reduce classes
        job.setMapperClass(WordCountMapper.class);
        job.setCombinerClass(WordCountReducer.class);
        job.setReducerClass(WordCountReducer.class);

        // Set Output types
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // Submit Job
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
