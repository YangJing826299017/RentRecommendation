package timertask;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.TimerTask;

import dao.PageUrlDao;
import dao.RoomUrlDao;
import util.AnalyzeGanJiPageUtil;
import util.HttpUtil;

public class AnalyzeGanjiPageTimerTask extends TimerTask{
	
	private PageUrlDao pageDao=new PageUrlDao();
	private RoomUrlDao roomUrlDao=new RoomUrlDao();

	//对赶集网租房首页进行爬虫并录入数据库(赶集网比较特别,首页的内容是随机变换的,所以只要访问第一页即可)
	@Override
	public void run() {
		//1.获取赶集网租房首页URL
		String url=getGanjiPageUrl();
		//2.获取网页HTML
		String htmlContent=HttpUtil.doGet(url);
		//3.工具类进行分析
		List<String> listUrl=AnalyzeGanJiPageUtil.getResult(htmlContent);
		//4.将URL存入数据库
		for(String roomUrl:listUrl) {
			roomUrlDao.insertRoomUrl(roomUrl,"赶集网",false);
		}
		pageDao.insertPageUrl(url,"赶集网");
	}
	
	private String getGanjiPageUrl() {
		String url="http://sz.ganji.com/zufang/pn1/";
		return url;
	}

}
