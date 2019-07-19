from pyspark import SparkContext, SparkConf
from os import environ
from environment import spark

from pyspark.ml.feature import VectorAssembler

# environ['JAVA_HOME'] = 'D:\Program Files\Java\jdk1.8.0_181'
# environ['HADOOP_HOME'] = 'D:\hadoop-3.1.2'
# environ['SPARK_HOME'] = 'D:\spark-2.4.3-bin-hadoop2.7\spark-2.4.3-bin-hadoop2.7'
#
# conf = SparkConf() \
#     .setAppName("demo") \
#     .setMaster("spark://192.168.30.247:7077") \
#     .set("spark.driver.host", "192.168.30.109") \
#     .set("spark.cores.max", "4") \
#     .set("spark.executor.memory", "512m")
# sc = SparkContext(conf=conf)
#
# data = sc.parallelize(['a', 'a', 'd', 'd', 'b', 'c', 'd', 'e', 'f', 'g'])
# pairs = data.map(lambda s: (s, 1))
# counts = pairs.reduceByKey(lambda a, b: a + b)
# print(counts.sortByKey().collect())

df = spark.createDataFrame([(1, 11, 19)], ["id", "name", "age"])
ddf = VectorAssembler(inputCols=["name", "age"], outputCol='features').transform(df)
ddf.show()
