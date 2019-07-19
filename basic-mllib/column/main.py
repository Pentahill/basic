from environment import spark
from pyspark.sql.types import IntegerType
from pyspark.sql.column import Column

df = spark.createDataFrame([
    (0, "Hi I heard about Spark"),
    (1, "I wish Java could use case classes"),
    (2, "Logistic,regression,models,are,neat")
], ["id", "sentence"])


class Coll(Column):

    def __init__(self, jc):
        super().__init__(jc)

    def cast(self):

        return


sen_col = df['sentence']
dd = df.withColumn('sentence', sen_col.cast(IntegerType()))
dd.show()

