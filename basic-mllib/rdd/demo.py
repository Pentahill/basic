from pyspark import SparkContext, SparkConf
from os import environ

environ['JAVA_HOME'] = 'D:\Program Files\Java\jdk1.8.0_181'
environ['HADOOP_HOME'] = 'D:\hadoop-3.1.2'
environ['SPARK_HOME'] = 'D:\spark-2.4.3-bin-hadoop2.7\spark-2.4.3-bin-hadoop2.7'

conf = SparkConf()\
    .setAppName("demo")\
    .setMaster("spark://192.168.30.247:7077")\
    .set("spark.driver.host", "192.168.30.109")
sc = SparkContext(conf=conf)

# data = [1, 2, 3, 4, 5]
# distdata = sc.parallelize(data)

# distFile = sc.textFile("hdfs://192.168.30.117:9000/tmp/txt")
# print(distFile.map(lambda s: len(s)).reduce(lambda a, b:  a + b))

# rdd = sc.parallelize(range(1, 4)).map(lambda x: (x, "a" * x))
# rdd.saveAsSequenceFile("hdfs://192.168.30.117:9000/tmp/seq1")
# print(sorted(sc.sequenceFile("hdfs://192.168.30.117:9000/tmp/seq1").collect()))

# lines = sc.textFile("hdfs://192.168.30.117:9000/tmp/txt")
# lineLengths = lines.map(lambda s: len(s))
# totalLength = lineLengths.reduce(lambda a, b: a + b)
# print(totalLength)

counter = 0
rdd = sc.parallelize(range(1, 100))


# Wrong: Don't do this!!
def increment_counter(x):
    global counter
    counter += x


rdd.foreach(increment_counter)

print("Counter value: ", counter)

