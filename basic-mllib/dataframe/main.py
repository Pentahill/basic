from environment import spark
from pyspark import Row
from pyspark.sql.types import *

# json = spark.read.json("hdfs://192.168.30.117:9000/tmp/json")
# json.show()
# json.printSchema()
# json.select('name').show()
# json.filter(json['age'] < 21).show()
# json.groupBy("age").count().show()

# json.createOrReplaceTempView("people")
# sqlDF = spark.sql("SELECT name FROM people")
# sqlDF.show()

# json.createGlobalTempView("people")
# spark.sql("SELECT name FROM global_temp.people").show()
# spark.newSession().sql("SELECT name FROM global_temp.people").show()

# sc = spark.sparkContext
# lines = sc.textFile("hdfs://192.168.30.117:9000/tmp/txt")
# parts = lines.map(lambda l: l.split(','))
# people = parts.map(lambda p: Row(name=p[0], age=int(p[1])))
# schemaPeople = spark.createDataFrame(people)
# schemaPeople.createOrReplaceTempView("people")
# teenagers = spark.sql("SELECT name FROM people WHERE age >= 13 AND age <=19")
# teenName = teenagers.rdd.map(lambda p: "Name: " + p.name).collect()
# for name in teenName:
#     print(name)

# sc = spark.sparkContext
# lines = sc.textFile("hdfs://192.168.30.117:9000/tmp/txt")
# parts = lines.map(lambda l: l.split(','))
# people = parts.map(lambda p: (p[0], p[1].strip()))
# schemaString = 'name age'
# fields = [StructField(field_name, StringType(), True) for field_name in schemaString.split()]
# schema = StructType(fields)
#
# schemaPeople = spark.createDataFrame(people, schema)
# schemaPeople.createOrReplaceTempView("people")
# teenagers = spark.sql("SELECT * FROM people WHERE age >= 13 AND age <=19")
# teenagers.show()



