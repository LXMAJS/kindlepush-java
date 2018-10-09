package com.lxmajs.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;

import java.beans.PropertyVetoException;

public class DataSourceConfiguration {
    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcUserName;
    private String jdbcPassword;

    @Bean(name = "dataSource")
    private ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUserName);
        dataSource.setPassword(jdbcPassword);
        // 关闭链接后不自动提交变更
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
