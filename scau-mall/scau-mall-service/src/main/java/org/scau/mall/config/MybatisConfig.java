package org.scau.mall.config;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.github.pagehelper.PageHelper;

import javax.sql.DataSource;

/**
 * <p>
 * 数据库连接配置
 * </p>
 *
 * @author Merlin
 * @version 1.0
 */
@Configuration
@MapperScan("org.scau.mall.dao")
public class MybatisConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPlugins(new Interceptor[]{new PageHelper()});
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:org/scau/mall/service/mapper/**/*.xml"));
        return sessionFactory.getObject();
    }

}
