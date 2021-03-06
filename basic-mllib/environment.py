from os import environ
from pyspark.sql import SparkSession

environ['JAVA_HOME'] = 'D:\Program Files\Java\jdk1.8.0_181'
environ['HADOOP_HOME'] = 'D:\hadoop-3.1.2'
environ['SPARK_HOME'] = 'D:\spark-2.4.3-bin-hadoop2.7\spark-2.4.3-bin-hadoop2.7'
environ["PYSPARK_PYTHON"] = '/usr/local/bin/python3'
environ["PYSPARK_DRIVER_PYTHON"] = '/usr/local/bin/python3'

spark = SparkSession.builder \
    .master("spark://192.168.30.65:7077") \
    .appName("demo-1") \
    .config("hive.metastore.uris", "thrift://192.168.30.65:9083") \
    .config("spark.driver.port", "49906") \
    .config("spark.driver.host", "192.168.30.52") \
    .config("spark.executor.memory", "512m")\
    .config("spark.cores.max", "2")\
    .getOrCreate()
