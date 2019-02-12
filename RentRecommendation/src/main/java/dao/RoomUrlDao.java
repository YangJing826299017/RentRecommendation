package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
