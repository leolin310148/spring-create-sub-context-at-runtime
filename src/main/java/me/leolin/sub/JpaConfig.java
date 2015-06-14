package me.leolin.sub;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;


/**
 * @author Leolin
 */
@Configuration
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
public class JpaConfig {

    @Value("${dbName}")
    private String dbName;

    @Bean
    DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:" + dbName)
                .username("sa")
                .password("")
                .build();
    }
}
