import os
from pyspark.sql import SparkSession
from pyspark.ml.linalg import Vectors
from pyspark.ml.stat import Correlation

os.environ['JAVA_HOME'] = 'D:\Program Files\Java\jdk1.8.0_181'
os.environ['HADOOP_HOME'] = 'D:\hadoop-3.1.2'
os.environ['SPARK_HOME'] = 'D:\spark-2.4.3-bin-hadoop2.7\spark-2.4.3-bin-hadoop2.7'

spark = SparkSession.builder\
                    .master("spark://192.168.30.247:7077")\
                    .appName("demo")\
                    .getOrCreate()

data = [(Vectors.sparse(4, [(0, 1.0), (3, -2.0)]),),
        (Vectors.dense([4.0, 5.0, 0.0, 3.0]),),
        (Vectors.dense([6.0, 7.0, 0.0, 8.0]),),
        (Vectors.sparse(4, [(0, 9.0), (3, 1.0)]),)]
df = spark.createDataFrame(data, ["features"])

print('hello')


