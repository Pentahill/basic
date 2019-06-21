from pyspark import SparkContext, SparkConf
from os import environ

environ['JAVA_HOME'] = 'D:\Program Files\Java\jdk1.8.0_181'
environ['HADOOP_HOME'] = 'D:\hadoop-3.1.2'
environ['SPARK_HOME'] = 'D:\spark-2.4.3-bin-hadoop2.7\spark-2.4.3-bin-hadoop2.7'

conf = SparkConf() \
    .setAppName("demo") \
    .setMaster("spark://192.168.30.247:7077") \
    .set("spark.driver.host", "192.168.30.109") \
    .set("spark.cores.max", "4") \
    .set("spark.executor.memory", "512m")
sc = SparkContext(conf=conf)

data = sc.parallelize(range(1, 100))
# data.collect().foreach(lambda x: print(x))
