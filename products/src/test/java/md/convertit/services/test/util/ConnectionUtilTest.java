package md.convertit.services.test.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import md.convertit.products.util.ConnectionUtil;

public class ConnectionUtilTest {
	
	@Test
	public void testGetConnection() throws SQLException{
		
		//ontin conexiunea
		Connection connection = ConnectionUtil.getConnection();
		
		//verioficam sa nu fi enull
		Assert.assertNotNull(connection);
	}

}
