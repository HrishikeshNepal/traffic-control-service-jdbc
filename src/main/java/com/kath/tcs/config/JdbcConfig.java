package com.kath.tcs.config;

import com.kath.tcs.model.JdbcConfigProperties;
import lombok.Data;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Data
@Configuration
public class JdbcConfig {

    @Bean(name = "tcsDataSource")
    @Primary
    public BasicDataSource tcsDataSource(JdbcConfigProperties jdbcConfigProperties){
        return getTcsDataSource(jdbcConfigProperties);
    }

    private BasicDataSource getTcsDataSource(JdbcConfigProperties jdbcConfigProperties){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //dataSource.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
        dataSource.setUrl(jdbcConfigProperties.getUrl());
        dataSource.setUsername(jdbcConfigProperties.getUserName());
        dataSource.setPassword(jdbcConfigProperties.getPassword());
        dataSource.setInitialSize(3);
        dataSource.setMaxTotal(100);
        dataSource.setMaxWaitMillis(5);
        //dataSource.setValidationQuery(jdbcConfigProperties.getValidationQuery());
        return dataSource;
    }

    @Bean(name = "tcsJdbcTemplate")
    @Primary
    public JdbcTemplate tcsJdbcTemplate(BasicDataSource tcsDataSource) {
        return new JdbcTemplate(tcsDataSource);
    }

}
