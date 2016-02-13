package com.cascading;

import cascading.flow.Flow;
import cascading.flow.hadoop.HadoopFlowConnector;
import cascading.operation.aggregator.Count;
import cascading.operation.regex.RegexSplitGenerator;
import cascading.pipe.Each;
import cascading.pipe.Every;
import cascading.pipe.GroupBy;
import cascading.pipe.Pipe;
import cascading.property.AppProps;
import cascading.scheme.hadoop.TextLine;
import cascading.tap.SinkMode;
import cascading.tap.Tap;
import cascading.tap.hadoop.Hfs;
import cascading.tuple.Fields;

import java.util.Properties;

public class CascadingHdfsWordCounter {

    public static void main(String[] args) {

        System.out.println("Job is started");
        //input and output path
        String inputPath = args[0];
        String outputPath = args[1];

        //Source and Sink Tap. Use Hfs. if you are testing in local, then use FileTap
        Tap srctap = new Hfs(new TextLine(new Fields("line")), inputPath);
        Tap sinkTap = new Hfs(new TextLine(new Fields("word", "count")), outputPath, SinkMode.REPLACE);

        Pipe words = new Each("token", new RegexSplitGenerator("\\s+"));
        Pipe group = new GroupBy(words);
        Count count = new Count();
        Pipe wcount = new Every(group, count);
        Properties properties = new Properties();
        AppProps.setApplicationJarClass(properties, CascadingHdfsWordCounter.class);
        //Use LocalFlowConnector if you are testing local
        HadoopFlowConnector flowConnector = new HadoopFlowConnector();
        Flow flow = flowConnector.connect("cascading wordcount job", srctap, sinkTap, wcount);
        flow.complete();
        System.out.println("Job is completed");
    }
}
