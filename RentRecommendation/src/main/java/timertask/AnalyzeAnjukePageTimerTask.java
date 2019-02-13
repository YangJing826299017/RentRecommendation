package timertask;

import java.util.List;
import java.util.TimerTask;

import dao.PageUrlDao;
import dao.RoomUrlDao;
import util.AnalyzeAnjukePageUtil;
import util.HttpUtil;

public class AnalyzeAnjukePageTimerTask extends TimerTask{
	private static int count=0;
	private PageUrlDao pageDao=new PageUrlDao();
	private RoomUrlDao roomUrlDao=new RoomUrlDao();
	
	@Override
	public void run() {
		//1.获取url
		String url=getAnjukePageUrl();
		//2.获取html
		String htmlContent=HttpUtil.doGet(url);
		//3.用工具类进行分析
		List<String> listUrl=AnalyzeAnjukePageUtil.getResult(htmlContent);
		//4。.写入room_url数据库
		for(String roomUrl:listUrl) {
			roomUrlDao.insertRoomUrl(roomUrl,"安居客",false);
		}
		//5.写入page_url数据库
		pageDao.insertPageUrl(url,"安居客");
	}
	
	private String getAnjukePageUrl() {
		String url="";
		while(true) {
			count++;
			url="https://sz.zu.anjuke.com/fangyuan/p"+count+"/";
			if(pageDao.isHasPageUrl(url)) {
				continue;
			}else {
				break;
			}
		}
		return url;
	}

}
