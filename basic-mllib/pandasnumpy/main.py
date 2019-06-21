import numpy as np
import pandas as pd
from environment import spark
from pyspark.sql.functions import pandas_udf
from pyspark.sql.types import LongType

# pdf = pd.DataFrame(np.random.rand(100, 3))
# df = spark.createDataFrame(pdf)
# df.show()


def multiply_func(a, b):
    return a * b


multiply = pandas_udf(multiply_func, returnType=LongType())
x = pd.Series([1, 2, 3])
print(multiply_func(x, x))


