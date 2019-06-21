from environment import spark

jdbcDF = spark.read.format("jdbc")\
                    .option("url", "jdbc:mysql://192.168.30.59:3306/emr_sp1")\
                    .option("dbtable", "static_component")\
                    .option("user", "root")\
                    .option("password", "root")\
                    .load()

jdbcDF.show()

