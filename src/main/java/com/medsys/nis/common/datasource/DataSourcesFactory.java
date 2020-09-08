//package com.medsys.emr.common.datasource;
//
//import com.alibaba.druid.pool.xa.DruidXADataSource;
//import com.atomikos.jdbc.AtomikosDataSourceBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
///**
// * author:Sxq
// * date:2020/5/14
// * description: 数据源工厂 用来生产不同数据源
// */
//@Component
//public class DataSourcesFactory {
//
//    @Autowired
//    DruidConfigProperties druidConfigProperties;
//
//    public DataSource getDataSourcesBean(String url, String username, String password, String driverClassName,String dataSourceName) {
//        DruidXADataSource dataSource = new DruidXADataSource();
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setInitialSize(druidConfigProperties.getInitialSize());
//        dataSource.setMinIdle(druidConfigProperties.getMinIdle());
//        dataSource.setMaxActive(druidConfigProperties.getMaxActive());
//        dataSource.setMaxWait(druidConfigProperties.getMaxWait());
//        dataSource.setTimeBetweenEvictionRunsMillis(druidConfigProperties.getTimeBetweenEvictionRunsMillis());
//        dataSource.setMinEvictableIdleTimeMillis(druidConfigProperties.getMinEvictableIdleTimeMillis());
//        dataSource.setValidationQuery(druidConfigProperties.getValidationQuery());
//        dataSource.setTestWhileIdle(druidConfigProperties.isTestWhileIdle());
//        dataSource.setTestOnBorrow(druidConfigProperties.isTestOnBorrow());
//        dataSource.setTestOnReturn(druidConfigProperties.isTestOnReturn());
//        dataSource.setPoolPreparedStatements(druidConfigProperties.isPoolPreparedStatements());
//        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidConfigProperties.getMaxPoolPreparedStatementPerConnectionSize());
//        try {
//            dataSource.setFilters(druidConfigProperties.getFilters());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        dataSource.setConnectionProperties(druidConfigProperties.getConnectionProperties());
//        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
//        xaDataSource.setXaDataSource(dataSource);
//        xaDataSource.setUniqueResourceName(dataSourceName);
//        return dataSource;
//    }
//}
