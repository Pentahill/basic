from pyspark.ml.stat import Summarizer
from pyspark.sql import Row
from pyspark.ml.linalg import Vectors
from environment import spark

df = spark.createDataFrame([(1.0, Vectors.dense(1.0, 1.0, 1.0)),
                            (0.0, Vectors.dense(1.0, 2.0, 3.0))], ["weight", "features"])
summarizer = Summarizer.metrics("mean", "count")
df.select(summarizer.summary(df.features, df.weight)).show(truncate=False)
df.select(summarizer.summary(df.features)).show(truncate=False)
df.select(Summarizer.mean(df.features, df.weight)).show(truncate=False)
df.select(Summarizer.mean(df.features)).show(truncate=False)

