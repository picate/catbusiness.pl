package pl.business.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("pl.business.cat")
//@PropertySource("classpath:application.properties")
public class Config {

	@Autowired
	Environment env;
	
	@Bean
	public PropertiesApp getProps() {
		return new PropertiesApp(env.getProperty("spring.datasource.url"),env.getProperty("DB_URL"),env.getProperty("DRIVER"));	
	}
	/*@Bean
	public DataSource dataSource() {
	      DriverManagerDataSource ds = new DriverManagerDataSource();
	      ds.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
	      String path = System.getProperty("user.dir").replace('\\','/')+"/src/main/resources/Wallet_picatepl";
	       ds.setUrl("jdbc:oracle:thin:@test_medium?TNS_ADMIN=" + path);
	      ds.setUsername("admin");
	      ds.setPassword("");
	      return ds;
	}*/
}
