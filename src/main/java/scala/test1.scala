package scala

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object test1 {
  def main(args: Array[String]): Unit = {
    getAllMovie()
  }
  def getAllMovie():Array[String]= {
    val conf = new SparkConf().setAppName("test").setMaster("local[2]").set("spark.io.compression.codec", "snappy")
      .set("spark.driver.allowMultipleContexts","true").set("spark.testing.memory", "2147480000")
    val sc = new SparkContext(conf)
    var path = "file:///sparkfile/movies.csv"
    //path = "C:\\Users\\ASUS\\Desktop\\学习文件\\大三下\\spark\\ml-latest\\movies.csv"
    val file = sc.textFile(path)
    val lines = file.map(line => line)
    val ans = lines.collect();

    println("success")
    sc.stop()
    return ans
  }
  def search(str : String):Array[String]= {
    print("str= " +str)
    val conf = new SparkConf().setAppName("test").setMaster("local[2]").set("spark.io.compression.codec", "snappy")
      .set("spark.driver.allowMultipleContexts","true").set("spark.testing.memory", "2147480000")
    val sc = new SparkContext(conf)
    var path = "file:///sparkfile/movies.csv"
    //path = "C:\\Users\\ASUS\\Desktop\\学习文件\\大三下\\spark\\ml-latest\\movies.csv"
    val file = sc.textFile(path)
    val lines = file.filter(line => line.contains(str))
    lines.collect().foreach(println)
    val ans = lines.collect();

    println("success")
    sc.stop()
    return ans
  }
  def test():Array[String]= {
    val conf = new SparkConf().setAppName("scala").setMaster("spark://119.3.167.84:7077").set("spark.io.compression.codec", "snappy")
      .set("spark.driver.allowMultipleContexts","true").set("spark.testing.memory", "2147480000")
    val sc = new SparkContext(conf)
    var path = "C:\\Users\\ASUS\\Desktop\\学习文件\\大三下\\spark\\ml-latest\\movies.csv"
    path = "hdfs://119.3.167.84:9000//movies.csv"
    val file = sc.textFile(path)
    val lines = file.map(line => line)
    val ans = lines.collect();

    println("success")
    sc.stop()
    return ans
  }
  def test1():Array[String]= {
    val conf = new SparkConf().setAppName("scala").setMaster("local[2]").set("spark.io.compression.codec", "snappy")
      .set("spark.driver.allowMultipleContexts","true").set("spark.testing.memory", "2147480000")
    val sc = new SparkContext(conf)
    var path = "C:\\Users\\ASUS\\Desktop\\学习文件\\大三下\\spark\\ml-latest\\movies.csv"
    val file = sc.textFile(path)
    val lines = file.map(line => line)
    val ans = lines.collect();
    println("success")
    sc.stop()
    return ans
  }
  def create():Array[String]= {
    val conf = new SparkConf().setAppName("test").setMaster("local[2]").set("spark.io.compression.codec", "snappy")
    val sc = new SparkContext(conf)
    val path = "C:\\Users\\ASUS\\Desktop\\学习文件\\大三下\\spark\\ml-latest\\movies.csv"
    val spark = SparkSession.builder().appName("MysqlInsertDemo").master("local").getOrCreate()
    val df = spark.read.option("header", "true").csv(path)
    var lines = df.select("genres").rdd.map(line => line.getAs[String]("genres"))
    val lines1 = lines.flatMap(line => line.split("\\|")).distinct()
    //lines1.foreach(println)
    return lines1.collect()
  }
}
