package byeongseong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	public static Connection getConnection() throws NamingException, SQLException {
		if(con != null) return con;
		Context initContext = new InitialContext();
		DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/mydbTest");
		return con = ds.getConnection();
	}
	public static void insertShopData(ShopData sdt) throws NamingException, SQLException {
		if(con == null) getConnection();
		String sql = "INSERT INTO shoplist(number,name,score,menutable,info,category) VALUES(?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, sdt.getNumber());
		pstmt.setString(2, sdt.getName());
		pstmt.setFloat(3, sdt.getScore());
		pstmt.setString(4, sdt.getMenutable());
		pstmt.setString(5, sdt.getInfo());
		pstmt.setInt(6, sdt.getCategory());
		pstmt.execute();
		pstmt.close();
	}
	public static void createMenuList(String name) throws NamingException, SQLException {
		if(con == null) getConnection();
		String sql = "CREATE TABLE "+name +"(idx INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name TEXT NOT NULL, price INT NOT NULL, img TEXT)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.execute();
		pstmt.close();
	}
	
}
