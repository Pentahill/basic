package boot;

import org.apache.hive.jdbc.HiveDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hive.HiveClientFactory;
import org.springframework.data.hadoop.hive.HiveClientFactoryBean;
import org.springframework.data.hadoop.hive.HiveTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class HiveJdbcConfig {

    @Bean
    public HiveClientFactoryBean hiveClientFactory() {
        DataSource dataSource = new SimpleDriverDataSource(new HiveDriver(), "jdbc:hive2://192.168.30.65:10000");
        HiveClientFactoryBean hiveClientFactoryBean = new HiveClientFactoryBean();
        hiveClientFactoryBean.setHiveDataSource(dataSource);

        return hiveClientFactoryBean;
    }

    @Bean
    HiveTemplate hiveTemplate(HiveClientFactory factory) {
        return new HiveTemplate(factory);
    }
}
