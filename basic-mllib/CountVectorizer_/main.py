from environment import spark
from pyspark.ml.feature import CountVectorizer

df = spark.createDataFrame([
    (0, "a b c d".split(" ")),
    (1, "a b b c a d".split(" "))
], ["id", "words"])

# cv = CountVectorizer(inputCol="words", outputCol="features", vocabSize=100, minDF=2.0)
# model = cv.fit(df)
#
# df1 = spark.createDataFrame([
#     (0, "a b c d".split(" ")),
#     (1, "a b b c a d".split(" "))
# ], ["id", "words"])
#
# result = model.transform(df1)
# result.show(truncate=False)

df.agg()
