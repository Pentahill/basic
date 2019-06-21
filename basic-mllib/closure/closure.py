from pyspark import SparkContext, SparkConf
from os import environ

environ['JAVA_HOME'] = 'D:\Program Files\Java\jdk1.8.0_181'
environ['HADOOP_HOME'] = 'D:\hadoop-3.1.2'
environ['SPARK_HOME'] = 'D:\spark-2.4.3-bin-hadoop2.7\spark-2.4.3-bin-hadoop2.7'

conf = SparkConf() \
    .setAppName("demo") \
    .setMaster("spark://192.168.30.247:7077") \
    .set("spark.driver.host", "192.168.30.109")\
    .set("spark.cores.max", "4")\
    .set("spark.executor.memory", "512m")
sc = SparkContext(conf=conf)

# counter = 0
# rdd = sc.parallelize(range(1, 1000))
#
#
# def increment_counter(x):
#     global counter
#     counter += x
#
#
# rdd.foreach(increment_counter)
#
# print("Counter value: ", counter)


rdd = sc.parallelize(range(1, 1000))
acc = sc.accumulator(0)


def increment_counter(x):
    acc.add(x)


rdd.foreach(increment_counter)

print("Counter value: ", acc.value)

