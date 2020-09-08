//package com.medsys.emr.common.datasource;
//
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * author:Sxq
// * date:2020/5/21
// * description: 第二数据源配置
// */
//@Configuration
//@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
//public class ClusterDataSourceConfig {
//    private final Logger logger = LoggerFactory.getLogger(ClusterDataSourceConfig.class);
//    // 指定数据源方法的接口位置
//    static final String PACKAGE = "com.xinsiwei.mapper.cluster";
//    // 指定数据源对应的xml sql语句的位置
//    static final String MAPPER_LOCATION = "classpath*:mapping/cluster/*.xml";
//
//
//    @Autowired
//    DataSourcesFactory dataSourcesFactory;
//
//    @Value("${cluster.datasource.url}")
//    private String url;
//
//    @Value("${cluster.datasource.username}")
//    private String username;
//
//    @Value("${cluster.datasource.password}")
//    private String password;
//
//    @Value("${cluster.datasource.driver-class-name}")
//    private String driverClassName;
//
//
//    @Bean(name = "clusterDataSource")
//    //@Primary// 设置主数据源
//    public DataSource clusterDataSource() {
//        return dataSourcesFactory.getDataSourcesBean(url, username, password, driverClassName,"clusterDataSource");
//    }
//
//    @Bean(name = "clusterTransactionManager")
//    //@Primary// 设置主数据源
//    public DataSourceTransactionManager clusterTransactionManager() {
//        return new DataSourceTransactionManager(clusterDataSource());
//    }
//
//    // 因为多数据源所以分页插件配置在这里
//    @Bean(name = "clusterSqlSessionFactory")
//    //@Primary// 设置主数据源
//    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource masterDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(masterDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
//        //分页插件
////        Interceptor interceptor = new PageInterceptor();
//        Properties properties = new Properties();
//        //数据库
//        properties.setProperty("helperDialect", "oracle");
//        //是否将参数offset作为PageNum使用
//        properties.setProperty("offsetAsPageNum", "true");
//        //是否进行count查询
//        properties.setProperty("rowBoundsWithCount", "true");
//        //是否分页合理化
//
//        /*这里需要注意的是reasonable参数，表示分页合理化，默认值为false。
//        如果该参数设置为 true 时，pageNum<=0 时会查询第一页，pageNum>pages（超过总数时），
//        会查询最后一页。默认false 时，直接根据参数进行查询。*/
//
//        properties.setProperty("reasonable", "false");
////        interceptor.setProperties(properties);
////        sessionFactory.setPlugins(new Interceptor[] {interceptor});
//
//        return sessionFactory.getObject();
//    }
//    /*@Bean(name = "clusterSqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("clusterDataSource") DataSource masterDataSource) throws Exception {
//        SqlSessionTemplate template = new SqlSessionTemplate(clusterSqlSessionFactory(masterDataSource));
//        return template;
//    }*/
//}
