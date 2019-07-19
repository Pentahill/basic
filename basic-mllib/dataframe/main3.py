from environment import spark
import json

df1 = spark.createDataFrame([
    (0, "a"),
    (1, "b"),
    (2, "c"),
    (3, "d"),
    (4, "e"),
    (5, "f"),
    (6, "g"),
    (7, "h"),
    (8, "i"),
    (9, "j"),
    (10, "k")
], ["id", "words"])

rdd = df1.toJSON()

# print(df1.toJSON().first())


