from environment import spark
from pyspark.sql.functions import col

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
], ["id1", "words"])

df2 = spark.createDataFrame([
    (0, "shanghai"),
    (1, "nanjing"),
    (3, "shanghai"),
    (4, "suzhou"),
    (5, "pizhou"),
    (6, "ningbo"),
    (7, "内蒙古"),
    (8, "广州"),
    (9, "厦门"),
    (20, "哈尔滨")
], ["id2", "address"])

# df1.filter(df1.id1 < 5).join(df2, df1.id1 == df2.id2).groupBy(df2.address).agg({"id1": "max"}).show()
# df1.agg({"id1": "max"}).show()

# df_as1 = df1.alias("df_as1")
# df_as2 = df1.alias("df_as2")
# joined_df = df_as1.join(df_as2, col("df_as1.id1") == col("df_as2.id1"), 'inner')
# joined_df.select("df_as1.words", "df_as2.words", "df_as2.id1").show()

# print(df1.coalesce(2).rdd.getNumPartitions())

df = spark.createDataFrame([("a", 1), ("b", 2), ("c",  3)], ["Col1", "Col2"])
# print(df.colRegex("`(Col)?+.+`"))
df.select(df.colRegex("`(Col)[1|2]+`")).show()
