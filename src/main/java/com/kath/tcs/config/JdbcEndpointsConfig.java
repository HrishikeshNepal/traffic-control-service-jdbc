package com.kath.tcs.config;

import com.kath.tcs.model.JdbcConfigProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "database")
@Data
@NoArgsConstructor
public class JdbcEndpointsConfig {

    private Map<String, JdbcConfigProperties> connections;

    @Bean
    public JdbcConfigProperties tcsJdbcConfigProperties() throws BeanCreationException {
        if(null == connections.get("tcsdb")) {
            throw new BeanCreationException("tcsdb",
                    "application config validation failed, check configuration database.connections.tcsdb");
        }
        return connections.get("tcsdb");
    }
}
