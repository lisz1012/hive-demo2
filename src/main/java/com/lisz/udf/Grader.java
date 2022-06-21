package com.lisz.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class Grader extends UDF {
//    public Text evaluate(final Text t) {
//        if (t == null) return null;
//        String str = t.toString();
//        String strs[] = str.split(",");
//        int score = Integer.parseInt(strs[3]);
//        String grade = null;
//        if (score >= 90) {
//            grade = "excellent";
//        } else if (score >= 80) {
//            grade = "good";
//        } else if (score >= 60){
//            grade = "ok";
//        } else {
//            grade = "fail";
//        }
//        return new Text(str + "," + grade);
//    }

    public Text evaluate(final Text textName, final IntWritable iwScore) {
        if (iwScore == null) return null;
        int score = iwScore.get();
        String grade = null;
        if (score >= 90) {
            grade = "excellent";
        } else if (score >= 80) {
            grade = "good";
        } else if (score >= 60){
            if (textName.toString().equals("zhangsan")) {
                grade = "perfect";
            } else {
                grade = "ok";
            }
        } else {
            grade = "fail";
        }

        return new Text(grade);
    }
}
