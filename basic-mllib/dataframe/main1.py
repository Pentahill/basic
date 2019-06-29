from environment import spark
from pyspark.ml.feature import VectorAssembler

df = spark.createDataFrame([
    (0, "a"),
    (0, "b"),
    (0, "c"),
    (0, "d"),
    (0, "e"),
    (0, "f"),
    (0, "g"),
    (0, "h"),
    (0, "i"),
    (0, "j"),
    (1, "k")
], ["id", "words"])


def df2vector(df, features, label):
    if isinstance(features, str):
        features = features.split(',')

    assembler = VectorAssembler(inputCols=features, outputCol="features")

    return assembler.transform(df).select("features", df[label].alias('label')), df


# dfs = df.randomSplit([0.3, 0.7])
v, _ = df2vector(df, "id", "id")
v.show()

