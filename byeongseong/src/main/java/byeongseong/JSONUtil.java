package byeongseong;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray; 
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
public class JSONUtil {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public JSONUtil() {
		
	}
	public JSONObject makeJSON() throws IOException {
		JSONObject sendObject = new JSONObject();
		JSONArray sendArray = new JSONArray();
		for(int i = 0; i < 10 ;i++){
			JSONObject informationObject = new JSONObject();
			informationObject.put("name","병성" + i);
			informationObject.put("number", i+1);
			sendArray.put(informationObject);
		}
		sendObject.put("list",sendArray);
		return sendObject;
	}
	public JSONObject getAllShopList() throws NamingException, SQLException {
		con = DBManager.getConnection();
		String sql = "SELECT number,name,score,menutable,info,category FROM shoplist";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		JSONObject res = new JSONObject();
		JSONArray arr = new JSONArray();
		while(rs.next()) {
			int number = rs.getInt("number");
			String name = rs.getString("name");
			float score = rs.getFloat("score");
			String menutable = rs.getString("menutable");
			String info = rs.getString("info");
			Integer category = rs.getInt("category");
			JSONObject obj = new JSONObject();
			obj.put("number", number);
			obj.put("name", name);
			obj.put("score", score);
			obj.put("menutable", menutable);
			obj.put("info", info);
			obj.put("category", category);
			arr.put(obj);
		}
		res.put("list", arr);
		close();
		return res;
	}
	public JSONObject searchShopList(int key) throws NamingException, SQLException {
		con = DBManager.getConnection();
		String sql = "SELECT number,name,score,menutable,info,category FROM shoplist WHERE category = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, key);
		rs = pstmt.executeQuery();
		JSONObject res = new JSONObject();
		JSONArray arr = new JSONArray();
		while(rs.next()) {
			int number = rs.getInt("number");
			String name = rs.getString("name");
			float score = rs.getFloat("score");
			String menutable = rs.getString("menutable");
			String info = rs.getString("info");
			Integer category = rs.getInt("category");
			JSONObject obj = new JSONObject();
			obj.put("number", number);
			obj.put("name", name);
			obj.put("score", score);
			obj.put("menutable", menutable);
			obj.put("info", info);
			obj.put("category", category);
			arr.put(obj);
		}
		res.put("list", arr);
		close();
		return res;
	}
	public JSONObject searchMenuList(String key) throws NamingException, SQLException{
		con = DBManager.getConnection();
		String sql = "SELECT idx,name,price,img FROM "+key;
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		JSONObject res = new JSONObject();
		JSONArray arr = new JSONArray();
		while(rs.next()) {
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			String img = rs.getString("img");
			JSONObject obj = new JSONObject();
			obj.put("idx", idx);
			obj.put("name", name);
			obj.put("price", price);
			obj.put("img", img);
			arr.put(obj);
		}
		res.put("list", arr);
		close();
		return res;
	}
	public void addShop(ShopData sdt) throws NamingException, SQLException {
		con = DBManager.getConnection();
		String sql = "INSERT INTO shoplist(number,name,score,menutable,info,category) VALUES(?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, sdt.getNumber());
		pstmt.setString(2, sdt.getName());
		pstmt.setFloat(3, sdt.getScore());
		pstmt.setString(4, sdt.getMenutable());
		pstmt.setString(5, sdt.getInfo());
		pstmt.setInt(6, sdt.getCategory());
		pstmt.execute();
	}
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//if(con != null) con.close();
	}
}
