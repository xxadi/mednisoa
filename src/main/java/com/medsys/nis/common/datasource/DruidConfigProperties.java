//package com.medsys.emr.common.datasource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Component;
//
///**
// * author:Sxq
// * date:2020/5/21
// * description: druid公用的配置
// */
//@Component // 组件
//@ConfigurationProperties(prefix = "druidconfig") // 配置文件中的前缀
//@PropertySource("classpath:druidConfigProperties.properties") // 配置文件的名
//public class DruidConfigProperties {
//    private int initialSize;
//    private int minIdle;
//    private int maxActive;
//    private int maxWait;
//    private long timeBetweenEvictionRunsMillis;
//    private long minEvictableIdleTimeMillis;
//    private String validationQuery;
//    private boolean testWhileIdle;
//    private boolean testOnBorrow;
//    private boolean testOnReturn;
//    private boolean poolPreparedStatements;
//    private int maxPoolPreparedStatementPerConnectionSize;
//    private String filters;
//    private String connectionProperties;
//
//    public int getInitialSize() {
//        return initialSize;
//    }
//
//    public void setInitialSize(int initialSize) {
//        this.initialSize = initialSize;
//    }
//
//    public int getMinIdle() {
//        return minIdle;
//    }
//
//    public void setMinIdle(int minIdle) {
//        this.minIdle = minIdle;
//    }
//
//    public int getMaxActive() {
//        return maxActive;
//    }
//
//    public void setMaxActive(int maxActive) {
//        this.maxActive = maxActive;
//    }
//
//    public boolean isTestWhileIdle() {
//        return testWhileIdle;
//    }
//
//    public void setTestWhileIdle(boolean testWhileIdle) {
//        this.testWhileIdle = testWhileIdle;
//    }
//
//    public boolean isTestOnBorrow() {
//        return testOnBorrow;
//    }
//
//    public void setTestOnBorrow(boolean testOnBorrow) {
//        this.testOnBorrow = testOnBorrow;
//    }
//
//    public boolean isTestOnReturn() {
//        return testOnReturn;
//    }
//
//    public void setTestOnReturn(boolean testOnReturn) {
//        this.testOnReturn = testOnReturn;
//    }
//
//    public boolean isPoolPreparedStatements() {
//        return poolPreparedStatements;
//    }
//
//    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
//        this.poolPreparedStatements = poolPreparedStatements;
//    }
//
//    public String getFilters() {
//        return filters;
//    }
//
//    public void setFilters(String filters) {
//        this.filters = filters;
//    }
//
//    public String getConnectionProperties() {
//        return connectionProperties;
//    }
//
//    public void setConnectionProperties(String connectionProperties) {
//        this.connectionProperties = connectionProperties;
//    }
//
//    public int getMaxWait() {
//        return maxWait;
//    }
//
//    public void setMaxWait(int maxWait) {
//        this.maxWait = maxWait;
//    }
//
//    public long getTimeBetweenEvictionRunsMillis() {
//        return timeBetweenEvictionRunsMillis;
//    }
//
//    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
//        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
//    }
//
//    public long getMinEvictableIdleTimeMillis() {
//        return minEvictableIdleTimeMillis;
//    }
//
//    public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
//        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
//    }
//
//    public String getValidationQuery() {
//        return validationQuery;
//    }
//
//    public void setValidationQuery(String validationQuery) {
//        this.validationQuery = validationQuery;
//    }
//
//    public int getMaxPoolPreparedStatementPerConnectionSize() {
//        return maxPoolPreparedStatementPerConnectionSize;
//    }
//
//    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
//        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
//    }
//}
