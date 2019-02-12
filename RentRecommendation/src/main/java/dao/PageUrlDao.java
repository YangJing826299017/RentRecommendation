package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databse.DatabaseUtil;

public class PageUrlDao {
	
	private Connection connection;
	
	public void insertPageUrl(String pageUrl,String util){
		connection=DatabaseUtil.getConnection();
		try {
			PreparedStatement pstm=connection.prepareStatement("insert into page_url(page_url,util) values(?,?)");
			pstm.setString(1,pageUrl);
			pstm.setString(2,util);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isHasPageUrl(String url) {
		connection=DatabaseUtil.getConnection();
		try {
			PreparedStatement pstm=connection.prepareStatement("select * from page_url where page_url=?");
			pstm.setString(1,url);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
