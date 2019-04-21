package com.zjp.test.server.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * 使用此配置类替换spring-configs.xml
 *
 * @Configuration 描述这个类是个配置类
 * @ComponentScan 用于定义要扫描的具体包
 */

@Configuration
public class DataSourceConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dbcpDataSource() {
        BasicDataSource druidDataSource = new BasicDataSource();
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        SqlSessionFactory factory = bean.getObject();
        org.apache.ibatis.session.Configuration configuration = factory.getConfiguration();
        configuration.setCacheEnabled(true);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setUseGeneratedKeys(true);

        return factory;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scanner = new MapperScannerConfigurer();
        scanner.setBasePackage("com.zjp.test.server.dao.mapper");
        scanner.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return scanner;
    }

    /* transaction manager */

    /**
     * 数据源事务管理器
     *
     * @return
     */
    @Primary
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 编程式事务
     *
     * @return
     */
    @Bean
    @Primary
    public TransactionTemplate transactionTemplate(DataSourceTransactionManager dataSourceTransactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTimeout(30);
        transactionTemplate.setTransactionManager(dataSourceTransactionManager);
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        return transactionTemplate;
    }
}