from environment import spark
from pyspark.sql.functions import *


df = spark.read.text('hdfs://192.168.30.117:9000/tmp/txt')
# print(df.count())
# print(df.first())
# print(df.filter(df.value.contains("qian")).count())

# df.select(size(split(df.value, "\s+")).name("numWords")).agg(max(col("numWords"))).collect()

print(df.select(explode(split(df.value, "\s+")).alias("word")).groupBy("word").count().collect())

spark.stop()
