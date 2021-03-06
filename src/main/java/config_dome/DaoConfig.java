package config_dome;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.beans.PropertyVetoException;
import java.io.IOException;

@Configuration
@PropertySource("classpath:application.properties")
public class DaoConfig implements EnvironmentAware {

    Environment evn;

    //想使用占位符
    public static PropertySourcesPlaceholderConfigurer s(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }

    //创建数据源
    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        //还有其他的连接池
        //SimpleDriverDataSource dataSource1 = new SimpleDriverDataSource();
        //PooledDataSource pooledDataSource = new PooledDataSource();

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
     /*   dataSource.setJdbcUrl(evn.getProperty("jdbc.url"));
        dataSource.setDriverClass("${jdbc.driver}");
        dataSource.setUser(evn.getProperty("jdbc.user"));
        dataSource.setPassword("${jdbc.password}");*/

        dataSource.setJdbcUrl(evn.getProperty("jdbc.url"));
        dataSource.setDriverClass(evn.getProperty("jdbc.driver"));
        dataSource.setUser(evn.getProperty("jdbc.user"));
        dataSource.setPassword(evn.getProperty("jdbc.password"));
        return dataSource;
    }

    //配置Mybatis
    @Bean
    public SqlSessionFactoryBean mybatisConf() throws PropertyVetoException, IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //多个的
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        //单一的
        //sqlSessionFactoryBean.setMapperLocations(new Resource[]{new ClassPathResource("mapper/AuthorMapper.xml")});

        sqlSessionFactoryBean.setTypeAliasesPackage("com.nf147.sim.entity");
        return sqlSessionFactoryBean;
    }

    //mapper注入
    @Bean
    public MapperScannerConfigurer n() throws PropertyVetoException {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mybatisConf");
        mapperScannerConfigurer.setBasePackage("com.nf147.sim.dao");
        return mapperScannerConfigurer;
    }

    /*<!--配置声明式事务管理-->*/
    @Bean
    public DataSourceTransactionManager transactionManager() throws PropertyVetoException {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.evn= environment;
    }
}
