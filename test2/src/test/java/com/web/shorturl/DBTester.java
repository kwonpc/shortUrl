package com.web.shorturl;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class DBTester {
	@Inject
	private DataSource ds;
	
	@Test
	public void dbTester() throws Exception {

		try(Connection con = ds.getConnection()){
			System.out.println(con);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
