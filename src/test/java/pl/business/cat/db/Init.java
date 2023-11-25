package pl.business.cat.db;

import static org.junit.Assert.assertTrue;

import java.security.spec.DSAGenParameterSpec;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import oracle.jdbc.pool.OracleDataSource;
import pl.business.cat.Config;
import pl.business.cat.PropertiesApp;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = Config.class)
@SpringBootTest(classes = Config.class)
public class Init {

	@Autowired
	Config config;
	
	@Test
	public void isConnected() {
		PropertiesApp pApp = config.getProps();
		//DataSource dSource = config.dataSource();
		try {
			OracleDataSource ods = new OracleDataSource();
			//ods.setDriverType(pApp.getDriver());
			//ods.setDataSourceName(url);
			//ods.setURL(pApp.getDbUrl());
			//System.out.println(ods.getURL());
			//assertTrue(ods.getConnection().isValid(5000));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
