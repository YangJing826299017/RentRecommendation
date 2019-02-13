package timertask;

import java.io.IOException;
import java.util.TimerTask;

import dao.RoomUrlDao;
import entity.Room;
import util.AnalyzeAnjukeRoomUtil;
import util.AnalyzeLeYouJiaRoomUtil;
import util.FileUtil;
import util.HttpUtil;

public class AnalyzeLeYouJiaRoomTimerTask extends TimerTask{
	private RoomUrlDao roomUrlDao=new RoomUrlDao();

	@Override
	public void run() {
		//1.从数据库读取一条房间url
		String url=roomUrlDao.selectRoomUrlByUtilName("乐有家");
		//2.用Http请求获取html
		String htmlContent="";
		htmlContent=HttpUtil.doGet(url);
		//3.用RoomUtil转化为对应的实体
		Room room=AnalyzeLeYouJiaRoomUtil.getResult(htmlContent, url);
		//4.将room对应的json格式文件写入txt中
		try {
			FileUtil.writeInFile("E:\\rent_recommendation\\leyoujia",room.getRoomName()+".txt", room.toGson(), false);
			//5.将对应的url设置为已读
			roomUrlDao.readUrl(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
