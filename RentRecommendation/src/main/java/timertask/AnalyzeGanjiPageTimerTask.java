package timertask;

import java.io.IOException;
import java.util.List;
import java.util.TimerTask;

import util.AnalyzeGanJiPageUtil;
import util.FileUtil;
import util.HttpUtil;

public class AnalyzeGanjiPageTimerTask extends TimerTask{
	
	private static int count=0;

	//对赶集网租房首页进行爬虫并录入数据库
	@Override
	public void run() {
		//1.获取赶集网租房首页URL
		String url=getGanjiPageUrl();
		//2.获取网页HTML
		String htmlContent=HttpUtil.doGet(url);
		//3.工具类进行分析
		List<String> listUrl=AnalyzeGanJiPageUtil.getResult(htmlContent);
		//4.将URL存入数据库
		for(String oneUrl:listUrl) {
			System.out.println("获取Url:"+oneUrl);
			try {
				FileUtil.writeInFile("D:\\yangjing\\test","赶集网房屋url列表.txt", oneUrl,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private String getGanjiPageUrl() {
		count++;
		return "http://sz.ganji.com/zufang/pn"+count+"/";
	}

}
