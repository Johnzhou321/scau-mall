package org.scau.mall.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"org.scau.mall"})
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class MallWebApplication 
{
	public static void main(String[] args) {
	    SpringApplication.run(MallWebApplication.class, args);
	  }
}
