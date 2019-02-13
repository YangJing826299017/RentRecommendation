package timertask;

import java.util.List;
import java.util.TimerTask;

import dao.PageUrlDao;
import dao.RoomUrlDao;
import util.AnalyzeLeYouJiaPageUtil;
import util.HttpUtil;

public class AnalyzeLeYouJiaPageTimerTask extends TimerTask{
	
	private PageUrlDao pageDao=new PageUrlDao();
	private RoomUrlDao roomUrlDao=new RoomUrlDao();
	private static int count=0;

	@Override
	public void run() {
		//1.获取赶集网租房首页URL
		String url=getLeYouJiaPageUrl();
		//2.获取网页HTML
		String htmlContent=HttpUtil.doGet(url);
		//3.工具类进行分析
		List<String> listUrl=AnalyzeLeYouJiaPageUtil.getResult(htmlContent);
		//4.将URL存入数据库
		for(String roomUrl:listUrl) {
			roomUrlDao.insertRoomUrl(roomUrl,"乐有家",false);
		}
		pageDao.insertPageUrl(url,"乐有家");
	}
	
	private String getLeYouJiaPageUrl() {
		String url="";
		while(true) {
			count++;
			url="https://shenzhen.leyoujia.com/zf/?n="+count;
			if(pageDao.isHasPageUrl(url)) {
				continue;
			}else {
				break;
			}
		}
		return url;
	}

}
