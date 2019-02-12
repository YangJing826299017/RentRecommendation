package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import databse.DatabaseUtil;

public class RoomUrlDao {
	
	private Connection connection;
	
	public void insertRoomUrl(String roomUrl,String util,boolean isRead){
		connection=DatabaseUtil.getConnection();
		try {
			PreparedStatement pstm=connection.prepareStatement("insert into room_url(url,util,is_read) values(?,?,?)");
			pstm.setString(1,roomUrl);
			pstm.setString(2,util);
			pstm.setBoolean(3,isRead);
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
	
	public String selectRoomUrlByUtilName(String utilName) {
		connection=DatabaseUtil.getConnection();
		try {
			PreparedStatement pstm=connection.prepareStatement("select * from room_url where util=? and is_read=0");
			pstm.setString(1,utilName);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				String url=rs.getString("url");
				return url;
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
		return "";
	}
	
	public void readUrl(String url) {
		connection=DatabaseUtil.getConnection();
		try {
			PreparedStatement pstm=connection.prepareStatement("update room_url set is_read=1 where url=?");
			pstm.setString(1,url);
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
 
}
