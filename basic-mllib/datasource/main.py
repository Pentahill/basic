from environment import spark
from pyspark.sql.functions import *

json = spark.read.load("hdfs://192.168.30.117:9000/tmp/json", "json")
# json.select('name', 'age').write.save("hdfs://192.168.30.117:9000/tmp/parquet1", format="parquet")

json1 = json.select(map(lambda name, age: name + ":" + age))
