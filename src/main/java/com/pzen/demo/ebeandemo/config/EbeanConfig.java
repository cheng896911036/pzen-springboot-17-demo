package com.pzen.demo.ebeandemo.config;

import io.ebean.DB;
import io.ebean.Database;
import io.ebean.datasource.DataSourceConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Ebean配置 并在项目启动时尽行数据库连接验证
 * @author pzen
 */
@Configuration
public class EbeanConfig {

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.databaseUrl}")
    private String databaseUrl;

    @Value("${datasource.databaseDriver}")
    private String databaseDriver;

    @Bean
    public DataSourceConfig dataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(databaseUrl);
        dataSourceConfig.setDriver(databaseDriver);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        dataSourceConfig.setHeartbeatSql("select 1");
        dataSourceConfig.build();
        // 这里可以添加更多的配置，比如连接池大小等
        return dataSourceConfig;
    }


    /**
     * 在应用启动时验证数据库连接  不需要可以直接注释当前方法
     */
    @PostConstruct
    public void validateDatabaseConnection() {
        try {
            Database defaultDatabase = DB.getDefault();
            DataSource dataSource = defaultDatabase.dataSource();
            Connection connection = dataSource.getConnection();
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Ebean Cannot establish database connection error ：", e);
        }
    }


}
